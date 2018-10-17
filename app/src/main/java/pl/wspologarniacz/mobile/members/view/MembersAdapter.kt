package pl.wspologarniacz.mobile.members.view

import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.people_list_item_layout.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.utils.inflate
import pl.wspologarniacz.mobile.common.utils.load
import pl.wspologarniacz.mobile.common.view.BindViewHolder
import pl.wspologarniacz.mobile.common.view.SimpleListAdapter
import pl.wspologarniacz.mobile.members.repository.model.Member

class MembersAdapter(val onClick: (Member) -> Unit = {}) :
        SimpleListAdapter<Member>(MemberDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        return MemberViewHolder(R.layout.people_list_item_layout.inflate(parent))
    }


    inner class MemberViewHolder(view: View) : BindViewHolder<Member>(view) {

        init {
            containerView.setOnClickListener {
                onClick(getItem(layoutPosition))
            }
        }

        override fun bind(item: Member) {
            avatar.load(item.avatar, RequestOptions.circleCropTransform())
            username.text = item.name
            status.setText(item.status.displayText)
            status.setTextColor(ContextCompat.getColor(containerView.context, item.status.color))
        }
    }
}