package pl.wspologarniacz.mobile.tasks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.wspologarniacz.mobile.tasks.repository.TaskRepository
import pl.wspologarniacz.mobile.tasks.repository.model.Task

class TaskListViewModel(taskRepository: TaskRepository) : ViewModel() {


    val tasks: LiveData<List<Task>> = MutableLiveData<List<Task>>().apply {
        value = listOf(
                Task(0, "Done", "Kontuzja", "Uniknąć kontuzji za wszelką cene", "wczoraj", "Bale"),
                Task(0, "InProgress", "Gol", "Strzelic gola za wszelką cene", "wczoraj", "Benzema"),
                Task(0, "Waiting", "Parada", "Uniknąć straty bramki za wszelką cene", "wczoraj", "Navas"),
                Task(0, "Done", "Czerwona kartka", "Uniknąć kartki za wszelką cene", "wczoraj", "Sergio Ramos")
        )
    }

}
