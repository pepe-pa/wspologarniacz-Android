package pl.wspologarniacz.mobile.ranking.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.wspologarniacz.mobile.members.repository.model.Member
import pl.wspologarniacz.mobile.ranking.repository.RankingRepository
import pl.wspologarniacz.mobile.ranking.repository.model.Ranking

class RankingsListViewModel(private val rankingRepository: RankingRepository) : ViewModel() {

    val rankings: LiveData<List<Ranking>> = MutableLiveData<List<Ranking>>().apply {

        val members = listOf(
                Member("https://api.adorable.io/avatars/285/22.png", "Isco"),
                Member("https://api.adorable.io/avatars/285/15.png", "Valverde"),
                Member("https://api.adorable.io/avatars/285/24.png", "Ceballos"),
                Member("https://api.adorable.io/avatars/285/10.png", "Modric"),
                Member("https://api.adorable.io/avatars/285/8.png", "Kross"),
                Member("https://api.adorable.io/avatars/285/14.png", "Casemiro")
        )


        value = listOf(
                Ranking(0, "Gole", members.shuffled()),
                Ranking(1, "Asysty", members.shuffled()),
                Ranking(2, "Podania", members.shuffled()),
                Ranking(3, "Czyste konta", members.shuffled()),
                Ranking(4, "Fair play", members.shuffled())
        )
    }
}
