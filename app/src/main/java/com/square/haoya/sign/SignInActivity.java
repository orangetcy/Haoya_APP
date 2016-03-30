package com.square.haoya.sign;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.square.haoya.R;

public class SignInActivity extends Activity {

    private Button btn_up=null; //注册按钮
    private Button btn_in=null; //登录按钮
    private EditText username=null;
    private EditText password=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btn_up=(Button)findViewById(R.id.sign_in_up);   //注册按钮赋值
        btn_in=(Button)findViewById(R.id.sign_in);      //登录按钮赋值
        username=(EditText)findViewById(R.id.username_in);
        password=(EditText)findViewById(R.id.password_in);
        /*设置注册按钮的监听*/
        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent upIntent = new Intent(SignInActivity.this, SignUpActivity.class);
                SignInActivity.this.startActivity(upIntent);
            }
        });

        /*设置登录按钮监听*/
        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    SignInActivity.this.username.setHint("");
                }else{
                    if(username.getText().toString().trim().length()!=11){
                        Toast.makeText(SignInActivity.this, "用户名长度不为11位", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    SignInActivity.this.password.setHint("");
                }else{
                    if(password.getText().toString().trim().length()<6){
                        Toast.makeText(SignInActivity.this, "密码不能短于6位", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
