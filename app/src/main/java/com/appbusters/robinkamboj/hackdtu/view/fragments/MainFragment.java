package com.appbusters.robinkamboj.hackdtu.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.appbusters.robinkamboj.hackdtu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    ImageView imageView1, imageView2;
    Button private_walk, public_walk;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        imageView1 = (ImageView) v.findViewById(R.id.imageView1);
        imageView2 = (ImageView) v.findViewById(R.id.imageView2);

        private_walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        public_walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return v;
    }

}
