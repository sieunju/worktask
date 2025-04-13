package com.hmju.data.impl

import com.hmju.data.remote.apis.ProductApiService
import com.hmju.data.remote.mapper.ProductMapper.toMap
import com.hmju.data.remote.transformResponse
import com.hmju.domain.models.ProductData
import com.hmju.domain.repository.ProductRepository
import javax.inject.Inject

internal class ProductRepositoryImpl @Inject constructor(
    private val apiService: ProductApiService
) : ProductRepository {
    
    override suspend fun fetch(id: Int): Result<List<ProductData>> {
        return apiService.fetchProducts(id)
            .transformResponse { res -> res.list.map { it.toMap() } }
    }
}