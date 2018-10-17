package pl.wspologarniacz.mobile.schedule.di

import dagger.Module
import dagger.Provides
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import pl.wspologarniacz.mobile.schedule.repository.ScheduleRepository
import pl.wspologarniacz.mobile.schedule.viewmodel.ScheduleViewModel

@Module
class ScheduleModule {

    @Provides
    fun repository() = ScheduleRepository()

    @Provides
    fun viewModel(scheduleRepository: ScheduleRepository) = ScheduleViewModel(scheduleRepository)

    @Provides
    fun viewModelFactory(viewModel: ScheduleViewModel) = ViewModelFactory(viewModel)
}