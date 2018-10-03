package pl.wspologarniacz.mobile.common.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.load(url: String, requestOptions: RequestOptions? = null) {
    val glideAction = Glide.with(this).load(url)

    requestOptions?.let {
        glideAction.apply(it)
    }

    glideAction.into(this)
}