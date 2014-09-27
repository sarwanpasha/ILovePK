package com.pakathon.ilovepk;

import com.pakathon.ilovepk.LoginActivity;
import com.pakathon.ilovepk.MainActivity;
import com.pakathon.ilovepk.SignUpActivity;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
	
	protected EditText mUsername;
	protected EditText mPassword;
	protected Button mLoginButton;
	protected TextView mSignUpTextView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_login);
		getActionBar().hide();

		mSignUpTextView = (TextView) findViewById(R.id.signUpText);
		mUsername = (EditText) findViewById(R.id.usernameField);
		mPassword = (EditText) findViewById(R.id.passwordField);
		mLoginButton = (Button) findViewById(R.id.loginButton);
		mSignUpTextView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this,
						SignUpActivity.class);
				startActivity(intent);
			}
		});
		mLoginButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				String username = mUsername.getText().toString();
				String password = mPassword.getText().toString();

				username = username.trim();
				password = password.trim();

				if (username.isEmpty() || password.isEmpty()) {
					
					YoYo.with(Techniques.Tada).duration(700).playOn(findViewById(R.id.usernameField));
					
					YoYo.with(Techniques.Tada).duration(700).playOn(findViewById(R.id.passwordField));
					
					AlertDialog.Builder builder = new AlertDialog.Builder(
							LoginActivity.this);
					builder.setMessage(R.string.login_error_message).setTitle(R.string.login_error_title).setPositiveButton(android.R.string.ok, null);
					AlertDialog dialog = builder.create();
					dialog.show();
				} else {
					// login
					setProgressBarIndeterminateVisibility(true);
					ParseUser.logInInBackground(username, password,
							new LogInCallback() {
								public void done(ParseUser user,
										ParseException e) {
									setProgressBarIndeterminateVisibility(false);

									if (user != null) {
										// Hooray! The user is logged in.
										Intent intent = new Intent(LoginActivity.this,MainActivity.class);
										intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
										intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
										startActivity(intent);
										startActivity(new Intent(LoginActivity.this,MainlogActivity.class));

									} else {
										// Signup failed. Look at the
										// ParseException to see what
										// happened.
										
										YoYo.with(Techniques.Tada)
									    .duration(700)
									    .playOn(findViewById(R.id.usernameField));
										
										YoYo.with(Techniques.Tada)
									    .duration(700)
									    .playOn(findViewById(R.id.passwordField));
										
										AlertDialog.Builder builder = new AlertDialog.Builder(
												LoginActivity.this);
										builder.setMessage(e.getMessage())
												.setTitle(
														R.string.login_error_title)
												.setPositiveButton(
														android.R.string.ok,
														null);
										AlertDialog dialog = builder.create();
										dialog.show();
										startActivity(new Intent(LoginActivity.this,MainlogActivity.class));

									}
								}
							});
				}
			}
		});
	}

	

}
