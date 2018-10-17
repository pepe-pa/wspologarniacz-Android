package pl.wspologarniacz.mobile.schedule.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.wspologarniacz.mobile.members.repository.model.Member
import pl.wspologarniacz.mobile.members.repository.model.MemberStatus
import pl.wspologarniacz.mobile.schedule.repository.ScheduleRepository
import pl.wspologarniacz.mobile.schedule.repository.model.Schedule
import java.util.*

class ScheduleViewModel(private val scheduleRepository: ScheduleRepository) : ViewModel() {


    val schedule: LiveData<List<Schedule>> = MutableLiveData<List<Schedule>>().apply {

        val members = listOf(
                Member("https://api.adorable.io/avatars/285/12.png", "Marcelo", MemberStatus.MEMBER),
                Member("https://api.adorable.io/avatars/285/4.png", "Sergio Ramos", MemberStatus.PENDING_INVITATION),
                Member("https://api.adorable.io/avatars/285/2.png", "Dani Carvajal", MemberStatus.WAITING_FOR_ACCEPTANCE),
                Member("https://api.adorable.io/avatars/285/5.png", "Varane", MemberStatus.MEMBER),
                Member("https://api.adorable.io/avatars/285/6.png", "Nacho", MemberStatus.MEMBER)
        )

        val random = Random()

        value = listOf(
                Schedule(0, "Gole", "dzisiaj", members.shuffled(), members[random.nextInt(members.size)]),
                Schedule(1, "czyste konta", "wczoraj", members.shuffled(), members[random.nextInt(members.size)]),
                Schedule(2, "Posiadanie", "14-02-2018", members.shuffled(), members[random.nextInt(members.size)]),
                Schedule(3, "Brak kontuzji", "tydzień temu", members.shuffled(), members[random.nextInt(members.size)]),
                Schedule(4, "Ładna gra", "wczoraj", members.shuffled(), members[random.nextInt(members.size)])
        )
    }

}
