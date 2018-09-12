package pl.wspologarniacz.mobile.main.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.wspologarniacz.mobile.group.di.GroupFragmentModule
import pl.wspologarniacz.mobile.group.di.GroupScope
import pl.wspologarniacz.mobile.group.view.GroupFragment

@Module
abstract class MainActivityModule {


    @ContributesAndroidInjector(modules = [GroupFragmentModule::class])
    @GroupScope
    abstract fun groupFragment(): GroupFragment
}