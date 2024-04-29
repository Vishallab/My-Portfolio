package com.vishal.vishal;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goButton = findViewById(R.id.gobtn);

        // Initialize GestureDetectorCompat
        gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());

        // Set click listener on the button
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the next activity
                startActivity(new Intent(MainActivity.this, BaseActivity.class));

                // Apply animation to simulate swipe effect
                applySwipeAnimation(goButton);
            }
        });

        // Set touch listener on the button
        goButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Pass touch events to GestureDetectorCompat
                gestureDetectorCompat.onTouchEvent(event);
                return true;
            }
        });
    }

    // Custom gesture listener class
    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            // Detect swipe gesture
            float deltaX = e2.getX() - e1.getX();
            float deltaY = e2.getY() - e1.getY();
            if (Math.abs(deltaX) > Math.abs(deltaY)) {
                // Horizontal swipe detected
                if (deltaX > 0) {
                    // Right swipe detected, launch the next activity
                    startActivity(new Intent(MainActivity.this, ActivitySplash.class));

                    // Apply animation to simulate swipe effect
                    Button goButton = findViewById(R.id.gobtn);
                    applySwipeAnimation(goButton);
                }
            }
            return true;
        }
    }

    // Apply animation to simulate swipe effect
    private void applySwipeAnimation(View view) {
        TranslateAnimation animation = new TranslateAnimation(0, 50, 0, 0);
        animation.setDuration(200); // Set duration to make it faster
        animation.setFillAfter(true); // Keep the final position after animation
        animation.setInterpolator(new DecelerateInterpolator()); // Apply decelerate interpolation for a smoother appearance
        view.startAnimation(animation);
    }

}
