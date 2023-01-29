package com.semnazri.vgdb.ui

import androidx.fragment.app.Fragment
import com.semnazri.vgdb.R
import com.semnazri.vgdb.base.BaseActivity
import com.semnazri.vgdb.ui.main.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun getLayoutResource(): Int = R.layout.activity_main

    override fun initPage() {
        setSupportActionBar(toolbar)
        toolbar.title = resources.getString(R.string.game4u)
        loadFragment(HomeFragment())
        bottom_navigation_view.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    loadFragment(HomeFragment())
                }
                R.id.menu_search -> {
                    loadFragment(HomeFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun loadFragment(selectedFragment : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_layout, selectedFragment).commit()
    }


    override fun observeData() {
    }
}