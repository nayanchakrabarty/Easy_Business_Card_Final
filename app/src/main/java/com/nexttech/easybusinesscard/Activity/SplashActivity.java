package com.nexttech.easybusinesscard.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nexttech.easybusinesscard.DB.BusinessCardDb;
import com.nexttech.easybusinesscard.Model.UserInfoModel;
import com.nexttech.easybusinesscard.R;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {
    ImageView imageView;

    TextView textView;

    BusinessCardDb businessCardDb;
    ArrayList<UserInfoModel> userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.imageview);
        textView = findViewById(R.id.text);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                businessCardDb = new BusinessCardDb(SplashActivity.this);

                userData = businessCardDb.getUserData();

                Intent i;

                if (userData.size()>0){
                    i = new Intent(SplashActivity.this,MainActivity.class);
                } else {
                    i = new Intent(SplashActivity.this,InformationActivity.class);
                }

                startActivity(i);
                finish();
            }
        },5000);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.goup);
        myanim.setFillAfter(true);

        myanim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {


                textView.setVisibility(View.VISIBLE);


                Animation anim = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.mysplashanimation);
                textView.startAnimation(anim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageView.startAnimation(myanim);



    }


}
