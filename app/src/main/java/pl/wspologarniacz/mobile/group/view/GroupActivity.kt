package pl.wspologarniacz.mobile.group.view

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.transition.TransitionManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.group_activity.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.utils.setupDynamicShadowWhenScroll
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import pl.wspologarniacz.mobile.group.repository.model.Group
import pl.wspologarniacz.mobile.group.viewmodel.GroupViewModel
import pl.wspologarniacz.mobile.main.view.MainActivity
import javax.inject.Inject

class GroupActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory<GroupViewModel>

    private val groupViewModel by lazy {
        ViewModelProviders.of(this, factory)[GroupViewModel::class.java]
    }


    private val groupsAdapter by lazy {
        GroupsAdapter {
            onGroupItemClicked(it)
        }
    }

    private fun onGroupItemClicked(group: Group) {
        with(Intent(this, MainActivity::class.java)) {
            startActivity(this)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.group_activity)
        setupRecyclerView()


        groupAction.setOnClickListener {
            TransitionManager.beginDelayedTransition(rootLayout)
            if (groupAction.size == FloatingActionButton.SIZE_MINI) {
                groupAction.setImageResource(R.drawable.ic_add)
                groupAction.size = FloatingActionButton.SIZE_NORMAL
            } else {
                groupAction.setImageResource(R.drawable.ic_close)
                groupAction.size = FloatingActionButton.SIZE_MINI
            }

        }


        appBar.setupDynamicShadowWhenScroll(groupsRecyclerView)

        groupsAdapter.submitList(listOf(
                Group(1, "Grupa A"),
                Group(2, "Grupa B"),
                Group(3, "Grupa C"),
                Group(4, "Grupa D"),
                Group(5, "Grupa E"),
                Group(6, "Grupa F"),
                Group(7, "Grupa G"),
                Group(8, "Grupa H"),
                Group(9, "Grupa I"),
                Group(10, "Grupa J")
        ))
    }

    private fun setupRecyclerView() {
        groupsRecyclerView.adapter = groupsAdapter
    }
}