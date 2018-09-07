package pl.wspologarniacz.mobile.auth.di

import dagger.Module
import dagger.Provides
import pl.wspologarniacz.mobile.auth.repository.AuthApi
import pl.wspologarniacz.mobile.auth.repository.AuthRepository
import pl.wspologarniacz.mobile.auth.viewmodel.AuthViewModel
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import retrofit2.Retrofit

@Module
class AuthModule {

    @Provides
    @AuthScope
    fun authApi(retrofit: Retrofit) = retrofit.create(AuthApi::class.java)

    @Provides
    @AuthScope
    fun repository(authApi: AuthApi) = AuthRepository(authApi)

    @Provides
    @AuthScope
    fun viewModel(authRepository: AuthRepository) = AuthViewModel(authRepository)

    @Provides
    @AuthScope
    fun viewModelFactory(viewModel: AuthViewModel) = ViewModelFactory(viewModel)

}