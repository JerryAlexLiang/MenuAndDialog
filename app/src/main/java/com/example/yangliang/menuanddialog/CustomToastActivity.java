package com.example.yangliang.menuanddialog;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
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
        /*

        //按钮的点击事件
        RxView.clicks(hintToast)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(aVoid -> myToast.show());
         */
        //创建Toast
        customToast = new CustomToast.Builder(this)
                .setMessage("自定义Toast效果~")//设置提示文字
                .setBackgroundColor(0xe9ff4587)//设置背景颜色
                .setGravity(Gravity.CENTER)//设置吐司位置
                .showIcon(true)//是否显示图标
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
}
