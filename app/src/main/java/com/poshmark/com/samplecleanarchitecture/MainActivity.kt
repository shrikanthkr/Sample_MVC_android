package com.poshmark.com.samplecleanarchitecture

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.poshmark.com.samplecleanarchitecture.fragments.SplashFragment
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val tag = UUID.randomUUID().toString()
            Log.d(TAG, "onCreate: Tag: $tag")
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, SplashFragment(), tag)
                .commit()
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}