package com.example.yangliang.menuanddialog;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.yangliang.menuanddialog.widget.CustomToast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建日期：2018/6/17 on 下午4:47
 * 描述:封装一个BaseActivity并实现沉浸式状态栏
 * BaseActivity完成绑定，子类继承即可。
 * 绑定Activity 必须在setContentView之后。使用ButterKnife.bind(this)进行绑定。
 * 作者:yangliang
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Activity mActivity;
    protected Unbinder unbinder;

    /***获取TAG的activity名称**/
    protected final String TAG = this.getClass().getSimpleName();
    private CustomToast toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", "当前Activity为：" + TAG);
        this.mActivity = this;

        //设置布局
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        //通过注解绑定控件
        unbinder = ButterKnife.bind(this);
        //初始化控件
        initView();
        //初始化数据
        initData();

    }

    /**
     * 设置布局
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化封装自定义Toast
     */
    public void toastUtil(Bitmap icon, boolean isShowIcon, String message, int backgroundColor,
                          int textColor, int gravity, int duration) {
            //创建Toast
            toast = new CustomToast.Builder(this)
                    .setMessage(message)//设置提示文字
                    .showIcon(isShowIcon)//是否显示图标
                    .setIcon(icon)//图标
                    .setBackgroundColor(backgroundColor)//设置背景颜色
                    .setGravity(gravity)//设置吐司位置,Gravity.CENTER
                    .setTextColor(textColor)//设置字体的颜色
                    .setDuration(duration)
                    .build();//创建吐司
            toast.show();
    }

    public <T extends View> T bindView(int id) {
        return (T) findViewById(id);
    }

    /**
     * 设置标题栏颜色
     *
     * @param activity
     * @param color
     */
    public static void setWindowColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 生成一个状态栏大小的矩形
            View StatusView = createStatusView(activity, color);
            // 添加statusView到布局中
            ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
            decorView.addView(StatusView);
            // 设置根布局的参数
            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content))
                    .getChildAt(0);
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
        }
    }

    /**
     * 生成一个状态栏大小的矩形
     *
     * @param activity 需要设置的activity
     * @param color    状态栏的颜色值
     * @return 状态栏矩形条
     */
    private static View createStatusView(Activity activity, int color) {
        // 获得状态栏的高度
        int resourceId = activity.getResources()
                .getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = activity.getResources()
                .getDimensionPixelSize(resourceId);
        // 绘制一个和状态栏一样高度的矩形
        View statusView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout
                .LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight);
        statusView.setLayoutParams(params);
        statusView.setBackgroundColor(color);
        return statusView;
    }

    /**
     * 使状态栏透明
     * 适用于图片作为背景的界面，此时需要图片填充到状态栏
     *
     * @param activity 需要设置的activity
     */
    public static void setTranslucent(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 设置根布局的参数
            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity
                    .findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //移除view绑定
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
