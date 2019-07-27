package com.lunar.fourgifts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends Activity {

    private EditText name;
    private EditText email;
    private EditText pw;
    private EditText phone;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.field_name);
        email = findViewById(R.id.field_email);
        pw = findViewById(R.id.field_pw);
        phone = findViewById(R.id.field_phone);
        nextButton = findViewById(R.id.button_signup_next);

        name.addTextChangedListener(new GenericTextWatcher(name));
        email.addTextChangedListener(new GenericTextWatcher(email));
        pw.addTextChangedListener(new GenericTextWatcher(pw));
        phone.addTextChangedListener(new GenericTextWatcher(phone));
        nextButton.setVisibility(View.INVISIBLE);

        findViewById(R.id.button_signup_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), TutorialActivityOne.class);
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

            if(name.getText().length() > 0 &&
                    email.getText().length() > 0 &&
                    pw.getText().length() > 0 &&
                    phone.getText().length() > 0){

                nextButton.setVisibility(View.VISIBLE);

            }else{

                nextButton.setVisibility(View.INVISIBLE);

            }

        }

    }

}
