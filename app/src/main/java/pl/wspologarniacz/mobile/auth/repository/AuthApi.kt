package pl.wspologarniacz.mobile.auth.repository

import kotlinx.coroutines.experimental.Deferred
import pl.wspologarniacz.mobile.auth.repository.model.Token
import pl.wspologarniacz.mobile.auth.repository.model.User
import retrofit2.Response
import retrofit2.http.POST

interface AuthApi {

    @POST("user/login")
    fun login(user: User): Deferred<Response<Token>>

    @POST("user/register")
    fun register(user: User): Deferred<Void>

    @POST("/user/password/reset/request")
    fun forgotPassword(user: User): Deferred<Void>
}