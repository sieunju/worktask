package com.hmju.domain.repository

import com.hmju.domain.models.ProductData

/**
 * Description : 상품 Repository
 *
 * Created by juhongmin on 2025. 4. 13.
 */
interface ProductRepository {
    /**
     * 해당 섹션의 상품 조회
     * @param id Section ID
     */
    suspend fun fetch(id: Int): Result<List<ProductData>>
}