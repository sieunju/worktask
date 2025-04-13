package com.hmju.domain.usecase

import com.hmju.domain.models.MainSectionState
import com.hmju.domain.models.MainSectionState.Content
import com.hmju.domain.models.SectionData
import com.hmju.domain.models.SectionWithProductData
import com.hmju.domain.params.SectionParams
import com.hmju.domain.repository.ProductRepository
import com.hmju.domain.repository.SectionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Description : 메인 화면에 표시할 세션 UseCase
 *
 * Created by juhongmin on 2025. 4. 13.
 */
class MainSectionUseCase @Inject constructor(
    private val sectionRepository: SectionRepository,
    private val productRepository: ProductRepository
) {
    operator fun invoke(
        params: SectionParams
    ): Flow<MainSectionState> {
        return flow {
            if (params.pageNo == 1) {
                emit(MainSectionState.Loading)
            }
            val resSection = try {
                sectionRepository.fetch(params).getOrThrow()
            } catch (ex: Exception) {
                emit(MainSectionState.Error(ex.message ?: "Error"))
                return@flow
            }

            val state = coroutineScope {
                try {
                    val results = resSection.list
                        .map { async { reqSectionWithProduct(it) } }
                    Content(list = results.awaitAll(), hasNextPage = resSection.hasNextPage)
                } catch (ex: Exception) {
                    MainSectionState.Error(ex.message ?: "Error")
                }
            }
            emit(state)
        }.flowOn(Dispatchers.IO)
    }

    private suspend fun reqSectionWithProduct(
        section: SectionData
    ): SectionWithProductData {
        return withContext(Dispatchers.IO) {
            val list = productRepository.fetch(section.id).getOrNull() ?: listOf()
            SectionWithProductData(section, list)
        }
    }
}
