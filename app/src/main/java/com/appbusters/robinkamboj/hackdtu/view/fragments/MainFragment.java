package com.appbusters.robinkamboj.hackdtu.view.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.appbusters.robinkamboj.hackdtu.R;
import com.appbusters.robinkamboj.hackdtu.view.PrivateMapsActivity;
import com.appbusters.robinkamboj.hackdtu.view.PublicActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

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

        private_walk = (Button) v.findViewById(R.id.private_walk);
        public_walk = (Button) v.findViewById(R.id.public_walk);

        imageView1 = (ImageView) v.findViewById(R.id.imageView1);
        imageView2 = (ImageView) v.findViewById(R.id.imageView2);

        Glide.with(this)
                .load("https://3.bp.blogspot.com/-TS-cRx0ckOY/WJ4h0MiepKI/AAAAAAAAAGY/6Im2ByybWEQ7PLOT9qLzvWUlsc6Wk3sjgCLcB/s1600/one.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .into(imageView1);

        Glide.with(this)
                .load("https://1.bp.blogspot.com/-osLp51eo35c/WJ4hzg9lmKI/AAAAAAAAAGU/SrD1dvItE-g0--55uao-H3HdN1nbAMJ3ACLcB/s1600/two.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .into(imageView2);

        private_walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), PrivateMapsActivity.class);
                getActivity().startActivity(i);
            }
        });

        public_walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), PublicActivity.class);
                getActivity().startActivity(i);
            }
        });

        return v;
    }

}
