package pl.wspologarniacz.mobile.auth.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.experimental.launch
import pl.wspologarniacz.mobile.auth.repository.model.User
import pl.wspologarniacz.mobile.common.repository.model.*
import pl.wspologarniacz.mobile.common.utils.asyncResult
import javax.inject.Singleton

@Singleton
class AuthRepository(private val authApi: AuthApi) {

    private val TAG = "AuthRepository"

    val loadState = MutableLiveData<LoadState>().apply {
        value = Idle()
    }

    fun login(email: String, password: String) {
        loadState.inProgress()
        launch {
            authApi.login(User(email, password)).asyncResult(loadState::error) {
                Log.i(TAG, "Token ${this}")
                loadState.done()
            }
        }

    }

    fun register(email: String, password: String, username: String) {
        loadState.inProgress()
        launch {
            authApi.register(User(email, password, username)).asyncResult(loadState::error) {
                loadState.done()
            }
        }
    }

    fun forgotPassword(email: String) {
        loadState.inProgress()
        launch {
            authApi.forgotPassword(User(email)).asyncResult(loadState::error) {
                loadState.done()
            }
        }
    }


}