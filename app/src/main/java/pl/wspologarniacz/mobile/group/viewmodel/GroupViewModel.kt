package pl.wspologarniacz.mobile.group.viewmodel

import androidx.lifecycle.ViewModel
import pl.wspologarniacz.mobile.group.repository.GroupRepository
import pl.wspologarniacz.mobile.group.repository.model.Group

class GroupViewModel(private val groupRepository: GroupRepository) : ViewModel() {


    fun acceptInvitation(groupId: Long) {
        groupRepository.acceptInvitation(groupId)
    }

    fun rejectInvitation(groupId: Long) {
        groupRepository.rejectInvitation(groupId)
    }

    fun acceptUser(groupId: Long, userId: Long) {
        groupRepository.acceptUser(groupId, userId)
    }

    fun rejectUser(groupId: Long, userId: Long) {
        groupRepository.rejectUser(groupId, userId)
    }

    fun invite(groupId: Long, userId: Long) {
        groupRepository.invite(groupId, userId)
    }

    fun seachGroup(query: String) {
        groupRepository.seachGroup(query)
    }

    fun getGroup(groupId: Long) {
        groupRepository.getGroup(groupId)
    }

    fun getUserGroups() {
        groupRepository.getUserGroups()
    }

    fun joinGroup(groupId: Long) {
        groupRepository.joinGroup(groupId)
    }

    fun leaveGroup(groupId: Long) {
        groupRepository.leaveGroup(groupId)
    }

    fun createGroup(groupName: String) {
        groupRepository.createGroup(Group(name = groupName))
    }

}
