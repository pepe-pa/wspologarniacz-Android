package pl.wspologarniacz.mobile.members.di

import dagger.Module
import dagger.Provides
import pl.wspologarniacz.mobile.common.di.GroupModule
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import pl.wspologarniacz.mobile.group.repository.GroupRepository
import pl.wspologarniacz.mobile.members.viewmodel.MembersSearchViewModel

@Module(includes = [GroupModule::class])
class MembersSearchModule {

    @Provides
    fun viewModel(groupRepository: GroupRepository) = MembersSearchViewModel(groupRepository)

    @Provides
    fun viewModelFactory(viewModel: MembersSearchViewModel) = ViewModelFactory(viewModel)

}