package egym.omar.egymtask.fragments.web_view_fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import dagger.android.support.DaggerFragment
import egym.omar.egymtask.R
import egym.omar.egymtask.databinding.FragmentWebViewBinding

class WebViewFragment : DaggerFragment(R.layout.fragment_web_view) {

    private lateinit var binding: FragmentWebViewBinding
    private val args: WebViewFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWebViewBinding.bind(view)
        showWebPage()
    }

    private fun showWebPage() {
        val url = arguments?.let { args.url }
        url?.let {
            binding.webView.loadUrl(it)
        }
    }
}