package com.hmju.data.remote

import com.hmju.data.remote.entity.ApiListResponse
import com.hmju.data.remote.entity.ApiPagedListResponse
import retrofit2.Response

@JvmName("transformResponse_pagedListType")
internal inline fun <reified I, reified O> Response<ApiPagedListResponse<I>>.transformResponse(
    predicate: (ApiPagedListResponse<I>) -> O
): Result<O> {
    if (isSuccessful) {
        val body = body() ?: return Result.failure(Exception("Invalidate Cast Exception"))
        try {
            val data = predicate(body)
            return Result.success(data)
        } catch (ex: Exception) {
            return Result.failure(ex)
        }
    }
    return Result.failure(Exception(message()))
}

@JvmName("transformResponse_listType")
internal inline fun <reified I, reified O> Response<ApiListResponse<I>>.transformResponse(
    predicate: (ApiListResponse<I>) -> O
): Result<O> {
    if (isSuccessful) {
        val body = body() ?: return Result.failure(Exception("Invalidate Cast Exception"))
        try {
            val data = predicate(body)
            return Result.success(data)
        } catch (ex: Exception) {
            return Result.failure(ex)
        }
    }
    return Result.failure(Exception(message()))
}