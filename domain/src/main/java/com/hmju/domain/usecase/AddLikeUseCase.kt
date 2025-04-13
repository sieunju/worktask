package com.hmju.domain.usecase

import com.hmju.domain.repository.LikeRepository
import javax.inject.Inject

/**
 * Description : 찜하기 추가 UseCase
 *
 * Created by juhongmin on 2025. 4. 13.
 */
class AddLikeUseCase @Inject constructor(
    private val repository: LikeRepository
) {
    suspend operator fun invoke(id: Int): Boolean {
        return repository.add(id)
    }
}