package com.vishal.vishal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class contactFragment extends Fragment {

    private EditText nm, ms;
    private ConstraintLayout bt;
    private ImageView instagram, linkd, facebook, twitter;

    public contactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        // Initialize EditText fields
        nm = view.findViewById(R.id.name);
        ms = view.findViewById(R.id.chat);

        // Initialize ConstraintLayout button
        bt = view.findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action on click of send button
                sendMessage();
            }
        });

        // Initialize ImageView for social media icons
        instagram = view.findViewById(R.id.insta);
        linkd = view.findViewById(R.id.linnkedin);
        facebook = view.findViewById(R.id.fb);
        twitter = view.findViewById(R.id.x);

        // Set click listeners for social media icons
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/ig_viishal/");
            }
        });

        linkd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.linkedin.com/in/vishalmishra01/");
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.facebook.com/its.vishal09");
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://twitter.com/viishalm");
            }
        });

        return view;
    }

    private void sendMessage() {
        // Get the message from the EditText
        String message = ms.getText().toString().trim();

        if (!message.isEmpty()) {
            // Send the message (You can implement your sending logic here)
            // For now, let's just show a toast message
            Toast.makeText(getContext(), "Your message is sent", Toast.LENGTH_SHORT).show();

            // Reset the message box
            ms.setText("");
            nm.setText("");
        } else {
            // If the message box is empty, show a toast message
            Toast.makeText(getContext(), "Please enter a message", Toast.LENGTH_SHORT).show();
        }
    }

    private void gotoUrl(String url) {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
