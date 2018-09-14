package pl.wspologarniacz.mobile.common.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.experimental.Deferred

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide(visibilityLevel: Int = View.GONE) {
    visibility = visibilityLevel
}

@androidx.annotation.LayoutRes
fun Int.inflate(parent: ViewGroup): View {
    return LayoutInflater.from(parent.context).inflate(this, parent, false)
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

