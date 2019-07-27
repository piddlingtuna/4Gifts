package com.lunar.fourgifts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TutorialActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_three);

        findViewById(R.id.tutorial3).setOnTouchListener(new OnSwipeTouchListener(TutorialActivityThree.this) {

            public void onSwipeRight() {

                toPrevTutorial();

            }

        });

        findViewById(R.id.fab_end_tutorial).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Intent i = new Intent(v.getContext(), TwoPromoActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.from_right, R.anim.nil);

            }

        });

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        overridePendingTransition(R.anim.nil, R.anim.to_right);

    }

    private void toPrevTutorial() {

        super.onBackPressed();
        overridePendingTransition(R.anim.nil, R.anim.to_right);

    }

}
