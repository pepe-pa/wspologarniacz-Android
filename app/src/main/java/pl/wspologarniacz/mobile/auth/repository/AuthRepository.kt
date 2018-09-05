package pl.wspologarniacz.mobile.auth.repository

import kotlinx.coroutines.experimental.launch
import pl.wspologarniacz.mobile.auth.repository.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
        private val authApi: AuthApi
) {

    fun login(email: String, password: String) {
        launch {
            authApi.login(User(email)).await()
        }
    }

    fun register(email: String, password: String) {

    }

    fun forgotPassword() {

    }
}