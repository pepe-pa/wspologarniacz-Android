package pl.wspologarniacz.mobile.group.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.utils.inflate

class GroupsAdapter : ListAdapter<Any, GroupsAdapter.GroupViewHolder>(GroupItemCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        return GroupViewHolder(R.layout.group_item_layout.inflate(parent))
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class GroupViewHolder(override val containerView: View) :
            RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item: Any?) {
            item?.run {

            }
        }

    }
}