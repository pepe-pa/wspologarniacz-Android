package pl.wspologarniacz.mobile

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import pl.wspologarniacz.mobile.common.di.DaggerAppComponent

class WspolorganiaczApp : DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}