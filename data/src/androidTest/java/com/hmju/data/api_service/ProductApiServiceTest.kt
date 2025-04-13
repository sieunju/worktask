package com.hmju.data.api_service

import com.hmju.data.remote.apis.ProductApiService
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
internal class ProductApiServiceTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiService: ProductApiService

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
    fun test_product() {
        runBlocking {
            val res = apiService.fetchProduct(1)
                .transformResponse { it.list }
            assert(res.isSuccess)
        }
    }

    @Test
    fun test_product_error(){
        runBlocking {
            val res = apiService.fetchProduct(0)
                .transformResponse { it.list }
            assert(res.isFailure)
        }
    }
}
