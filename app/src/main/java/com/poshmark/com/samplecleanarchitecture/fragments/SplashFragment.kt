package com.poshmark.com.samplecleanarchitecture.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.poshmark.com.samplecleanarchitecture.R
import kotlinx.android.synthetic.main.fragment_splash.*
import java.util.*

class SplashFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Tag: $tag")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        next.setOnClickListener {
            val tag = UUID.randomUUID().toString()
            Log.d(TAG, "onViewCreated: tag: $tag")
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, FlowFragment.newInstance(this.tag.orEmpty()), tag)
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        private const val TAG = "SplashFragment"
    }
}