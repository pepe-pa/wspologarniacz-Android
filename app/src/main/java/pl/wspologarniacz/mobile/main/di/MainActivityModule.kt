package pl.wspologarniacz.mobile.main.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.wspologarniacz.mobile.members.di.MembersListModule
import pl.wspologarniacz.mobile.members.view.MembersFragment
import pl.wspologarniacz.mobile.tasks.di.TaskListModule
import pl.wspologarniacz.mobile.tasks.view.TaskListFragment

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [MembersListModule::class])
    abstract fun membersFragment(): MembersFragment

    @ContributesAndroidInjector(modules = [TaskListModule::class])
    abstract fun taskListFragment(): TaskListFragment
}