package pl.wspologarniacz.mobile.common.di

import dagger.Module
import dagger.Provides
import pl.wspologarniacz.mobile.group.repository.GroupRepository

@Module
class GroupModule {

    @Provides
    fun groupRepository() = GroupRepository()
}