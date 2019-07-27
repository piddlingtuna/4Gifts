package com.lunar.fourgifts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TutorialActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_one);

        findViewById(R.id.tutorial1).setOnTouchListener(new OnSwipeTouchListener(TutorialActivityOne.this) {

            public void onSwipeLeft() {

                toNextTutorial();

            }

        });

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        overridePendingTransition(R.anim.nil, R.anim.to_right);

    }

    private void toNextTutorial() {

        Intent i = new Intent(this, TutorialActivityTwo.class);
        startActivity(i);
        overridePendingTransition(R.anim.from_right, R.anim.nil);

    }

}
