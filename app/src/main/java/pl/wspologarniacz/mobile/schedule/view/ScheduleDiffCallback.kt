package pl.wspologarniacz.mobile.schedule.view

import androidx.recyclerview.widget.DiffUtil
import pl.wspologarniacz.mobile.schedule.repository.model.Schedule

object ScheduleDiffCallback : DiffUtil.ItemCallback<Schedule>() {
    override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
        return oldItem == newItem
    }

}
