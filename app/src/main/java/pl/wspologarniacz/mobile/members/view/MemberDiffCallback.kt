package pl.wspologarniacz.mobile.members.view

import androidx.recyclerview.widget.DiffUtil
import pl.wspologarniacz.mobile.members.repository.model.Member

object MemberDiffCallback : DiffUtil.ItemCallback<Member>() {
    override fun areItemsTheSame(oldItem: Member, newItem: Member) = oldItem.name == newItem.name


    override fun areContentsTheSame(oldItem: Member, newItem: Member) = oldItem == newItem
}