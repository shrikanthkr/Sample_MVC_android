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
import com.poshmark.com.samplecleanarchitecture.viewmodel.DetailsViewModel
import com.poshmark.com.samplecleanarchitecture.viewmodel.Fragments

class FlowFragment : Fragment() {

    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Tag : $tag")
        detailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
        Log.d(TAG, "onCreate: hashcode : ${detailsViewModel.hashCode()}")
        detailsViewModel.launch.observe(this, Observer { onLaunchUpdate(it!!) })
        if (savedInstanceState == null) {
            detailsViewModel.startFlow()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_flow, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val tag = arguments?.getString("KEY")
        if (tag != null) {
            val fragment = requireActivity().supportFragmentManager.findFragmentByTag(tag)
            Log.d(TAG, "onActivityCreated: Fragment: ${fragment?.javaClass?.simpleName}")
        }
    }

    private fun onLaunchUpdate(fragments: Fragments) {
        Log.i(TAG, "State: $fragments")
        val fragment = when (fragments) {
            Fragments.HOME -> HomeFragment()
            Fragments.NAME -> NameFragment()
            Fragments.PHONE -> PhoneFragment()
            Fragments.ADDRESS -> AddressFragment()
            Fragments.DETAILS -> DetailsFragment()
        }
        childFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .addToBackStack(null)
            .commit()
    }

    @JvmOverloads
    fun popChildFragments(n: Int = 1) {
        for (i in 0 until n) {
            childFragmentManager.popBackStackImmediate()
        }
    }

    companion object {
        private const val TAG = "FlowFragment"

        fun newInstance(tag: String): FlowFragment {
            val bundle = Bundle()
            bundle.putString("KEY", tag)
            return FlowFragment().apply {
                arguments = bundle
            }
        }
    }
}