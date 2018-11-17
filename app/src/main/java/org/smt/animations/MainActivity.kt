package org.smt.animations

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import org.smt.animations.databinding.ActivityMainBinding
import org.smt.animations.inject.Injector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java) }

    private lateinit var binding: ActivityMainBinding

    init {
        Injector.get().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel

        setupObservers()
    }

    private fun setupObservers() = viewModel.apply {
        clicked.observe(this@MainActivity, Observer<Void> {
            val intent = Intent(baseContext, ExplodingActivity::class.java)
            val options = ActivityOptionsCompat.makeScaleUpAnimation(
                binding.explodingActivityTextView, binding.explodingActivityTextView.x.toInt(),
                binding.explodingActivityTextView.y.toInt(), 0, 0
            )

            Toast.makeText(baseContext, "Clicked", Toast.LENGTH_LONG).show()
            startActivity(intent, options.toBundle())

//            startActivity(intent, ActivityOptionsCompat.makeCustomAnimation(baseContext, R.anim.scale_up, 0).toBundle())
        })
    }
}
