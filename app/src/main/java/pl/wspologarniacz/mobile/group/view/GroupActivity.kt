package pl.wspologarniacz.mobile.group.view

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.group_activity.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import pl.wspologarniacz.mobile.group.repository.model.Group
import pl.wspologarniacz.mobile.group.viewmodel.GroupViewModel
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
        Toast.makeText(this, group.toString(), Toast.LENGTH_SHORT).show()
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

        groupsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                appBar.elevation = if (groupsRecyclerView.canScrollVertically(-1)) {
                    resources.getDimensionPixelSize(R.dimen.design_appbar_elevation).toFloat()
                } else {
                    0F
                }
            }


        })

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