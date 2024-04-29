package com.vishal.vishal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;


public class Fragment5 extends Fragment {



    public Fragment5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_5, container, false);

        // Find the ImageView by its ID
        ImageView imageView = view.findViewById(R.id.projects);

        // Set the GIF resource to the ImageView
        imageView.setImageResource(R.drawable.projects);

        // Adding the gif here using glide library
        Glide.with(this).load(R.drawable.projects).into(imageView);

        return view;


    }
}