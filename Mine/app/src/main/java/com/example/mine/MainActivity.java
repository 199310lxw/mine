package com.example.mine;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout ll_frg_container;
    private LinearLayout ll_frg_first;
    private LinearLayout ll_frg_second;
    private LinearLayout ll_frg_three;
    private LinearLayout ll_frg_four;

    private HomeFrgFirst fragment_first;
    private HomeFrgSecond fragment_second;
    private HomeFrgThree fragment_three;
    private HomeFrgFour fragment_four;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
   private void initView(){
       // 获取Fragment对象
       FragmentManager fm = getFragmentManager();
       // 开启一个事物
       FragmentTransaction fragmentTransaction  = fm.beginTransaction();
       // 将自己创建的fragment通过对象引入
        ll_frg_container=(LinearLayout)findViewById(R.id.ll_frg_container);
        ll_frg_first=(LinearLayout)findViewById(R.id.ll_frg_first);
        ll_frg_second=(LinearLayout)findViewById(R.id.ll_frg_second);
        ll_frg_three=(LinearLayout)findViewById(R.id.ll_frg_three);
        ll_frg_four=(LinearLayout)findViewById(R.id.ll_frg_four);
        ll_frg_first.setOnClickListener(this);
       ll_frg_second.setOnClickListener(this);
       ll_frg_three.setOnClickListener(this);
       ll_frg_four.setOnClickListener(this);

       fragment_first  = new HomeFrgFirst();
       fragment_second=new HomeFrgSecond();
       fragment_three=new HomeFrgThree();
       fragment_four=new HomeFrgFour();
       // 向容器内加入Fragment，一般使用add或者replace方法实现，需要传入容器的id和Fragment的实例
       fragmentTransaction .replace(R.id.ll_frg_container,fragment_first);
       fragmentTransaction .commit();
   }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (v.getId()){
            case R.id.ll_frg_first:
                fragmentTransaction .replace(R.id.ll_frg_container,fragment_first);
                fragmentTransaction .commit();
                break;
            case R.id.ll_frg_second:
                fragmentTransaction .replace(R.id.ll_frg_container,fragment_second);
                fragmentTransaction .commit();
                break;
            case R.id.ll_frg_three:
                fragmentTransaction .replace(R.id.ll_frg_container,fragment_three);
                fragmentTransaction .commit();
                break;
            case R.id.ll_frg_four:
                fragmentTransaction .replace(R.id.ll_frg_container,fragment_four);
                fragmentTransaction .commit();
                break;
        }
    }
}
