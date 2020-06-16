package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class SplashActivity extends AppCompatActivity {
    private Handler handler;
   private RelativeLayout relativeLayout;
   private ImageView logo;
   private TextView title;

   private Animation anim_top,anim_bottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        relativeLayout =findViewById(R.id.relative);
        logo =findViewById(R.id.logo);
        title =findViewById(R.id.title);

        anim_top = AnimationUtils.loadAnimation(this,R.anim.anim_top);
        anim_bottom =AnimationUtils.loadAnimation(this,R.anim.anim_bottom);

        logo.setAnimation(anim_top);
        title.setAnimation(anim_bottom);

        handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,RegisterActivity.class));
                finish();

            }
        },5000);
    }

    @Override
    public void onBackPressed() {
        showSnackbar();
    }

    private void showSnackbar() {
         Snackbar snackbar = Snackbar.make(relativeLayout,"You can't step back now wait for main page to open",Snackbar.LENGTH_INDEFINITE);
         snackbar.show();
    }
}
