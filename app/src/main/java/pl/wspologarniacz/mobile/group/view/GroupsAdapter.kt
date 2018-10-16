package pl.wspologarniacz.mobile.group.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stfalcon.multiimageview.MultiImageView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.group_item_layout.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.utils.inflate
import pl.wspologarniacz.mobile.group.repository.model.Group

class GroupsAdapter(val onClick: (Group) -> Unit) : ListAdapter<Group, GroupsAdapter.GroupViewHolder>(GroupItemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        return GroupViewHolder(R.layout.group_item_layout.inflate(parent))
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class GroupViewHolder(override val containerView: View) :
            RecyclerView.ViewHolder(containerView), LayoutContainer {

        init {
            groupImage.shape = MultiImageView.Shape.CIRCLE
            containerView.setOnClickListener {
                onClick(getItem(layoutPosition))
            }
        }

        fun bind(item: Group?) {
            item?.run {
                /*forEAcj img url*/
                loadToMultiImage("")
                groupName.text = this.name
            }
        }

        private fun loadToMultiImage(url: String) {
            Glide.with(groupImage)
                    .asBitmap()
                    .load(url)
                    .addListener(MutliImageLoadListener(groupImage))
                    .submit()
        }

    }
}