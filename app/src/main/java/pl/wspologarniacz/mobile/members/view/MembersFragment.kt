package pl.wspologarniacz.mobile.members.view

import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.members_fragment.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import pl.wspologarniacz.mobile.members.viewmodel.MembersListViewModel
import javax.inject.Inject

class MembersFragment : DaggerFragment() {


    @Inject
    lateinit var factory: ViewModelFactory<MembersListViewModel>

    private val viewModel by lazy {
        ViewModelProviders.of(this, factory)[MembersListViewModel::class.java]
    }

    private val adapter by lazy { MembersAdapter() }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.members_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vg = view as ViewGroup
        vg.clipChildren = false
        vg.clipToPadding = false

        members.adapter = adapter

        viewModel.groupMembers.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })



        addPeople.setOnClickListener {
            val activity = activity as AppCompatActivity
            val bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(activity).toBundle()
            bundle?.putLong(MembersSearchActivity.GROUP_PARAM, 0/*for now*/)

            activity.window?.run {
                enterTransition = Slide()
            }

            startActivity(Intent(context, MembersSearchActivity::class.java), bundle)
        }



    }
}