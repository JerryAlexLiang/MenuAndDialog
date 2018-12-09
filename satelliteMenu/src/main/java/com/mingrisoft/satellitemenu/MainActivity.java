package com.mingrisoft.satellitemenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import view.SatelliteMenu;

public class MainActivity extends AppCompatActivity {
    SatelliteMenu satelliteMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取卫星按钮自定义控件
        satelliteMenu = (SatelliteMenu) findViewById(R.id.satelliteMenu);
        //设置子菜单按钮单击事件
        satelliteMenu.setOnSatelliteMenuItemClickListener(
                new SatelliteMenu.OnSatelliteMenuItemClickListener() {
                    @Override
                    public void onClick(View view, int pos) {
                        //显示子菜单按钮的tag信息
//                        Toast.makeText(MainActivity.this, pos + ":" + view.getTag(), Toast.LENGTH_SHORT).show();
                        switch (pos) {
                            case 1:
                                Toast.makeText(MainActivity.this, pos + ":  view.getTag()： " + view.getTag() + "附件", Toast.LENGTH_SHORT).show();
                                break;

                            case 2:
                                Toast.makeText(MainActivity.this, pos + ":  view.getTag()： " + view.getTag() + "文本", Toast.LENGTH_SHORT).show();
                                break;

                            case 3:
                                Toast.makeText(MainActivity.this, pos + ":  view.getTag()： " + view.getTag() + "图片", Toast.LENGTH_SHORT).show();
                                break;

                            case 4:
                                Toast.makeText(MainActivity.this, pos + ":  view.getTag()： " + view.getTag() + "视频", Toast.LENGTH_SHORT).show();
                                break;

                            case 5:
                                Toast.makeText(MainActivity.this, pos + ":  view.getTag()： " + view.getTag() + "录音", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
    }
}
