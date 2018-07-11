package com.poshmark.com.samplecleanarchitecture.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.poshmark.com.samplecleanarchitecture.R;
import com.poshmark.com.samplecleanarchitecture.viewmodel.DetailsViewModel;

public class NameFragment extends Fragment {

    private static final String TAG = "NameFragment";

    @Nullable
    private DetailsViewModel detailsViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_name, container, false);
        final Button button = view.findViewById(R.id.submit);
        final EditText editText = view.findViewById(R.id.name);
        button.setOnClickListener(view1 -> {
            if (detailsViewModel != null) {
                detailsViewModel.setName(editText.getText().toString());
            }
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddressFragment()).addToBackStack(null).commit();
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        detailsViewModel = ViewModelProviders.of(requireActivity()).get(DetailsViewModel.class);
        Log.d(TAG, "onActivityCreated: hashcode : " + detailsViewModel.hashCode());
    }
}
