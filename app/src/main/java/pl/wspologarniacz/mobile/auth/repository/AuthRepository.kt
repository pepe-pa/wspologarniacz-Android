package pl.wspologarniacz.mobile.auth.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.experimental.launch
import pl.wspologarniacz.mobile.auth.repository.model.User
import pl.wspologarniacz.mobile.common.repository.model.*
import pl.wspologarniacz.mobile.common.utils.asyncSafe
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
            val token = authApi.login(User(email, password)).asyncSafe()
            token.data?.run {
                Log.i(TAG, "Token ${this.token}")
                loadState.done()
            } ?: loadState.error(token.error)
        }

    }

    fun register(email: String, password: String, username: String) {
        loadState.inProgress()
        launch {
            val result = authApi.register(User(email, password, username)).asyncSafe()
            if (result.isSucessfull()) {
                loadState.done()
            } else {
                loadState.error(result.error)
            }
        }
    }

    fun forgotPassword(email: String) {
        launch {
            authApi.forgotPassword(User(email))
        }
    }


}