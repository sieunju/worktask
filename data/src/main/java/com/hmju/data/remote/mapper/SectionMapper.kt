package com.hmju.data.remote.mapper

import com.hmju.data.remote.entity.SectionEntity
import com.hmju.domain.enums.ProductViewType
import com.hmju.domain.models.SectionData

/**
 * Description : Entity -> Data Model Mapper
 *
 * Created by juhongmin on 2025. 4. 13.
 */
internal object SectionMapper {

    fun SectionEntity.toMap(
    ): SectionData? {
        val type = ProductViewType.from(type) ?: return null
        return SectionData(
            title = title,
            id = id,
            productType = type
        )
    }
}
