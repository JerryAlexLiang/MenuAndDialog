package com.example.yangliang.menuanddialog;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.yangliang.menuanddialog.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_popup_menu)
    Button btnMenu;
    @BindView(R.id.btn_custom_toast)
    Button btnCustomToast;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //改变状态栏颜色
//        setWindowColor(MainActivity.this, Color.RED);
        //改变状态栏为透明色
        setTranslucent(MainActivity.this);

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.btn_popup_menu, R.id.btn_custom_toast})
    public void onViewClicked(View view) {
//        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_popup_menu:
//                intent.setClass(MainActivity.this, PopupWindowMenuActivity.class);
                //启动PopupWindowMenuActivity
                PopupWindowMenuActivity.actionStart(MainActivity.this);
                break;

            case R.id.btn_custom_toast:
                //启动CustomToastActivity
                CustomToastActivity.actionStart(MainActivity.this);
                break;
        }
//        startActivity(intent);
    }

    private long waitTime = 2000;
    private long touchTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - touchTime) >= waitTime) {
//                Toast.makeText(MainHomeActivity.this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
                ToastUtil.setCustomToast(MainActivity.this, BitmapFactory.decodeResource(getResources(), R.mipmap.icon_true),
                        true, "再按一次退出应用", Color.RED, Color.WHITE, Gravity.CENTER, Toast.LENGTH_SHORT);
                touchTime = currentTime;
            } else {
                finish();
            }
            return true;
        } else if (KeyEvent.KEYCODE_HOME == keyCode) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
