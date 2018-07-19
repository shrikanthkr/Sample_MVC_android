package com.poshmark.com.samplecleanarchitecture.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.poshmark.com.samplecleanarchitecture.R
import com.poshmark.com.samplecleanarchitecture.utils.requireParentFragment
import com.poshmark.com.samplecleanarchitecture.viewmodel.DetailsViewModel
import com.poshmark.com.samplecleanarchitecture.viewmodel.Fragments
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsViewModel = ViewModelProviders.of(requireParentFragment())
            .get(DetailsViewModel::class.java)
        Log.d(TAG, "onActivityCreated: hashcode : " + detailsViewModel.hashCode())
        detailsViewModel.popMe.postValue(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        start.setOnClickListener {
            detailsViewModel.moveTo(Fragments.NAME)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requireActivity().title = "Home"
    }

    override fun onResume() {
        super.onResume()
        detailsViewModel.popMe.postValue(false)
    }

    companion object {
        private const val TAG = "HomeFragment"
    }
}