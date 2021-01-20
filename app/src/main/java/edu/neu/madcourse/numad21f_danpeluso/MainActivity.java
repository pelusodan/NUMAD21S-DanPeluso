package edu.neu.madcourse.numad21f_danpeluso;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    private Button aboutButton;
    private TextView emailTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAboutClickListener();
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