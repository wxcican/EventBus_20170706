package com.fuicuiedu.xc.eventbus_20170706;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册EventBus
        EventBus.getDefault().register(this);

        button = (Button) findViewById(R.id.mian_btn);
        textView = (TextView) findViewById(R.id.main_tv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到第二页
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent1(MessageEvent event){
        Log.e("EventBus","MAIN线程模型，处理方法线程为" + Thread.currentThread().getName());
    }
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEvent2(MessageEvent event){
        Log.e("EventBus","ASYNC线程模型，处理方法线程为" + Thread.currentThread().getName());
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEvent3(MessageEvent event){
        Log.e("EventBus","BACKGROUND线程模型，处理方法线程为" + Thread.currentThread().getName());
    }
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEvent4(MessageEvent event){
        Log.e("EventBus","POSTING线程模型，处理方法线程为" + Thread.currentThread().getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //反注册EventBus
        EventBus.getDefault().unregister(this);
    }
}
