package com.hmju.data.remote.apis

import com.hmju.data.remote.entity.ApiPagedListResponse
import com.hmju.data.remote.entity.SectionEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface SectionApiService {

    @GET("sections")
    suspend fun fetchSelections(
        @Query("page") pageNo: Int
    ): Response<ApiPagedListResponse<SectionEntity>>
}
