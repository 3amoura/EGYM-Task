package egym.omar.egymtask.activities

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import egym.omar.egymtask.databinding.ActivityMainBinding

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}