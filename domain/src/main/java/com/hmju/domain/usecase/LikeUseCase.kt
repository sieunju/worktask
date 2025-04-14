package com.hmju.domain.usecase

import com.hmju.domain.repository.LikeRepository
import com.hmju.domain.shared.LikeManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Description : 찜하기 목록 UseCase
 *
 * Created by juhongmin on 2025. 4. 13.
 */
class LikeUseCase @Inject constructor(
    private val repository: LikeRepository
) {
    operator fun invoke(): Flow<List<Int>> {
        return flow {
            val ids = repository.fetchIds()
            LikeManager.addAll(ids)
            emit(ids)
        }
    }
}