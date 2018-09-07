package pl.wspologarniacz.mobile.auth.viewmodel

import androidx.lifecycle.ViewModel
import pl.wspologarniacz.mobile.auth.repository.AuthRepository

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {


    fun login(email: String, password: String) {
        authRepository.login(email, password)
    }

    fun forgotPassword(email: String) {
        authRepository.forgotPassword(email)
    }


    fun register(email: String, password: String, userName: String) {
        authRepository.register(email, password, userName)
    }

}