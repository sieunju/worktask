package com.hmju.data.repository

import com.hmju.domain.models.SectionData
import com.hmju.domain.params.SectionParams
import com.hmju.domain.repository.SectionRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import timber.log.Timber
import javax.inject.Inject

/**
 * Description : Section Repository Test
 *
 * Created by juhongmin on 2025. 4. 13.
 */
@HiltAndroidTest
internal class SectionRepositoryTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repository: SectionRepository

    @Before
    fun init() {
        Timber.uprootAll() // 기존 트리 제거
        Timber.plant(object : Timber.Tree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                println("${tag}:${message}")
            }
        })
        hiltRule.inject()
    }

    @Test
    fun test_repository() {
        val params = SectionParams()
        runBlocking {
            val list = mutableListOf<SectionData>()
            var isEnd = false
            while (!isEnd) {
                val res = repository.fetch(params).getOrThrow()
                if (res.hasNextPage) {
                    list.addAll(res.list)
                    params.pageNo++
                } else {
                    isEnd = true
                }
            }
            assert(list.isNotEmpty())
        }
    }
}
