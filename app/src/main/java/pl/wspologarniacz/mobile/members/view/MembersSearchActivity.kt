package pl.wspologarniacz.mobile.members.view

import android.os.Bundle
import android.transition.Slide
import android.util.Log
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.search_members_activity.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.utils.hideKeyboard
import pl.wspologarniacz.mobile.common.utils.onTextChanged
import pl.wspologarniacz.mobile.common.utils.setupDynamicShadowWhenScroll
import pl.wspologarniacz.mobile.members.repository.model.Member

class MembersSearchActivity : AppCompatActivity() {

    private val adapter by lazy { MembersAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.enterTransition = Slide()
        setContentView(R.layout.search_members_activity)


        searchedMembers.adapter = adapter
        appBar.setupDynamicShadowWhenScroll(searchedMembers)

        search.onTextChanged {
            Log.i("text", "text change: $it")
            adapter.submitList(listOf(
                    Member("https://api.adorable.io/avatars/285/22.png", "Isco"),
                    Member("https://api.adorable.io/avatars/285/15.png", "Valverde"),
                    Member("https://api.adorable.io/avatars/285/24.png", "Ceballos"),
                    Member("https://api.adorable.io/avatars/285/10.png", "Modric"),
                    Member("https://api.adorable.io/avatars/285/8.png", "Kross"),
                    Member("https://api.adorable.io/avatars/285/14.png", "Casemiro")
            ).shuffled())
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