package pl.wspologarniacz.mobile.members.repository.model

data class Member(
        var avatar: String = "",
        var name: String = "",
        var status: MemberStatus = MemberStatus.INVITE,
        var id: Long = 0)