package egym.omar.egymtask.activities

import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import dagger.android.DaggerActivity
import egym.omar.egymtask.databinding.ActivityMainBinding
import egym.omar.egymtask.fragments.StoriesListFragment

class MainActivity : DaggerActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}