package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private Button btn_login;
    private TextView txt_register;
    private LinearLayout l2;
    private Animation animation;

    FirebaseAuth mAuth;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        email = findViewById(R.id.mail);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        txt_register = findViewById(R.id.txt_register);
        l2 =findViewById(R.id.l2);
        animation = AnimationUtils.loadAnimation(this, R.anim.anim_top_1);
        l2.setAnimation(animation);



        mAuth = FirebaseAuth.getInstance();

        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_id = email.getText().toString();
                String pwd = password.getText().toString();

                if (TextUtils.isEmpty(pwd) && TextUtils.isEmpty(email_id)) {
                    Toast.makeText(LoginActivity.this, "Fields are empty!!!", Toast.LENGTH_SHORT).show();
                } else {
                    pd =new ProgressDialog(LoginActivity.this);
                    pd.show();
                    pd.setContentView(R.layout.progress_dialog);
                    pd.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    mAuth.signInWithEmailAndPassword(email_id, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                pd.dismiss();
                            }
                        }
                    });
                }
            }
        });



    }


}
