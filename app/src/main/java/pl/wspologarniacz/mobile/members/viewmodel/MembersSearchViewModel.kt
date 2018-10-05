package pl.wspologarniacz.mobile.members.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import pl.wspologarniacz.mobile.members.repository.model.Member

class MembersSearchViewModel : ViewModel() {

    private val searchQueryLiveData = MutableLiveData<String>().apply { "" }
    val searchedMembers = Transformations.map(searchQueryLiveData) {
        listOf(
                Member("https://api.adorable.io/avatars/285/22.png", "Isco"),
                Member("https://api.adorable.io/avatars/285/15.png", "Valverde"),
                Member("https://api.adorable.io/avatars/285/24.png", "Ceballos"),
                Member("https://api.adorable.io/avatars/285/10.png", "Modric"),
                Member("https://api.adorable.io/avatars/285/8.png", "Kross"),
                Member("https://api.adorable.io/avatars/285/14.png", "Casemiro")
        ).shuffled()
    }

    fun search(user: String) {
        searchQueryLiveData.value = user
    }
}