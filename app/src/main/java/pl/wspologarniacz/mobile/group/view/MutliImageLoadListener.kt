package pl.wspologarniacz.mobile.group.view

import android.graphics.Bitmap
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.stfalcon.multiimageview.MultiImageView

class MutliImageLoadListener(private val multiImageView: MultiImageView) : RequestListener<Bitmap> {
    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Bitmap>?, isFirstResource: Boolean): Boolean {
        return true
    }

    override fun onResourceReady(resource: Bitmap?, model: Any?, target: Target<Bitmap>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
        multiImageView.addImage(resource!!)
        return true
    }
}