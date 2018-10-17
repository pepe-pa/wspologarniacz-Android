package pl.wspologarniacz.mobile.tasks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.task_list_fragment_layout.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import pl.wspologarniacz.mobile.tasks.viewmodel.TaskListViewModel
import javax.inject.Inject

class TaskListFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelFactory<TaskListViewModel>

    private val viewModel by lazy {
        ViewModelProviders.of(this, factory)[TaskListViewModel::class.java]
    }

    private val adapter by lazy {
        TaskListAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.task_list_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        taskListRecyclerView.adapter = adapter
        viewModel.tasks.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
}