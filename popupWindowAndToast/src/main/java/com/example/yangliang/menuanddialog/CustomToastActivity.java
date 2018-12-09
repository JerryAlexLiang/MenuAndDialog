package com.example.yangliang.menuanddialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.yangliang.menuanddialog.widget.CustomToast;
import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建日期：2018/6/17 on 下午11:41
 * 描述: 自定义消息提示弹窗toast
 * 作者: liangyang
 */
public class CustomToastActivity extends BaseActivity {

    @BindView(R.id.btn_toast_one)
    Button btnToastOne;
    private CustomToast customToast;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_custom_toast);
//    }

    /**
     * 启动该活动
     */
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, CustomToastActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_custom_toast;
    }

    @Override
    protected void initView() {
        fullScreen(CustomToastActivity.this);
        //创建Toast
        customToast = new CustomToast.Builder(this)
                .setMessage("自定义Toast效果~")//设置提示文字
                .setBackgroundColor(0xe9ff4587)//设置背景颜色
                .setGravity(Gravity.CENTER)//设置吐司位置
                .showIcon(true)//是否显示图标
                .setTextColor(Color.BLUE)//设置字体的颜色为蓝色
                .build();//创建吐司

        //设置按钮的单击事件并设置按钮的防抖动
        //用throttleFirst来使得按钮每间隔2秒才会再次响应其点击事件
        RxView.clicks(btnToastOne)
                .throttleFirst(2, TimeUnit.SECONDS) // 设置间隔2秒才能发送下一个事件
                .subscribe(aVoid -> customToast.show());
    }

    @Override
    protected void initData() {

    }

//    @OnClick(R.id.btn_toast_one)
//    public void onViewClicked() {
//        customToast.show();
//    }

    /**
     * 通过设置全屏，设置状态栏透明
     *
     * @param activity
     */
    private void fullScreen(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
                Window window = activity.getWindow();
                View decorView = window.getDecorView();
                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
                //导航栏颜色也可以正常设置
//                window.setNavigationBarColor(Color.TRANSPARENT);
            } else {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
                attributes.flags |= flagTranslucentStatus;
                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
    }

}
