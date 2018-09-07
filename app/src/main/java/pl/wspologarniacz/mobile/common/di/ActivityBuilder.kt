package pl.wspologarniacz.mobile.common.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.wspologarniacz.mobile.auth.di.AuthModule
import pl.wspologarniacz.mobile.auth.di.AuthScope
import pl.wspologarniacz.mobile.auth.view.AuthActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [AuthModule::class])
    @AuthScope
    abstract fun authActivity(): AuthActivity
}