package egym.omar.egymtask.fragments.stories_list

import android.app.Application
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

    fun getTopStories() = viewModelScope.launch(Dispatchers.Default) {
        withContext(Dispatchers.Main) {
            topStories.value = repository.getTopStories()
        }
    }
}