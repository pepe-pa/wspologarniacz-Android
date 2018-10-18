package pl.wspologarniacz.mobile.ranking.repository.model

import pl.wspologarniacz.mobile.members.repository.model.Member


data class RankingStanding(
        var id: Long = 0L,
        var member: Member,
        var position: Int = 0,
        var points: Long = 0L

)