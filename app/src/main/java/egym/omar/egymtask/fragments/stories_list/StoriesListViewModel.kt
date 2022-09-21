package egym.omar.egymtask.fragments.stories_list

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import egym.omar.egymtask.data.models.TopStoriesResponse
import egym.omar.egymtask.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StoriesListViewModel @Inject constructor(
    app: Application, private val repository: Repository
) : AndroidViewModel(app) {
    var topStories = MutableLiveData<TopStoriesResponse>()
    var failed = MutableLiveData<String>()

    fun getTopStories() = viewModelScope.launch(Dispatchers.Default) {
        withContext(Dispatchers.IO) {
            try {
                Log.d("StoriesListViewModel", "Will load the stories")
                val respone = repository.getTopStories()
                withContext(Dispatchers.Main) {
                    topStories.value = respone
                }
            } catch (e: java.lang.Exception) {
                e.localizedMessage?.let {
                    Log.e("StoriesListViewModel", it)
                    withContext(Dispatchers.Main) {
                        failed.value = it
                    }
                }
            }
        }
    }
}