package pl.wspologarniacz.mobile.group.view

import androidx.recyclerview.widget.DiffUtil

object GroupItemCallback : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Any, newItem: Any) = oldItem == newItem
}