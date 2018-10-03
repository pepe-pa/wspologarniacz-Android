package pl.wspologarniacz.mobile.members.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.members_fragment.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.members.repository.model.Member
import pl.wspologarniacz.mobile.members.repository.model.MemberStatus

class MembersFragment : Fragment() {

    private val adapter by lazy { MembersAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.members_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        members.adapter = adapter

        adapter.submitList(listOf(
                Member("https://api.adorable.io/avatars/285/12.png", "Marcelo", MemberStatus.MEMBER),
                Member("https://api.adorable.io/avatars/285/4.png", "Sergio Ramos", MemberStatus.PENDING_INVITATION),
                Member("https://api.adorable.io/avatars/285/2.png", "Dani Carvajal", MemberStatus.WAITING_FOR_ACCEPTANCE),
                Member("https://api.adorable.io/avatars/285/5.png", "Varane", MemberStatus.MEMBER),
                Member("https://api.adorable.io/avatars/285/6.png", "Nacho", MemberStatus.MEMBER),
                Member("https://api.adorable.io/avatars/285/19.png", "Odriozola", MemberStatus.INVITE)
        ))

    }
}