package pl.wspologarniacz.mobile.members.view

import android.os.Bundle
import android.transition.Slide
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.search_members_activity.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.utils.hideKeyboard
import pl.wspologarniacz.mobile.common.utils.onTextChanged
import pl.wspologarniacz.mobile.common.utils.setupDynamicShadowWhenScroll
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import pl.wspologarniacz.mobile.members.viewmodel.MembersSearchViewModel
import javax.inject.Inject

class MembersSearchActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory<MembersSearchViewModel>

    private val viewModel by lazy {
        ViewModelProviders.of(this, factory)[MembersSearchViewModel::class.java]
    }

    private val adapter by lazy { MembersAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.enterTransition = Slide()
        setContentView(R.layout.search_members_activity)


        searchedMembers.adapter = adapter
        appBar.setupDynamicShadowWhenScroll(searchedMembers)

        viewModel.searchedMembers.observe(this, Observer {
            adapter.submitList(it)
        })

        search.onTextChanged {
            viewModel.search(it)
        }

        search.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                hideKeyboard()
                return@setOnEditorActionListener true
            }

            return@setOnEditorActionListener false
        }
    }
}