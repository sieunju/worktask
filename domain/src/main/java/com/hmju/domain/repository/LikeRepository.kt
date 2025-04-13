package com.hmju.domain.repository

/**
 * Description : 상품 찜하기 Repository
 *
 * Created by juhongmin on 2025. 4. 13.
 */
interface LikeRepository {
    suspend fun fetchIds(): List<Long>
    suspend fun add(id: Long): Boolean
    suspend fun remove(id: Long): Boolean
    suspend fun clear()
}
