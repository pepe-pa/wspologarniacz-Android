package pl.wspologarniacz.mobile.group.view

import androidx.recyclerview.widget.DiffUtil
import pl.wspologarniacz.mobile.group.repository.model.Group

object GroupItemCallback : DiffUtil.ItemCallback<Group>() {
    override fun areItemsTheSame(oldItem: Group, newItem: Group) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Group, newItem: Group) = oldItem == newItem
}