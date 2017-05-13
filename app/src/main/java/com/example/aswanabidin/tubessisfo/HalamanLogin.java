package com.example.aswanabidin.tubessisfo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class HalamanLogin extends Activity implements View.OnClickListener {

    private Button btnLogin;
    private EditText edTextEmail;
    private EditText edTextPassword;
    private TextView textViewSignup;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_login);

        ImageView myImageView = (ImageView) findViewById(R.id.imageView);
        myImageView.setImageResource(R.drawable.logotubes);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            //profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(), HalamanTabbed.class));

        }

        edTextEmail = (EditText) findViewById(R.id.edTextEmail);
        edTextPassword = (EditText) findViewById(R.id.edTextPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        textViewSignup = (TextView) findViewById(R.id.textViewSignup);

        progressDialog = new ProgressDialog(this);

        btnLogin.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
    }


    private void userLogin() {
        String email = edTextEmail.getText().toString().trim();
        final String password = edTextPassword.getText().toString().trim();

        //checking if email and password from edit texts
        if (TextUtils.isEmpty(email)) {
            //email is empty
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_LONG).show();
            //stopping the function execution further
            return;
        }

        if (TextUtils.isEmpty(password)) {
            //password is empty
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            //stopping the function execution further
            return;
        }

        // if validations are ok
        //we will first show a progressbar

        progressDialog.setMessage("Login Please Wait...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            //start the profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), HalamanTabbed.class));
                        } else {
                            //display some message here
                            Toast.makeText(HalamanLogin.this, "Akun tidak terdaftar", Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == btnLogin) {
            userLogin();
        }

        if (view == textViewSignup) {
            startActivity(new Intent(this, HalamanRegister.class));
        }
    }
}
