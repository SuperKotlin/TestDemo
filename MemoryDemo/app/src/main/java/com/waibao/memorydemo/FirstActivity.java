package com.waibao.memorydemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "zhuyongmac";

    private TextView textView;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.e(TAG, "handleMessage执行：" + msg.toString());
            if (textView == null) {
                Log.e(TAG, "htextView is null：");
                return;
            }
            textView.setText("收到了消息:" + msg.toString());
        }
    };

    private static InnerClassMac macYY = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate 执行：");
        setContentView(R.layout.activity_first);
        textView = findViewById(R.id.textView);
        if (macYY == null) {
            macYY = new InnerClassMac();
            Log.e(TAG, "AAAA 执行：");
        }
    }

    public void startSecond(View view) {
        startActivity(new Intent(this, SecondActivity.class));
        finish();
    }

    public void sendMessage(View view) {
        Log.e(TAG, "sendMessage 执行：");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "postDelayed run 执行：");
                handler.sendEmptyMessage(0);
            }
        }, 3000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume 执行：");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause 执行：");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop 执行：");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy 执行：");
    }

    public class InnerClassMac {
        private String label = "AAAA class";
    }

}






