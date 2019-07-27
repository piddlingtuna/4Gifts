package com.lunar.fourgifts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        findViewById(R.id.back2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doBackPressed();
            }
        });

        findViewById(R.id.bigdonate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.fullscreen_content), "You have donated your daily $1 to this charity!", Snackbar.LENGTH_LONG).show();
                findViewById(R.id.bigdonate).setEnabled(false);
                findViewById(R.id.bigdonate).setBackgroundColor(Color.GRAY);
            }
        });

    }

    @Override
    public void onBackPressed() {

        doBackPressed();

    }

    private void doBackPressed() {

        super.onBackPressed();
        overridePendingTransition(R.anim.nil, R.anim.to_right);

    }

}
