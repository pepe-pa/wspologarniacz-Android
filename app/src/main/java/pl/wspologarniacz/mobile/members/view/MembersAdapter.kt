package pl.wspologarniacz.mobile.members.view

import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.people_list_item_layout.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.utils.inflate
import pl.wspologarniacz.mobile.common.utils.load
import pl.wspologarniacz.mobile.members.repository.model.Member

class MembersAdapter(val onClick: (Member) -> Unit = {}) :
        ListAdapter<Member, MembersAdapter.MemberViewHolder>(MemberDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        return MemberViewHolder(R.layout.people_list_item_layout.inflate(parent))
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class MemberViewHolder(override val containerView: View) :
            RecyclerView.ViewHolder(containerView), LayoutContainer {

        init {
            containerView.setOnClickListener {
                onClick(getItem(layoutPosition))
            }
        }

        fun bind(member: Member) {
            avatar.load(member.avatar, RequestOptions.circleCropTransform())
            username.text = member.name
            status.setText(member.status.displayText)
            status.setTextColor(ContextCompat.getColor(containerView.context, member.status.color))
        }
    }
}