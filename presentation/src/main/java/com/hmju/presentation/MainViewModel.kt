package com.hmju.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hmju.domain.models.MainSectionState
import com.hmju.domain.params.SectionParams
import com.hmju.domain.usecase.MainSectionUseCase
import com.hmju.presentation.models.BaseUiModel
import com.hmju.presentation.models.PagingModel
import com.hmju.presentation.util.ListLiveData
import com.hmju.presentation.util.UiMapper.toUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

/**
 * Description :
 *
 * Created by juhongmin on 2025. 4. 13.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: MainSectionUseCase
) : ViewModel() {

    private val params: SectionParams by lazy { SectionParams() }
    val pagingModel: PagingModel by lazy { PagingModel() }
    private val _uiList: ListLiveData<BaseUiModel> by lazy { ListLiveData() }
    val uiList: ListLiveData<BaseUiModel> get() = _uiList

    fun start() {
        _uiList.clear()
        params.pageNo = 1
        pagingModel.initParams()
        useCase(params)
            .onEach { handleUiState(it) }
            .launchIn(viewModelScope)
    }

    fun onLoadPage() {
        pagingModel.isLoading = true
        useCase(params)
            .onEach { handleUiState(it) }
            .launchIn(viewModelScope)
    }

    private fun handleUiState(
        newState: MainSectionState
    ) {
        when (newState) {
            is MainSectionState.Loading -> {

            }

            is MainSectionState.Content -> {
                Timber.d("Contents ${newState.list.map { it.id }}")
                _uiList.addAll(newState.list.map { it.toUi() })
                params.pageNo++
                pagingModel.isLoading = false
                pagingModel.isLast = !newState.hasNextPage
            }

            is MainSectionState.Error -> {

            }
        }
    }
}
