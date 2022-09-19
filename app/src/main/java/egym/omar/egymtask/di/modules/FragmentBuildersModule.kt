package egym.omar.egymtask.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import egym.omar.egymtask.fragments.StoriesListFragment

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeStoriesListFragment(): StoriesListFragment
}