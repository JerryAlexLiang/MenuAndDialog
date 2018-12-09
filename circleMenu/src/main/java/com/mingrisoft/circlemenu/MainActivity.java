package com.mingrisoft.circlemenu;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import view.CircleMenuLayout;


/**
 * 文件名:MainActivity.java
 * 文件功能描述:程序主入口
 * 开发时间:2016年8月4日
 * 公司网址:www.mingribook.com
 * 开发单位:吉林省明日科技有限公司
 */
public class MainActivity extends Activity {

    private CircleMenuLayout mCircleMenuLayout;//自定义圆盘菜单
    private String[] mItemTexts = new String[]{"放大镜 ", "尺子", "分贝测试仪", "手电筒",
            "计算器", "SOS"};//圆盘菜单显示文字
    private int[] mItemImgs = new int[]{R.drawable.home_mbank_1_normal,
            R.drawable.home_mbank_2_normal, R.drawable.home_mbank_3_normal,
            R.drawable.home_mbank_4_normal, R.drawable.home_mbank_5_normal,
            R.drawable.home_mbank_6_normal};//圆盘菜单显示图片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//导入布局
        //初始化圆盘控件
        mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
        //初始化圆盘控件菜单
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
        //自定义控件点击事件
        mCircleMenuLayout
                .setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
                    @Override
                    public void itemClick(View view, int pos) {
                        if (pos == 0) {//下标为0的按钮点击事件
                            //显示放大镜菜单名称
                            Toast.makeText(MainActivity.this, mItemTexts[0] + "",
                                    Toast.LENGTH_SHORT).show();

                        }
                        if (pos == 1) {//下标为1的按钮点击事件
                            //显示工具尺子菜单名称
                            Toast.makeText(MainActivity.this, mItemTexts[1] + "",
                                    Toast.LENGTH_SHORT).show();

                        }
                        if (pos == 2) {//下标为2的按钮点击事件
                            //显示分贝仪
                            Toast.makeText(MainActivity.this, mItemTexts[2] + "",
                                    Toast.LENGTH_SHORT).show();

                        }
                        if (pos == 3) {//下标为3的按钮点击事件
                            //显示手电筒
                            Toast.makeText(MainActivity.this, mItemTexts[3] + "",
                                    Toast.LENGTH_SHORT).show();

                        }
                        if (pos == 4) {//下标为4的按钮点击事件
                            //显示计算器
                            Toast.makeText(MainActivity.this, mItemTexts[4] + "",
                                    Toast.LENGTH_SHORT).show();

                        }
                        if (pos == 5) {//下标为5的按钮点击事件
                            //显示sos
                            Toast.makeText(MainActivity.this, mItemTexts[5] + "",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    //圆盘中间点击事件
                    public void itemCenterClick(View view) {
                        //显示关于信息
                        Toast.makeText(MainActivity.this, "关于信息",
                                Toast.LENGTH_SHORT).show();
                    }
                });

    }


}
