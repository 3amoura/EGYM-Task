package egym.omar.egymtask.fragments.stories_list

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import egym.omar.egymtask.R
import egym.omar.egymtask.adapters.TopStoriesAdapter
import egym.omar.egymtask.data.models.TopStory
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
    }

    override fun onStart() {
        super.onStart()
        if (job == null) {
            getTopStories()
        }
    }

    private fun observe() {
        viewModel.topStories.observe(viewLifecycleOwner) { topStoriesList ->
            topStoriesList.let {
                Log.d("StoriesListViewModel", "Stories loaded")
                val topStories = it.results
                val adapter = TopStoriesAdapter(topStories) { topStory ->
                    navigate(topStory)
                }
                binding.topStoriesRecyclerView.adapter = adapter
                binding.progressBar.isVisible = false
            }
        }

        viewModel.failed.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = false
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
    }

    private fun getTopStories() {
        job?.cancel()
        job = lifecycleScope.launch {
            viewModel.getTopStories()
        }
    }

    private fun navigate(topStory: TopStory) {
        findNavController().currentDestination?.getAction(R.id.to_storyDetailsFragment)?.let {
            val action = StoriesListFragmentDirections.toStoryDetailsFragment(topStory)
            binding.root.findNavController()
                .navigate(action)
        }
    }
}