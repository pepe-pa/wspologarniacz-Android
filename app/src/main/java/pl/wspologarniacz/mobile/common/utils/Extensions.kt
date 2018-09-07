package pl.wspologarniacz.mobile.common.utils

import android.view.View

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide(visibilityLevel: Int = View.GONE) {
    visibility = visibilityLevel
}