package com.square.haoya.sign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.square.haoya.R;

public class SignUpActivity extends Activity {

    private Button btn_submit=null;
    private EditText register_username=null;
    private EditText register_password=null;
    private EditText reregister_password=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        register_username=(EditText)findViewById(R.id.username_up);
        register_password=(EditText)findViewById(R.id.password_up);
        reregister_password=(EditText)findViewById(R.id.password_confirm);
        btn_submit=(Button)findViewById(R.id.submit_up);
        register_username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    SignUpActivity.this.register_username.setHint("");
                } else {
                    if (register_username.getText().toString().trim().length() != 11) {
                        Toast.makeText(SignUpActivity.this, "用户名不等于11位", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        register_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    SignUpActivity.this.register_password.setHint("");
                }
                else{
                    if (register_password.getText().toString().trim().length()<6){
                        Toast.makeText(SignUpActivity.this, "密码不能小于6位", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        reregister_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    SignUpActivity.this.reregister_password.setHint("");
                }
                else{
                    if(!reregister_password.getText().toString().trim().equals(register_password.getText().toString().trim())){
                        Toast.makeText(SignUpActivity.this, "密码不一致", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!checkEdit()){
                    return;
                }
                Intent subIntent = new Intent(SignUpActivity.this, PhoneVerifyActivity.class);
                startActivity(subIntent);
            }
        });
    }

    /*点击提交按钮时的检查*/
    private boolean checkEdit(){
        if(register_username.getText().toString().trim().equals("")){
            Toast.makeText(SignUpActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
        } else if(register_password.getText().toString().trim().length()<6){
            Toast.makeText(SignUpActivity.this,"密码长度不足六位",Toast.LENGTH_SHORT).show();
        } else if (!reregister_password.getText().toString().trim().equals(register_password.getText().toString().trim())){
            Toast.makeText(SignUpActivity.this, "密码不一致！", Toast.LENGTH_SHORT).show();
        } else{
            return true;
        }
        return false;
    }
}
