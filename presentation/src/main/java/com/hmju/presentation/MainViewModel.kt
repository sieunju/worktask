package com.hmju.presentation

import androidx.lifecycle.ViewModel
import com.hmju.domain.usecase.MainSectionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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

}
