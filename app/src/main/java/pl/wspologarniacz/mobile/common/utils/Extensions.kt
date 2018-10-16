package pl.wspologarniacz.mobile.common.utils

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import kotlinx.coroutines.experimental.Deferred
import pl.wspologarniacz.mobile.R

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

fun EditText.onTextChanged(after: (s: String) -> Unit = {}) =
        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) = after.invoke(s.toString())
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }
        })

fun AppBarLayout.setupDynamicShadowWhenScroll(recyclerView: RecyclerView) {
    recyclerView.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    elevation = if (recyclerView.canScrollVertically(-1)) {
                        resources.getDimensionPixelSize(R.dimen.design_appbar_elevation).toFloat()
                    } else {
                        0F
                    }
                }


            })
}

fun Fragment.hideKeyboard() {
    activity?.hideKeyboard()
}

fun Activity.hideKeyboard() {
    hideKeyboard(if (currentFocus == null) View(this) else currentFocus)
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}