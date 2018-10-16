package pl.wspologarniacz.mobile.members.repository.model

import pl.wspologarniacz.mobile.R

enum class MemberStatus(val displayText: Int, val color: Int) {
    MEMBER(R.string.member_text, R.color.member_color),
    PENDING_INVITATION(R.string.member_pending_text, R.color.member_waiting_color),
    WAITING_FOR_ACCEPTANCE(R.string.member_waiting_text, R.color.member_waiting_color),
    INVITE(R.string.invite_text, R.color.member_invite_color)

}