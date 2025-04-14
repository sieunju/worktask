package com.hmju.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hmju.domain.models.MainSectionState
import com.hmju.domain.params.SectionParams
import com.hmju.domain.usecase.AddLikeUseCase
import com.hmju.domain.usecase.LikeUseCase
import com.hmju.domain.usecase.MainSectionUseCase
import com.hmju.domain.usecase.RemoveLikeUseCase
import com.hmju.presentation.listener.LikeListener
import com.hmju.presentation.models.BaseUiModel
import com.hmju.presentation.models.PagingModel
import com.hmju.presentation.models.VerticalLoadingUiModel
import com.hmju.presentation.util.ListLiveData
import com.hmju.presentation.util.UiMapper.toUiModels
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Description : 메인 화면 ViewModel
 *
 * Created by juhongmin on 2025. 4. 13.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: MainSectionUseCase,
    private val likeUseCase: LikeUseCase,
    private val addLikeUseCase: AddLikeUseCase,
    private val removeLikeUseCase: RemoveLikeUseCase
) : ViewModel(), LikeListener {

    private val _uiState: MutableLiveData<MainSectionState> by lazy { MutableLiveData() }
    val uiState: LiveData<MainSectionState> get() = _uiState
    private val params: SectionParams by lazy { SectionParams() }
    val pagingModel: PagingModel by lazy { PagingModel() }
    private val _uiList: ListLiveData<BaseUiModel> by lazy { ListLiveData() }
    val uiList: ListLiveData<BaseUiModel> get() = _uiList
    private var job: Job? = null

    fun start() {
        _uiList.clear()
        params.pageNo = 1
        pagingModel.initParams()
        reqData()
    }

    fun onLoadPage() {
        pagingModel.isLoading = true
        _uiList.add(VerticalLoadingUiModel())
        reqData()
    }

    private fun reqData() {
        job?.cancel()
        job = if (params.pageNo == 1) {
            combine(useCase(params), likeUseCase()) { state, _ ->
                state
            }.catch { emit(MainSectionState.Error(it.message ?: "잠시 후 다시 이용해 주세요.")) }
                .onEach { handleUiState(it) }
                .launchIn(viewModelScope)
        } else {
            useCase(params)
                .catch { emit(MainSectionState.Error(it.message ?: "잠시 후 다시 이용해 주세요.")) }
                .onEach { handleUiState(it) }
                .launchIn(viewModelScope)
        }
    }

    private fun handleUiState(
        newState: MainSectionState
    ) {
        _uiState.value = newState
        removeLoadingUiModel()
        when (newState) {
            is MainSectionState.Content -> {
                _uiList.addAll(newState.list.map { it.toUiModels() }.flatten())
                params.pageNo++
                pagingModel.isLoading = false
                pagingModel.isLast = !newState.hasNextPage
            }

            else -> Unit
        }
    }

    private fun removeLoadingUiModel() {
        val list = uiList.value
        if (list.lastOrNull() is VerticalLoadingUiModel) {
            _uiList.removeAt(list.lastIndex)
        }
    }

    override fun onAddLike(id: Int) {
        viewModelScope.launch {
            addLikeUseCase(id)
        }
    }

    override fun onRemoveLike(id: Int) {
        viewModelScope.launch {
            removeLikeUseCase(id)
        }
    }
}
