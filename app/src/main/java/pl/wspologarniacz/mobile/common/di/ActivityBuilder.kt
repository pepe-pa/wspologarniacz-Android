package pl.wspologarniacz.mobile.common.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.wspologarniacz.mobile.auth.view.AuthActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun authActivity(): AuthActivity
}