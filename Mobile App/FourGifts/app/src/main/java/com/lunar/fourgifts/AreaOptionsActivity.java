package com.lunar.fourgifts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

public class AreaOptionsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_options_area);

        findViewById(R.id.option_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), ProjectOptionsActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.from_right, R.anim.nil);

            }
        });

        findViewById(R.id.fab_profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), ProfileActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.from_bottom, R.anim.nil);

            }
        });

    }

    @Override
    public void onBackPressed() {

        // Do nothing

    }

}
