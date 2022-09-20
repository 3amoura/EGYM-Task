package egym.omar.egymtask.fragments.story_details

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dagger.android.support.DaggerFragment
import egym.omar.egymtask.R
import egym.omar.egymtask.data.models.TopStory
import egym.omar.egymtask.databinding.FragmentStoryDetailsBinding

class StoryDetailsFragment : DaggerFragment(R.layout.fragment_story_details) {

    private lateinit var binding: FragmentStoryDetailsBinding
    private val args: StoryDetailsFragmentArgs by navArgs()
    private var topStory: TopStory? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStoryDetailsBinding.bind(view)
        getDataFromIntent()
        showStory()
    }

    private fun getDataFromIntent() {
        topStory = arguments?.let { args.topStory }
    }

    private fun showStory() {
        binding.titleTextView.text = topStory?.title
        binding.descriptionTextView.text = topStory?.abstract
        binding.authorTextView.text = topStory?.byLine
        topStory?.multimedia?.let {
            if (it.isNotEmpty()) {
                Glide.with(requireContext()).load(it[0].url)
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .into(binding.topStoryImageView)
            }
        }

        binding.seeMoreButton.setOnClickListener {
            navigate(topStory?.url!!)
        }
    }

    private fun navigate(url: String) {
        val action = StoryDetailsFragmentDirections.toWebViewFragment(url)
        binding.root.findNavController()
            .navigate(action)
    }
}