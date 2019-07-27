package com.lunar.fourgifts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Delay
        try {

            Thread.sleep(2000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        // Make sure this is before calling super.onCreate
        setTheme(R.style.FullscreenTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.button_signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), SignupActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.from_right, R.anim.nil);

            }
        });

        findViewById(R.id.button_signin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), SigninActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.from_right, R.anim.nil);

            }
        });

    }

}
