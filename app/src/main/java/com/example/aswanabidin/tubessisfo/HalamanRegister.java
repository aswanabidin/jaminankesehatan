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

public class HalamanRegister extends Activity implements View.OnClickListener {

    private Button btnRegister;
    private EditText edTextEmail;
    private EditText edTextPassword;
    private TextView textViewSignin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_register);

        ImageView myImageView = (ImageView) findViewById(R.id.imageView);
        myImageView.setImageResource(R.drawable.logotubes);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        edTextEmail = (EditText) findViewById(R.id.edTextEmail);
        edTextPassword = (EditText) findViewById(R.id.edTextPassword);

        textViewSignin = (TextView) findViewById(R.id.textViewSignin);

        btnRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
    }

    private void registerUser() {
        String email = edTextEmail.getText().toString().trim();
        String password = edTextPassword.getText().toString().trim();

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

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), HalamanBiodata.class));
                        } else {
                            //display some message here
                            Toast.makeText(HalamanRegister.this, "Registration Error", Toast.LENGTH_LONG).show();

                        }
                    }
                });


    }


    @Override
    public void onClick(View view) {
        if (view == btnRegister) {
            registerUser();
        }

        if (view == textViewSignin) {
            startActivity(new Intent(this, HalamanLogin.class));
        }
    }
}
