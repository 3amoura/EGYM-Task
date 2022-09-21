package egym.omar.egymtask.api

import egym.omar.egymtask.data.models.TopStoriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface TopStoriesService {
    @GET("home.json")
    fun getTopStories(): Call<TopStoriesResponse>
}