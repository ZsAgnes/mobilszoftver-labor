package com.example.news.data.network

import com.example.news.BuildConfig
import com.example.news.data.network.api.NewsApi
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    companion object {
        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .addNetworkInterceptor { chain ->
                    Thread.sleep(3000)
                    chain.proceed(chain.request())
                }
                .addNetworkInterceptor(StethoInterceptor())
                .build()
        }

        @Provides
        @Singleton
        fun provideMoshi(): Moshi = Moshi.Builder().build()

        @Provides
        @Singleton
        fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        }

        @Provides
        @Singleton
        fun provideNewsApi(retrofit: Retrofit): NewsApi {
            return retrofit.create()
        }
    }
}

