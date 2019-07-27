package com.lunar.fourgifts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        findViewById(R.id.layout_profile).setOnTouchListener(new OnSwipeTouchListener(ProfileActivity.this) {

            public void onSwipeBottom() {

                back();

            }

        });

        findViewById(R.id.content_profile).setOnTouchListener(new OnSwipeTouchListener(ProfileActivity.this) {

            public void onSwipeBottom() {

                back();

            }

        });

        findViewById(R.id.project2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetailsActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.from_right, R.anim.nil);
            }
        });

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        overridePendingTransition(R.anim.nil, R.anim.to_bottom);

    }

    private void back() {

        super.onBackPressed();
        overridePendingTransition(R.anim.nil, R.anim.to_bottom);

    }

}
