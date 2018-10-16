package pl.wspologarniacz.mobile.common.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import android.view.ViewAnimationUtils

fun View.revealAnimation(centerX: Int, centerY: Int, startRadius: Float, endRadius: Float, endFunction: () -> Unit = {}) {
    this.visibility = View.VISIBLE
    val animator = ViewAnimationUtils.createCircularReveal(
            this,
            centerX,
            centerY,
            startRadius,
            endRadius
    )

    animator.addListener(object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator?) {
            super.onAnimationEnd(animation)
            endFunction()
        }
    })


    animator.start()
}