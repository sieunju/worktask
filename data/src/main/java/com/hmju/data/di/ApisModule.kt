package com.hmju.data.di

import com.hmju.data.remote.apis.ProductApiService
import com.hmju.data.remote.apis.SectionApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [NetworkModule::class])
internal object ApisModule {

    @Singleton
    @Provides
    fun provideProductApiService(
        retrofit: Retrofit
    ): ProductApiService {
        return retrofit.create()
    }

    @Singleton
    @Provides
    fun provideSectionApiService(
        retrofit: Retrofit
    ): SectionApiService {
        return retrofit.create()
    }
}