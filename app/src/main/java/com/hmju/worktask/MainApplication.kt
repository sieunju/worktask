package com.hmju.worktask

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Description : MainApplication
 *
 * Created by juhongmin on 2025. 4. 13.
 */
@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        Timber.plant(object : Timber.DebugTree() {

            override fun createStackElementTag(element: StackTraceElement): String {
                val str = StringBuilder("Timber")
                try {
                    str.append(" ")
                    str.append(element.methodName.substringAfterLast("."))
                } catch (_: Exception) {

                }
                return str.toString()
            }
        })
    }
}
