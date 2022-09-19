package egym.omar.egymtask

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import egym.omar.egymtask.di.DaggerAppComponent

class EGYMApp: DaggerApplication() {
    private val applicationInjector = DaggerAppComponent.builder().application(this).build()
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector
}