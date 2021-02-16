package edu.neu.madcourse.numad21f_danpeluso.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.neu.madcourse.numad21f_danpeluso.R;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    private TextView emailTextview;
    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    launchLocationActivity();
                } else {
                    Toast.makeText(this, "Need location permission to open Activity", Toast.LENGTH_LONG).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAboutClickListener();
        setNewActivityClickListener();
        setLinkCollectorClickListener();
        setLocationButtonClickListener();
    }

    private void setLocationButtonClickListener() {
        Button locationActivityButton = findViewById(R.id.location_activity_button);
        locationActivityButton.setOnClickListener(v -> locationPermissionHandler());
    }

    private void launchLocationActivity() {
        Intent locationIntent = new Intent(this, LocationActivity.class);
        startActivity(locationIntent);
    }

    private void locationPermissionHandler() {
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            launchLocationActivity();
        } else {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
        }
    }

    private void setLinkCollectorClickListener() {
        Button linkCollectorButton = findViewById(R.id.link_collector_button);
        linkCollectorButton.setOnClickListener(v -> {
            Intent linkCollectorActivityIntent = new Intent(this, LinkCollectorActivity.class);
            startActivity(linkCollectorActivityIntent);
        });
    }

    private void setNewActivityClickListener() {
        Button newActivityButton = findViewById(R.id.new_activity_button);
        newActivityButton.setOnClickListener(v -> {
            Intent buttonActivityIntent = new Intent(this, ButtonActivity.class);
            startActivity(buttonActivityIntent);
        });
    }

    private void setAboutClickListener() {
        Button aboutButton = findViewById(R.id.about_button);
        emailTextview = findViewById(R.id.email_textview);
        aboutButton.setOnClickListener(v -> {
            if (emailTextview.getVisibility() == GONE) {
                emailTextview.setVisibility(VISIBLE);
            } else {
                emailTextview.setVisibility(GONE);
            }
        });
    }

}