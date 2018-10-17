package pl.wspologarniacz.mobile.common.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class BindViewHolder<T>(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {


    abstract fun bind(item: T)
}