package com.example.mycalculator;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG =  "Register Activity";
    private EditText email,password;
    private Button btn_register;
    private TextView txt_login;
    private RelativeLayout relativeLayout;
    private LinearLayout linearLayout;
    private Animation btn;

    private SignInButton google_register;
    private GoogleSignInClient googleSignInClient;

    private FirebaseAuth mAuth;
    private FirebaseUser user;

    private ProgressDialog pd;

    private static final int RC_SIGN_IN =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email =findViewById(R.id.mail);
        password =findViewById(R.id.password);
        btn_register =findViewById(R.id.btn_register);
        txt_login =findViewById(R.id.txt_login);
        google_register =findViewById(R.id.google_register);
        linearLayout =findViewById(R.id.l1);

        btn = AnimationUtils.loadAnimation(this,R.anim.anim_top_1);
        linearLayout.setAnimation(btn);

        relativeLayout =findViewById(R.id.rl);
        mAuth =FirebaseAuth.getInstance();
        user =FirebaseAuth.getInstance().getCurrentUser();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailId = email.getText().toString();
                String pwd =password.getText().toString();

                if(TextUtils.isEmpty(emailId) && TextUtils.isEmpty(pwd)){
                    Toast.makeText(RegisterActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(emailId)){
                    email.setError("Email required please enter email-id");
                    email.requestFocus();
                }else if(TextUtils.isEmpty(pwd)){
                    password.setError("Password required please enter password");
                    password.requestFocus();
                }else{
                    mAuth.createUserWithEmailAndPassword(emailId,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                finish();
                            }else{
                                Toast.makeText(RegisterActivity.this, task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });


        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();

        googleSignInClient = GoogleSignIn.getClient(this,gso);

        google_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });


    }

    private void signIn() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task =GoogleSignIn.getSignedInAccountFromIntent(data);
            signInHandler(task);
        }
    }

    private void signInHandler(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount acc = task.getResult(ApiException.class);
            FirebaseGoogleAuth(acc);
        }catch (ApiException e){
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(null);
        }
    }

    private void FirebaseGoogleAuth(GoogleSignInAccount acc) {
        pd =new ProgressDialog(RegisterActivity.this);
        pd.show();
        pd.setContentView(R.layout.google_sign_in_pd);
        pd.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        AuthCredential authCredential = GoogleAuthProvider.getCredential(acc.getIdToken(), null);
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    finish();
                }else{
                    Toast.makeText(RegisterActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        if(user != null){
            startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            finish();
        }
    }

}
