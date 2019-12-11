package com.wd.doctor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import com.wd.doctor.view.LoginActivity;
import com.wd.mvp.base.BaseActivity;
import com.wd.mvp.base.BasePresenter;

public class MainActivity extends AppCompatActivity {

    private TextView tv_miao;
    int count=5;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_miao = findViewById(R.id.tv_miao);

        Message message = handler.obtainMessage(1);
        handler.sendMessageDelayed(message,1000);
        tv_miao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
        }
        });
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    count--;
                    if (count > 0){
                        Message message = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message,1000);
                    }else{
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
            }
        }

    };
}
