package org.smt.animations

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.ScaleAnimation
import org.smt.animations.databinding.ActivityExplodingBinding


class ExplodingActivity : AppCompatActivity() {

    private var animateFirst = true

    lateinit var binding: ActivityExplodingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_exploding)
        title = "foo"
    }

    override fun finish() {
        if (animateFirst) {
            animateFirst = false
            loadAnimation()
        } else {
            super.finish()
        }
    }

    private fun loadAnimation() {
        val v = binding.container
        val x = v.x //+ v.right / 2
        val y = v.y
        val anim = ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, x, y)
        anim.duration = 300
        anim.setAnimationListener(object : AnimationListener {

            override fun onAnimationStart(animation: Animation) {
                // TODO Auto-generated method stub

            }

            override fun onAnimationRepeat(animation: Animation) {
                // TODO Auto-generated method stub

            }

            override fun onAnimationEnd(animation: Animation) {
                binding.container.visibility = View.GONE
                this@ExplodingActivity.finish()
            }
        })
        v.startAnimation(anim)
    }
}
