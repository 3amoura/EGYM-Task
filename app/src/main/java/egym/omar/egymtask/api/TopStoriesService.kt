package egym.omar.egymtask.api

import egym.omar.egymtask.data.models.TopStoriesResponse
import retrofit2.http.GET

interface TopStoriesService {
    @GET("home.json")
    suspend fun getTopStories(): TopStoriesResponse
}