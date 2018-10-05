package pl.wspologarniacz.mobile.main.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.wspologarniacz.mobile.members.di.MembersListModule
import pl.wspologarniacz.mobile.members.view.MembersFragment

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [MembersListModule::class])
    abstract fun membersFragment(): MembersFragment
}