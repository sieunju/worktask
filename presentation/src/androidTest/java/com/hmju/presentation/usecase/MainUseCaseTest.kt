package com.hmju.presentation.usecase

import com.hmju.domain.params.SectionParams
import com.hmju.domain.usecase.MainSectionUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import timber.log.Timber
import javax.inject.Inject
import kotlin.time.measureTime

/**
 * Description :
 *
 * Created by juhongmin on 2025. 4. 13.
 */
@HiltAndroidTest
internal class MainUseCaseTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var usecase: MainSectionUseCase

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
    fun test_main_usecase() {
        val params = SectionParams()
        runBlocking {
            measureTime {
                usecase(params).collectLatest {
                    Timber.d("State:${it}")
                }
            }.also { Timber.d("TakeTime:${it}") }
        }
    }
}