package com.lunar.fourgifts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;

public class ProjectOptionsActivity extends Activity {

    private Button moreButton;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_options_project);

        moreButton = findViewById(R.id.button_show_more);
        button1 = findViewById(R.id.button_donate1);
        button2 = findViewById(R.id.button_donate2);
        button3 = findViewById(R.id.button_donate3);
        button4 = findViewById(R.id.button_donate4);

        findViewById(R.id.button_projects_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doBackPressed();

            }
        });

        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moreButton.setVisibility(View.INVISIBLE);

            }
        });

        button1.setOnClickListener(onDonateListener);
        button2.setOnClickListener(onDonateListener);
        button3.setOnClickListener(onDonateListener);
        button4.setOnClickListener(onDonateListener);

        findViewById(R.id.button_detail1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), DetailsActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.from_right, R.anim.nil);

            }
        });

    }

    View.OnClickListener onDonateListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Snackbar.make(findViewById(R.id.fullscreen_content), "You have donated your daily $1 to this charity!", Snackbar.LENGTH_LONG).show();

            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);

            button1.setTextColor(Color.GRAY);
            button2.setTextColor(Color.GRAY);
            button3.setTextColor(Color.GRAY);
            button4.setTextColor(Color.GRAY);

        }
    };

    @Override
    public void onBackPressed() {

        doBackPressed();

    }

    private void doBackPressed() {

        super.onBackPressed();
        overridePendingTransition(R.anim.nil, R.anim.to_right);

    }

}
