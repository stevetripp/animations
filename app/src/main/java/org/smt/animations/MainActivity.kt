package org.smt.animations

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
            Toast.makeText(baseContext, "Clicked", Toast.LENGTH_LONG).show()
        })
    }
}
