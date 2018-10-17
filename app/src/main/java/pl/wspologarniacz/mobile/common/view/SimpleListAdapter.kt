package pl.wspologarniacz.mobile.common.view

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter


abstract class SimpleListAdapter<T>(itemCallback: DiffUtil.ItemCallback<T>) :
        ListAdapter<T, BindViewHolder<T>>(itemCallback) {

    override fun onBindViewHolder(holder: BindViewHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }
}