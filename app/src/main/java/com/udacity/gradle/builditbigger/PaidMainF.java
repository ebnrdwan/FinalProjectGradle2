package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class PaidMainF extends Fragment {




    public PaidMainF() {
        // Required empty public constructor
    }

    public static PaidMainF newInstance(String param1, String param2) {
        PaidMainF fragment = new PaidMainF();
        Bundle args = new Bundle();


        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View root= inflater.inflate(R.layout.fragment_paid_main, container, false);

        return root;
    }




}
