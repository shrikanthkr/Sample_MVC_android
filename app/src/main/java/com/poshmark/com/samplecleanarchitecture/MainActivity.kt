package com.poshmark.com.samplecleanarchitecture

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.poshmark.com.samplecleanarchitecture.fragments.NameFragment
import com.poshmark.com.samplecleanarchitecture.viewmodel.DetailsViewModel
import android.arch.lifecycle.ViewModelProviders




class MainActivity : AppCompatActivity() {

    lateinit var detailsViewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        detailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, NameFragment()).addToBackStack(null).commit()
    }

    fun popBackStack(n: Int) {
        for (i in 0 until n) {
            supportFragmentManager.popBackStack()
            detailsViewModel.clearState()
        }
    }
}
