package pl.wspologarniacz.mobile.main.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.wspologarniacz.mobile.group.di.GroupScope
import pl.wspologarniacz.mobile.members.view.MembersFragment

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(/*modules = [GroupActivityModule::class]*/)
    @GroupScope
    abstract fun membersFragment(): MembersFragment
}