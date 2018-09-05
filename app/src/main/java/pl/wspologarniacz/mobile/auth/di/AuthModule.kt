package pl.wspologarniacz.mobile.auth.di

import dagger.Module
import dagger.Provides
import pl.wspologarniacz.mobile.auth.repository.AuthApi
import pl.wspologarniacz.mobile.auth.viewmodel.AuthViewModel
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AuthModule {

    @Provides
    @Singleton
    fun authApi(retrofit: Retrofit) = retrofit.create(AuthApi::class.java)

    @Provides
    @Singleton
    fun viewModelFactory(viewModel: AuthViewModel) = ViewModelFactory(viewModel)

}