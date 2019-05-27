package com.lizujian.qrcode.http;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.lizujian.qrcode.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginTest extends AppCompatActivity {

EditText userName_test;
EditText password_test;

private boolean hasUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_test);
        userName_test = findViewById(R.id.test_input_name);
        password_test = findViewById(R.id.test_input_password);
        userName_test.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name = s.toString();
                final String url = "http://192.168.1.122:8080/user/user?username="+name;
                Log.d("test", url);
                final String Msg1 = "用户名不正确";
                hasUserName = false;
                linkNet(url,Msg1);
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        password_test.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name = s.toString();
                final String Msg1 = "密码正确";
                if (hasUserName) {
                    final String url = "http://192.168.1.122:8080/user/password?username="+userName_test.getText().toString();//根据用户名查询到密码并返回对比
                    Log.e("test",url);
                    linkNet(url,Msg1);
                } else {
                    Toast.makeText(LoginTest.this, "请先输入用户名", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void linkNet(final String url,final String Msg1){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url(url)
                        .get()//默认就是GET请求，可以不写
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("test", "请求失败");
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d("test", response.body().string());
                        Log.d("test", password_test.getText().toString());
                        hasUserName = true;
                        if(password_test.getText().toString().equals(response.body().toString())) {
                            Log.d("test", "登陆成功: ");
                        }
                    }
                });
            }
        }).start();
    }
}
