package com.poshmark.com.samplecleanarchitecture

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.poshmark.com.samplecleanarchitecture.fragments.SplashFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, SplashFragment())
            .commit()
    }
}