package com.hmju.data.api_service

import com.hmju.data.remote.apis.SectionApiService
import com.hmju.data.remote.transformResponse
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidTest
internal class SectionApiServiceTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiService: SectionApiService

    @Before
    fun init() {
        Timber.uprootAll() // 기존 트리 제거
        Timber.plant(object : Timber.Tree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                if (tag.isNullOrEmpty()) {
                    println(message)
                } else {
                    println("${tag}:${message}")
                }
            }
        })
        hiltRule.inject()
    }

    @Test
    fun test_section() {
        runBlocking {
            val res = apiService.fetchSelection(1)
                .transformResponse { it.list to it.meta }
            assert(res.isSuccess)
        }
    }

    @Test
    fun test_section_error(){
        runBlocking {
            val res = apiService.fetchSelection(0)
                .transformResponse { it.list to it.meta }
            assert(res.isFailure)
        }
    }
}