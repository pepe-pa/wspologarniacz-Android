package pl.wspologarniacz.mobile.auth.repository

import kotlinx.coroutines.experimental.launch
import pl.wspologarniacz.mobile.auth.repository.model.User
import javax.inject.Singleton

@Singleton
class AuthRepository(private val authApi: AuthApi) {

    fun login(email: String, password: String) {
        launch {
            authApi.login(User(email)).await()
        }
    }

    fun register(email: String, password: String, username: String) {
        launch {
            authApi.register(User(email, password, username))
        }
    }

    fun forgotPassword(email: String) {
        launch {
            authApi.forgotPassword(User(email))
        }
    }
}