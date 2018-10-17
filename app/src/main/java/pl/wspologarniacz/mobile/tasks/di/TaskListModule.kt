package pl.wspologarniacz.mobile.tasks.di

import dagger.Module
import dagger.Provides
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import pl.wspologarniacz.mobile.tasks.repository.TaskRepository
import pl.wspologarniacz.mobile.tasks.viewmodel.TaskListViewModel

@Module
class TaskListModule {

    @Provides
    fun repository() = TaskRepository()

    @Provides
    fun viewModel(taskRepository: TaskRepository) = TaskListViewModel(taskRepository)

    @Provides
    fun viewModelFactory(viewModel: TaskListViewModel) = ViewModelFactory(viewModel)
}