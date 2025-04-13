package com.hmju.data.di

import android.content.Context
import com.hmju.data.impl.PreferenceManagerImpl
import com.hmju.data.local.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object UtilModule {
    @Provides
    @Singleton
    fun providePrefManager(
        @ApplicationContext context: Context
    ) : PreferenceManager {
        return PreferenceManagerImpl(context)
    }
}
