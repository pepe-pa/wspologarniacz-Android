package pl.wspologarniacz.mobile.common.utils

import android.view.View
import kotlinx.coroutines.experimental.Deferred

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide(visibilityLevel: Int = View.GONE) {
    visibility = visibilityLevel
}

suspend fun <T> Deferred<T>.asyncResult(error: (Throwable) -> Unit = {}, success: (T) -> Unit = {}): T? {
    return try {
        val data = await()
        success(data)

        data
    } catch (e: Exception) {
        error(e)
        null
    }
}

