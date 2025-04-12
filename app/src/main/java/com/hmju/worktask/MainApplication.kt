package com.hmju.worktask

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Description : MainApplication
 *
 * Created by juhongmin on 2025. 4. 13.
 */
@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
