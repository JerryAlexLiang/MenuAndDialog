package com.example.yangliang.menuanddialog;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

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

}
