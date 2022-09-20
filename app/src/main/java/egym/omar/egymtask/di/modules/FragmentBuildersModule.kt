package egym.omar.egymtask.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import egym.omar.egymtask.fragments.stories_list.StoriesListFragment
import egym.omar.egymtask.fragments.story_details.StoryDetailsFragment
import egym.omar.egymtask.fragments.web_view_fragment.WebViewFragment

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeStoriesListFragment(): StoriesListFragment

    @ContributesAndroidInjector
    abstract fun contributeStoryDetailsFragment(): StoryDetailsFragment

    @ContributesAndroidInjector
    abstract fun contributeWebViewFragment(): WebViewFragment
}