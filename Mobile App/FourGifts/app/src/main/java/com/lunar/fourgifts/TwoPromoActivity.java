package com.lunar.fourgifts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TwoPromoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_promo);

        findViewById(R.id.button_skip).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Intent i = new Intent(v.getContext(), AreaOptionsActivity.class);

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                AlertDialog dialog = builder.setTitle("Alert")
                        .setMessage("Are you sure? You won't have a chance to claim these $2 again.")
                        .setPositiveButton("Yeah", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                startActivity(i);
                                overridePendingTransition(R.anim.from_right, R.anim.nil);

                            }
                        })
                        .setNegativeButton("Nevermind", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                        }
                        })
                        .create();

                dialog.show();
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.RED);
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            }

        });

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        overridePendingTransition(R.anim.nil, R.anim.to_right);

    }

}
