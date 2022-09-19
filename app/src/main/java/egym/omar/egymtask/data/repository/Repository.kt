package egym.omar.egymtask.data.repository

import egym.omar.egymtask.api.TopStoriesService
import egym.omar.egymtask.data.models.TopStoriesResponse
import javax.inject.Inject

class Repository @Inject constructor(private val topStoriesService: TopStoriesService) {
    suspend fun getTopStories(): TopStoriesResponse {
        return topStoriesService.getTopStories()
    }
}