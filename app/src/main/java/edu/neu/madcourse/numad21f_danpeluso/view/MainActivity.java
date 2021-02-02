package edu.neu.madcourse.numad21f_danpeluso.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;

import edu.neu.madcourse.numad21f_danpeluso.R;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    private Button aboutButton;
    private TextView emailTextview;
    private Button newActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAboutClickListener();
        setNewActivityClickListener();
    }

    private void setNewActivityClickListener() {
        newActivityButton = findViewById(R.id.new_activity_button);
        newActivityButton.setOnClickListener(v -> {
            Intent buttonActivityIntent = new Intent(this, ButtonActivity.class);
            startActivity(buttonActivityIntent);
        });
    }

    private void setAboutClickListener() {
        aboutButton = findViewById(R.id.about_button);
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