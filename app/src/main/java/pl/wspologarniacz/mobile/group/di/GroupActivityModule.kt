package pl.wspologarniacz.mobile.group.di

import dagger.Module
import dagger.Provides
import pl.wspologarniacz.mobile.common.di.GroupModule
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import pl.wspologarniacz.mobile.group.repository.GroupRepository
import pl.wspologarniacz.mobile.group.viewmodel.GroupViewModel

@Module(includes = [GroupModule::class])
class GroupActivityModule {


    @Provides
    fun viewModel(groupRepository: GroupRepository) = GroupViewModel(groupRepository)

    @Provides
    fun viewModelFactory(viewModel: GroupViewModel) = ViewModelFactory(viewModel)
}