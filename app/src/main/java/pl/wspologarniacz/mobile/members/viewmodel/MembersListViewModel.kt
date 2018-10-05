package pl.wspologarniacz.mobile.members.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.wspologarniacz.mobile.group.repository.GroupRepository
import pl.wspologarniacz.mobile.members.repository.model.Member
import pl.wspologarniacz.mobile.members.repository.model.MemberStatus

class MembersListViewModel(private val groupRepository: GroupRepository) : ViewModel() {


    val groupMembers: LiveData<List<Member>> = MutableLiveData<List<Member>>().apply {
        groupRepository.seachGroup("xD")
        value = listOf(
                Member("https://api.adorable.io/avatars/285/12.png", "Marcelo", MemberStatus.MEMBER),
                Member("https://api.adorable.io/avatars/285/4.png", "Sergio Ramos", MemberStatus.PENDING_INVITATION),
                Member("https://api.adorable.io/avatars/285/2.png", "Dani Carvajal", MemberStatus.WAITING_FOR_ACCEPTANCE),
                Member("https://api.adorable.io/avatars/285/5.png", "Varane", MemberStatus.MEMBER),
                Member("https://api.adorable.io/avatars/285/6.png", "Nacho", MemberStatus.MEMBER)
        )
    }


}