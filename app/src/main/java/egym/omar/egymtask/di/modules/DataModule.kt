package egym.omar.egymtask.di.modules

import dagger.Module
import dagger.Provides
import egym.omar.egymtask.api.TopStoriesService
import egym.omar.egymtask.data.repository.Repository
import javax.inject.Singleton

@Module
object DataModule {
    @Singleton
    @Provides
    fun providesRepository(topStoriesService: TopStoriesService): Repository =
        Repository(topStoriesService)
}