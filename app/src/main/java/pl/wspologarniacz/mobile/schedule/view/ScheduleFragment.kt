package pl.wspologarniacz.mobile.schedule.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.swipe_refresh_recycler_view_layout.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import pl.wspologarniacz.mobile.schedule.viewmodel.ScheduleViewModel
import javax.inject.Inject

class ScheduleFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelFactory<ScheduleViewModel>

    private val viewModel by lazy {
        ViewModelProviders.of(this, factory)[ScheduleViewModel::class.java]
    }

    private val adapter by lazy {
        ScheduleAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.swipe_refresh_recycler_view_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        viewModel.schedule.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

}
