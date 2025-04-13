package com.hmju.data.di

import com.hmju.data.impl.LikeRepositoryImpl
import com.hmju.data.impl.ProductRepositoryImpl
import com.hmju.data.impl.SectionRepositoryImpl
import com.hmju.domain.repository.LikeRepository
import com.hmju.domain.repository.ProductRepository
import com.hmju.domain.repository.SectionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [ApisModule::class, UtilModule::class])
internal abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindProductRepository(
        impl: ProductRepositoryImpl
    ): ProductRepository

    @Singleton
    @Binds
    abstract fun bindSectionRepository(
        impl: SectionRepositoryImpl
    ): SectionRepository

    @Singleton
    @Binds
    abstract fun bindLikeRepository(
        impl: LikeRepositoryImpl
    ): LikeRepository
}