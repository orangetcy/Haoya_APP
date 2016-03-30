package com.square.haoya.sign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.square.haoya.R;

public class PhoneVerifyActivity extends Activity {

    ImageButton btn_back=null;   //声明标题栏返回按钮
    Button btn_next=null;   //声明下一步按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verify);

        btn_back=(ImageButton)findViewById(R.id.back_sign_up);       //给标题栏返回赋值
        btn_next=(Button)findViewById(R.id.phone_verify_next);  //给下一步赋值

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent=new Intent(PhoneVerifyActivity.this,SignUpActivity.class);
                startActivity(backIntent);
                finish();
            }
        });

    }
}
