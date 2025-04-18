package com.hmju.domain.usecase

import com.hmju.domain.repository.LikeRepository
import com.hmju.domain.shared.LikeManager
import javax.inject.Inject

/**
 * Description : 찜하기 제거 UseCase
 *
 * Created by juhongmin on 2025. 4. 13.
 */
class RemoveLikeUseCase @Inject constructor(
    private val repository: LikeRepository
) {
    suspend operator fun invoke(id: Int): Boolean {
        val result = repository.remove(id)
        LikeManager.remove(id)
        return result
    }
}