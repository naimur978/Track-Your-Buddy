package com.naimur978.trackyourbuddy.trackyourbuddy.CustomNavigation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.naimur978.trackyourbuddy.trackyourbuddy.R;


public class HomeFragmentA extends Fragment {



    public HomeFragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homea, container, false);
    }

}
