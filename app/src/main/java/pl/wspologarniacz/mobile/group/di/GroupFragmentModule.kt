package pl.wspologarniacz.mobile.group.di

import dagger.Module
import dagger.Provides
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import pl.wspologarniacz.mobile.group.repository.GroupRepository
import pl.wspologarniacz.mobile.group.viewmodel.GroupViewModel

@Module
class GroupFragmentModule {

    @Provides
    fun groupRepository() = GroupRepository()

    @Provides
    @GroupScope
    fun viewModel(groupRepository: GroupRepository) = GroupViewModel(groupRepository)

    @Provides
    @GroupScope
    fun viewModelFactory(viewModel: GroupViewModel) = ViewModelFactory(viewModel)
}