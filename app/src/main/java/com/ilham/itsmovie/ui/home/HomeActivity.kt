package com.ilham.itsmovie.ui.home

import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.appcompat.app.AppCompatActivity
import com.ilham.itsmovie.databinding.ActivityHomeBinding
import com.ilham.itsmovie.utils.Util.dp

class HomeActivity : AppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)

        with(activityHomeBinding) {
            viewPager.adapter = sectionPagerAdapter
            tabs.setupWithViewPager(viewPager)
            for (i in 0 until tabs.tabCount) {
                val tab = (tabs.getChildAt(0) as ViewGroup).getChildAt(i)
                val p = tab.layoutParams as MarginLayoutParams
                when (i) {
                    tabs.tabCount - 1 -> {
                        p.setMargins(0, 0, 16.dp, 0)
                    }
                    else -> {
                        p.setMargins(16.dp, 0, 0, 0)
                    }
                }
                tab.requestLayout()
            }
        }


    }
}