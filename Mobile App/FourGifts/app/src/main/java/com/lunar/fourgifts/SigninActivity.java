package com.lunar.fourgifts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SigninActivity extends Activity {

    private EditText email;
    private EditText pw;
    private Button signinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signin);

        email = findViewById(R.id.field_email);
        pw = findViewById(R.id.field_pw);
        signinButton = findViewById(R.id.button_signin2);

        email.addTextChangedListener(new SigninActivity.GenericTextWatcher(email));
        pw.addTextChangedListener(new SigninActivity.GenericTextWatcher(pw));

        signinButton.setVisibility(View.INVISIBLE);

        findViewById(R.id.button_signin2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), AreaOptionsActivity.class);
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

    /**
     *
     * TEXT WATCHER
     *
     */

    private class GenericTextWatcher implements TextWatcher {

        private View view;

        private GenericTextWatcher(View view) {

            this.view = view;

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if(email.getText().length() > 0 && pw.getText().length() > 0 ){

                signinButton.setVisibility(View.VISIBLE);

            }else{

                signinButton.setVisibility(View.INVISIBLE);

            }

        }

    }

}
