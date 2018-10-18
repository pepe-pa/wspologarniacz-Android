package pl.wspologarniacz.mobile.ranking.repository.model

import pl.wspologarniacz.mobile.members.repository.model.Member

data class Ranking(
        var id: Long = 0L,
        var title: String,
        var members: List<Member>
)