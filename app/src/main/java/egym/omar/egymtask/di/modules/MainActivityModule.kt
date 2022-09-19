package egym.omar.egymtask.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import egym.omar.egymtask.activities.MainActivity

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            FragmentBuildersModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}