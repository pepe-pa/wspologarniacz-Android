package pl.wspologarniacz.mobile.tasks.view

import androidx.recyclerview.widget.DiffUtil
import pl.wspologarniacz.mobile.tasks.repository.model.Task

object TaskDiffCallback : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
