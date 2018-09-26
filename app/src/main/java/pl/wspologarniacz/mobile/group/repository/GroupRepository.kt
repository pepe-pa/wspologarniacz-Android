package pl.wspologarniacz.mobile.group.repository

import androidx.lifecycle.MutableLiveData
import pl.wspologarniacz.mobile.common.repository.model.Idle
import pl.wspologarniacz.mobile.common.repository.model.LoadState
import pl.wspologarniacz.mobile.group.repository.model.Group

class GroupRepository {


    val loadState = MutableLiveData<LoadState>().apply {
        value = Idle()
    }

    fun acceptInvitation(groupId: Long) {

    }

    fun rejectInvitation(groupId: Long) {

    }

    fun acceptUser(groupId: Long, userId: Long) {

    }

    fun rejectUser(groupId: Long, userId: Long) {

    }

    fun invite(groupId: Long, userId: Long) {

    }

    fun seachGroup(query: String) {

    }

    fun getGroup(groupId: Long) {

    }

    fun getUserGroups() {

    }

    fun joinGroup(groupId: Long) {

    }

    fun leaveGroup(groupId: Long) {

    }

    fun createGroup(group: Group) {

    }
}