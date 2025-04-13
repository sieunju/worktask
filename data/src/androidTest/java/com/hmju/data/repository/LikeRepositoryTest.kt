package com.hmju.data.repository

import com.hmju.domain.repository.LikeRepository
import com.hmju.domain.repository.ProductRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import timber.log.Timber
import javax.inject.Inject

/**
 * Description : LikeRepository Test
 *
 * Created by juhongmin on 2025. 4. 13.
 */
@HiltAndroidTest
class LikeRepositoryTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repository: LikeRepository

    @Inject
    lateinit var productRepository: ProductRepository

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
    fun test_max_length() {
        runBlocking {
            val range = 5063110..(5063110 + 5000)
            for (idx in range) {
                repository.add(idx)
            }
            val list = repository.fetchIds()
            assert(range.count() > list.size)
        }
    }
}
