package com.poshmark.com.samplecleanarchitecture.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.poshmark.com.samplecleanarchitecture.MainActivity
import com.poshmark.com.samplecleanarchitecture.R
import com.poshmark.com.samplecleanarchitecture.viewmodel.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_details.address
import kotlinx.android.synthetic.main.fragment_details.name
import kotlinx.android.synthetic.main.fragment_details.phone
import kotlinx.android.synthetic.main.fragment_details.submit

class DetailsFragment : Fragment() {

    lateinit var detailsViewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submit.setOnClickListener { (requireActivity() as MainActivity).popBackStack(3) }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        detailsViewModel = ViewModelProviders.of(requireActivity()).get(DetailsViewModel::class.java)
        Log.d(TAG, "onActivityCreated: hashcode : " + detailsViewModel.hashCode())
        name.text = detailsViewModel.name.orEmpty()
        address.text = detailsViewModel.address.orEmpty()
        phone.text = detailsViewModel.phone.orEmpty()
    }

    companion object {

        private const val TAG = "DetailsFragment"
    }
}
