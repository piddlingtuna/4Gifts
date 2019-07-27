package com.lunar.fourgifts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TutorialActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_two);

        findViewById(R.id.tutorial2).setOnTouchListener(new OnSwipeTouchListener(TutorialActivityTwo.this) {

            public void onSwipeLeft() {

                toNextTutorial();

            }

            public void onSwipeRight() {

                toPrevTutorial();

            }

        });

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        overridePendingTransition(R.anim.nil, R.anim.to_right);

    }

    private void toNextTutorial() {

        Intent i = new Intent(this, TutorialActivityThree.class);
        startActivity(i);
        overridePendingTransition(R.anim.from_right, R.anim.nil);

    }

    private void toPrevTutorial() {

        super.onBackPressed();
        overridePendingTransition(R.anim.nil, R.anim.to_right);

    }

}
