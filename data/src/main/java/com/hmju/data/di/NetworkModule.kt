package com.hmju.data.di

import android.content.Context
import com.hmju.data.R
import com.hmju.data.qualifiers.HttpLogInterceptor
import com.hmju.data.qualifiers.HttpMockInterceptor
import com.kurly.android.mockserver.MockInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object NetworkModule {
    @Singleton
    @Provides
    fun provideJsonFormat(): Json = Json {
        isLenient = true // Json 큰따옴표 느슨하게 체크.
        ignoreUnknownKeys = true // Field 값이 없는 경우 무시
        coerceInputValues = true // "null" 이 들어간경우 default Argument 값으로 대체
    }

    @Singleton
    @Provides
    @HttpMockInterceptor
    fun provideMockInterceptor(
        @ApplicationContext context: Context
    ): Interceptor {
        return MockInterceptor(context)
    }

    @Singleton
    @Provides
    @HttpLogInterceptor
    fun provideHttpLogInterceptor(): Interceptor {
        return HttpLoggingInterceptor(
            logger = { Timber.tag("HTTP_LOG").d(it) }
        ).setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideHttpClient(
        @HttpMockInterceptor mockInterceptor: Interceptor,
        @HttpLogInterceptor logInterceptor: Interceptor
    ) : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .addInterceptor(mockInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        @ApplicationContext context: Context,
        httpClient: OkHttpClient,
        json: Json
    ) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.base_url))
            .client(httpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
}
