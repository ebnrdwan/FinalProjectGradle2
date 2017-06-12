package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;




public class PaidMainF extends Fragment {




    public PaidMainF() {
        // Required empty public constructor
    }

    public static PaidMainF newInstance() {
        PaidMainF fragment = new PaidMainF();
        Bundle args = new Bundle();


        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_paid_main, container, false);


        Button button = (Button) root.findViewById(R.id.jokebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jokeAsync myjokeAsync = new jokeAsync(getActivity());
                myjokeAsync.execute();
            }
        });


        return root;


    }
}
