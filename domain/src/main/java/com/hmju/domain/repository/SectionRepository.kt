package com.hmju.domain.repository

import com.hmju.domain.models.SectionResponse
import com.hmju.domain.params.SectionParams

/**
 * Description : 섹션 Repository
 *
 * Created by juhongmin on 2025. 4. 13.
 */
interface SectionRepository {
    /**
     * 섹션 조회
     * @param params 섹션 QueryParams
     */
    suspend fun fetch(params: SectionParams): Result<SectionResponse>
}
