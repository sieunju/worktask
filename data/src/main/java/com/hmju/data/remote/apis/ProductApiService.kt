package com.hmju.data.remote.apis

import com.hmju.data.remote.entity.ApiListResponse
import com.hmju.data.remote.entity.ProductEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ProductApiService {

    @GET("section/products")
    suspend fun fetchProduct(
        @Query("sectionId") id: Int
    ): Response<ApiListResponse<ProductEntity>>
}
