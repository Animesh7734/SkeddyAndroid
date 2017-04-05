package com.skeddy.android.controllers.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import com.skeddy.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class ActivitySignIn extends BaseActivity {

    @BindView(R.id.login_progress)
    ProgressBar pbLoginProgress;
    @BindView(R.id.email)
    AutoCompleteTextView acetEmail;
    @BindView(R.id.password)
    EditText etPassword;
    @BindView(R.id.email_sign_in_button)
    Button bEmailSignInButton;
    @BindView(R.id.email_login_form)
    LinearLayout llEmailLoginForm;
    @BindView(R.id.login_form)
    ScrollView svLoginForm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
    }


    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    @OnClick(R.id.email_sign_in_button)
    public void onEmailSignInClicked(View view) {}
}

