package egym.omar.egymtask.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import dagger.android.support.DaggerFragment
import egym.omar.egymtask.R
import egym.omar.egymtask.adapters.TopStoriesAdapter
import egym.omar.egymtask.databinding.FragmentStoriesListBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class StoriesListFragment : DaggerFragment(R.layout.fragment_stories_list) {

    private lateinit var binding: FragmentStoriesListBinding
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: StoriesListViewModel by viewModels {
        viewModelFactory
    }
    private var job: Job? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStoriesListBinding.bind(view)
        observe()
        getTopStories()
    }

    private fun observe() {
        viewModel.topStories.observe(viewLifecycleOwner) {
            val topStories = it.results
            val adapter = TopStoriesAdapter(topStories)
            binding.topStoriesRecyclerView.adapter = adapter
        }
    }

    private fun getTopStories() {
        job?.cancel()
        job = lifecycleScope.launch {
            viewModel.getTopStories()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            StoriesListFragment()
    }
}