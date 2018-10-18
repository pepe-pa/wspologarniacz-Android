package pl.wspologarniacz.mobile.schedule.view

import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.schedule_item_layout.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.utils.addMembersToLayout
import pl.wspologarniacz.mobile.common.utils.inflate
import pl.wspologarniacz.mobile.common.utils.load
import pl.wspologarniacz.mobile.common.view.BindViewHolder
import pl.wspologarniacz.mobile.common.view.SimpleListAdapter
import pl.wspologarniacz.mobile.schedule.repository.model.Schedule


class ScheduleAdapter : SimpleListAdapter<Schedule>(ScheduleDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        return ScheduleViewHolder(R.layout.schedule_item_layout.inflate(parent))
    }


    inner class ScheduleViewHolder(view: View) : BindViewHolder<Schedule>(view) {




        override fun bind(item: Schedule) {

            next.load(item.nextMember.avatar, RequestOptions.circleCropTransform())
            title.text = item.title
            members.addMembersToLayout(item.members)
            modified.text = item.modified
        }


    }

}


