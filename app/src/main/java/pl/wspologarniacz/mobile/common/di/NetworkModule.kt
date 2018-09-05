package pl.wspologarniacz.mobile.common.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesConverter(): Converter.Factory {
        return MoshiConverterFactory.create()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(converterFactory: Converter.Factory, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().addCallAdapterFactory(CoroutineCallAdapterFactory()).addConverterFactory(converterFactory).baseUrl("").client(okHttpClient).build()
    }
}