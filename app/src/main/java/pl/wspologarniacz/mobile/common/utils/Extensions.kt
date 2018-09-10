package pl.wspologarniacz.mobile.common.utils

import android.view.View
import kotlinx.coroutines.experimental.Deferred
import pl.wspologarniacz.mobile.common.repository.model.Result

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide(visibilityLevel: Int = View.GONE) {
    visibility = visibilityLevel
}

suspend fun <T> Deferred<T>.asyncSafe(): Result<T> {
    return try {
        Result(data = await())
    } catch (e: Exception) {
        Result(error = e)
    }
}