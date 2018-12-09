package com.mingrisoft.rainbowmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton imageButton_a1, imageButton_b1, imageButton_b2, imageButton_b3,
            imageButton_c1, imageButton_c2, imageButton_c3, imageButton_c4, imageButton_c5,
            imageButton_c6, imageButton_c7;     //触发菜单的按钮
    private RelativeLayout l2, l3;                             //二级与三级菜单布局

    private boolean isl2Show = true;                    //判断二级菜单是否显示
    private boolean isl3Show = true;                    //盘算三级菜单是否显示

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取触发菜单的按钮
        imageButton_a1 = (ImageButton) findViewById(R.id.a_1);
        imageButton_b1 = (ImageButton) findViewById(R.id.b_1);
        imageButton_b2 = (ImageButton) findViewById(R.id.b_2);
        imageButton_b3 = (ImageButton) findViewById(R.id.b_3);
        imageButton_c1 = (ImageButton) findViewById(R.id.c1);
        imageButton_c2 = (ImageButton) findViewById(R.id.c2);
        imageButton_c3 = (ImageButton) findViewById(R.id.c3);
        imageButton_c4 = (ImageButton) findViewById(R.id.c4);
        imageButton_c5 = (ImageButton) findViewById(R.id.c5);
        imageButton_c6 = (ImageButton) findViewById(R.id.c6);
        imageButton_c7 = (ImageButton) findViewById(R.id.c7);
        //按钮注册监听器
        imageButton_a1.setOnClickListener(this);

        imageButton_b1.setOnClickListener(this);
        imageButton_b2.setOnClickListener(this);
        imageButton_b3.setOnClickListener(this);

        imageButton_c1.setOnClickListener(this);
        imageButton_c2.setOnClickListener(this);
        imageButton_c3.setOnClickListener(this);
        imageButton_c4.setOnClickListener(this);
        imageButton_c5.setOnClickListener(this);
        imageButton_c6.setOnClickListener(this);
        imageButton_c7.setOnClickListener(this);

        //获取二级菜单与三级菜单布局
        l2 = (RelativeLayout) findViewById(R.id.level_2);
        l3 = (RelativeLayout) findViewById(R.id.level_3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a_1:
                if (!isl2Show) {
                    //显示2级导航菜单
                    MyAnimation.animationIN(l2, 500);
                } else {
                    if (isl3Show) {
                        //隐藏3级导航菜单
                        MyAnimation.animationOUT(l3, 500, 0);
                        //隐藏2级导航菜单
                        MyAnimation.animationOUT(l2, 500, 500);
                        isl3Show = !isl3Show;
                    } else {
                        //隐藏2级导航菜单
                        MyAnimation.animationOUT(l2, 500, 0);
                    }
                }
                isl2Show = !isl2Show;
                break;
            case R.id.b_1:
                Toast.makeText(this, "已静音", Toast.LENGTH_SHORT).show();
                break;
            case R.id.b_2:
                if (isl3Show) {
                    //隐藏3级导航菜单
                    MyAnimation.animationOUT(l3, 500, 0);
                } else {
                    //显示3级导航菜单
                    MyAnimation.animationIN(l3, 500);

                }
                //根据当前的显示状态设置为相反的状态，如3级菜单已经关闭。这里将设置状态为false
                isl3Show = !isl3Show;
                break;
            case R.id.b_3:
                Toast.makeText(this, "开启声音", Toast.LENGTH_SHORT).show();
                break;
            case R.id.c1:
                Toast.makeText(this, "快退", Toast.LENGTH_SHORT).show();
                break;
            case R.id.c2:
                Toast.makeText(this, "上一集", Toast.LENGTH_SHORT).show();
                break;
            case R.id.c3:
                Toast.makeText(this, "播放", Toast.LENGTH_SHORT).show();
                break;
            case R.id.c4:
                Toast.makeText(this, "暂时没事做！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.c5:
                Toast.makeText(this, "暂停", Toast.LENGTH_SHORT).show();
                break;
            case R.id.c6:
                Toast.makeText(this, "下一集", Toast.LENGTH_SHORT).show();
                break;
            case R.id.c7:
                Toast.makeText(this, "快进", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}



