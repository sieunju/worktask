package com.hmju.data.impl

import com.hmju.data.remote.apis.SectionApiService
import com.hmju.domain.models.SectionResponse
import com.hmju.domain.params.SectionParams
import com.hmju.domain.repository.SectionRepository
import javax.inject.Inject

internal class SectionRepositoryImpl @Inject constructor(
    private val apiService: SectionApiService
) : SectionRepository {

    override suspend fun fetch(
        params: SectionParams
    ): Result<SectionResponse> {
        TODO("Not yet implemented")
    }
}
