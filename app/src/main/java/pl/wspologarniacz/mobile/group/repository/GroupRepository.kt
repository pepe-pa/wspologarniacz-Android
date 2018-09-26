package pl.wspologarniacz.mobile.group.repository

import androidx.lifecycle.MutableLiveData
import pl.wspologarniacz.mobile.common.repository.model.Idle
import pl.wspologarniacz.mobile.common.repository.model.LoadState

class GroupRepository {


    val loadState = MutableLiveData<LoadState>().apply {
        value = Idle()
    }


    fun search(query: String) {

    }

    fun add() {

    }

    fun join(groupId: Long) {

    }

    fun getList() {

    }
}