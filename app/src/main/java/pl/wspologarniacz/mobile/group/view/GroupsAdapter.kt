package pl.wspologarniacz.mobile.group.view

import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.stfalcon.multiimageview.MultiImageView
import kotlinx.android.synthetic.main.group_item_layout.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.utils.inflate
import pl.wspologarniacz.mobile.common.view.BindViewHolder
import pl.wspologarniacz.mobile.common.view.SimpleListAdapter
import pl.wspologarniacz.mobile.group.repository.model.Group

class GroupsAdapter(val onClick: (Group) -> Unit) : SimpleListAdapter<Group>(GroupItemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder<Group> {
        return GroupViewHolder(R.layout.group_item_layout.inflate(parent))
    }


    inner class GroupViewHolder(view: View) : BindViewHolder<Group>(view) {


        init {
            groupImage.shape = MultiImageView.Shape.CIRCLE
            containerView.setOnClickListener {
                onClick(getItem(layoutPosition))
            }
        }

        override fun bind(item: Group) {
            /*forEAcj img url*/
            loadToMultiImage("")
            groupName.text = item.name
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