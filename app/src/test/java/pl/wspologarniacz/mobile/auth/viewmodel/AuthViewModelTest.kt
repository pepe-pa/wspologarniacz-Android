package pl.wspologarniacz.mobile.auth.viewmodel

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify
import pl.wspologarniacz.mobile.auth.repository.AuthRepository

class AuthViewModelTest {

    private lateinit var viewModel: AuthViewModel
    private val authRepository = Mockito.mock(AuthRepository::class.java)

    private val email = "email@mail.pl"
    private val password = "secret"
    private val username = "name"

    @Before
    fun setUp() {
        viewModel = AuthViewModel(authRepository)
    }

    @Test
    fun login() {
        viewModel.login(email, password)
        verify(authRepository).login(email, password)
    }

    @Test
    fun forgotPassword() {
        viewModel.forgotPassword(email)
        verify(authRepository).forgotPassword(email)
    }

    @Test
    fun register() {
        viewModel.register(email, password, username)
        verify(authRepository).register(email, password, username)
    }
}