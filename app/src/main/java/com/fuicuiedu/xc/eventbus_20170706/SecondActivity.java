package com.fuicuiedu.xc.eventbus_20170706;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.second_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("EventBus","发消息的线程为：" + Thread.currentThread().getName());
                        //发事件
                        EventBus.getDefault().post(new MessageEvent("面对疾风吧！"));
                    }
                }).start();
            }
        });
    }
}
