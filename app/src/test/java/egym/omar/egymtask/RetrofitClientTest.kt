package egym.omar.egymtask

import egym.omar.egymtask.di.modules.NetworkModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.Retrofit

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RetrofitClientTest {
    private val scope = CoroutineScope(Dispatchers.Main)
    @Test
    fun testRetrofitInstance() {
        val instance: Retrofit = NetworkModule.providesRetrofit()
        assert(instance.baseUrl().url().toString() == BuildConfig.BASE_URL)
    }

    @Test
    fun testTopStoriesService() = runBlocking  {
        val instance: Retrofit = NetworkModule.providesRetrofit()
        val service = NetworkModule.providesApiService(instance)
        val response = service.getTopStories().execute()

        //Check for error body
        val body = response.body()?.results
        assert(response.code() == 200)
        assert(body?.isEmpty() != true)
    }
}