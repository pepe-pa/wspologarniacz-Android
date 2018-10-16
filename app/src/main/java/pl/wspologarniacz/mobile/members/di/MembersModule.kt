package pl.wspologarniacz.mobile.members.di

import dagger.Module
import dagger.Provides
import pl.wspologarniacz.mobile.common.di.GroupModule
import pl.wspologarniacz.mobile.members.repository.MembersRepository

@Module(includes = [GroupModule::class])
class MembersModule {

    @Provides
    fun membersRepository() = MembersRepository()

}