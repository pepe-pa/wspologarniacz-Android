package pl.wspologarniacz.mobile.common.repository.model

class Result<out T>(val data: T? = null, val error: Throwable? = null) {
    fun isSucessfull() = error == null
}