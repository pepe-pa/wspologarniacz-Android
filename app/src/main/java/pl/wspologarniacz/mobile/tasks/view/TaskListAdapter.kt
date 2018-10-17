package pl.wspologarniacz.mobile.tasks.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.task_list_item_layout.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.utils.fromHtml
import pl.wspologarniacz.mobile.common.utils.inflate
import pl.wspologarniacz.mobile.common.utils.load
import pl.wspologarniacz.mobile.tasks.repository.model.Task

class TaskListAdapter : ListAdapter<Task, TaskListAdapter.TaskViewHolder>(TaskDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(R.layout.task_list_item_layout.inflate(parent))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class TaskViewHolder(override val containerView: View) :
            RecyclerView.ViewHolder(containerView), LayoutContainer {


        fun bind(item: Task?) {
            item?.let { task ->
                title.text = task.title
                description.text = task.description
                modified.text = containerView.resources.getString(R.string.modified_format_text, task.modified, task.username).fromHtml()
                status.load("https://api.adorable.io/avatars/285/${task.status}.png", RequestOptions.circleCropTransform())
            }

        }

    }
}
