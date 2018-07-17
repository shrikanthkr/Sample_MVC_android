package com.poshmark.com.samplecleanarchitecture.fragments

import android.arch.lifecycle.Observer
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
import kotlinx.android.synthetic.main.fragment_details.address
import kotlinx.android.synthetic.main.fragment_details.name
import kotlinx.android.synthetic.main.fragment_details.phone
import kotlinx.android.synthetic.main.fragment_details.submit

class DetailsFragment : Fragment() {

    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submit.setOnClickListener { (parentFragment as? HomeFragment)?.popChildFragments(4) }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        detailsViewModel = ViewModelProviders.of(requireParentFragment())
            .get(DetailsViewModel::class.java)
        Log.d(TAG, "onActivityCreated: hashcode : " + detailsViewModel.hashCode())
        detailsViewModel.nameData.observe(this, Observer { onNameUpdate(it!!) })
        detailsViewModel.addressData.observe(this, Observer { onAddressUpdate(it!!) })
        detailsViewModel.phoneData.observe(this, Observer { onPhoneUpdate(it!!) })
    }

    private fun onNameUpdate(name: String) {
        this.name.text = name
    }

    private fun onAddressUpdate(address: String) {
        this.address.text = address
    }

    private fun onPhoneUpdate(phone: String) {
        this.phone.text = phone
    }

    companion object {

        private const val TAG = "DetailsFragment"
    }
}
