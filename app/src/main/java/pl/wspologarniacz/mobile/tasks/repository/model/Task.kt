package pl.wspologarniacz.mobile.tasks.repository.model

data class Task(
        var id: Long = 0L,
        var status: String = "",
        var title: String = "",
        var description: String = "",
        var modified: String = "",
        var username: String = ""
)