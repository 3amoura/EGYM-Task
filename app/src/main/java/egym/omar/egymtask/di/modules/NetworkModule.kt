package egym.omar.egymtask.di.modules

import dagger.Module
import dagger.Provides
import egym.omar.egymtask.Constants
import egym.omar.egymtask.api.TopStoriesService
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
object NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        val client = OkHttpClient().newBuilder().addInterceptor { chain ->
            var request: Request = chain.request()
            val url: HttpUrl =
                request.url().newBuilder().addQueryParameter("api-key", Constants.API_KEY).build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }.build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): TopStoriesService =
        retrofit.create(TopStoriesService::class.java)
}