package pl.wspologarniacz.mobile.schedule.repository.model

import pl.wspologarniacz.mobile.members.repository.model.Member

data class Schedule(
        var id: Long = 0L,
        var title: String = "",
        var modified: String = "",
        var members: List<Member> = listOf(),
        var nextMember: Member = Member()
)
