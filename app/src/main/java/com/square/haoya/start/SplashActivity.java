package com.square.haoya.start;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.square.haoya.R;
import com.square.haoya.sign.SignInActivity;

public class SplashActivity extends Activity {

    private final int SPLASH_DELAY_TIME=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent=new Intent(SplashActivity.this, SignInActivity.class);
                SplashActivity.this.startActivity(splashIntent);
                SplashActivity.this.finish();
            }
        },SPLASH_DELAY_TIME);
    }
}
