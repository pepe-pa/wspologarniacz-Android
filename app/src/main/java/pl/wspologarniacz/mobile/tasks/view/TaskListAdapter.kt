package pl.wspologarniacz.mobile.tasks.view

import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.task_list_item_layout.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.utils.fromHtml
import pl.wspologarniacz.mobile.common.utils.inflate
import pl.wspologarniacz.mobile.common.utils.load
import pl.wspologarniacz.mobile.common.view.BindViewHolder
import pl.wspologarniacz.mobile.common.view.SimpleListAdapter
import pl.wspologarniacz.mobile.tasks.repository.model.Task

class TaskListAdapter : SimpleListAdapter<Task>(TaskDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(R.layout.task_list_item_layout.inflate(parent))
    }

    inner class TaskViewHolder(view: View) : BindViewHolder<Task>(view) {


        override fun bind(item: Task) {
            title.text = item.title
            description.text = item.description
            modified.text = containerView.resources.getString(R.string.modified_format_text, item.modified, item.username).fromHtml()
            status.load("https://api.adorable.io/avatars/285/${item.status}.png", RequestOptions.circleCropTransform())

        }

    }
}
