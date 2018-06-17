package com.example.yangliang.menuanddialog;

import android.app.ActionBar;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建日期：2018/6/17 on 下午5:47
 * 描述: 模仿微信右上角弹出菜单
 * 作者: liangyang
 */
public class PopupWindowMenuActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.btn_back)
    RelativeLayout btnBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.btn_enter_more)
    RelativeLayout btnEnterMore;
    private PopupWindow popupWindow;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_popup_window_menu);
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_popup_window_menu;
    }

    @Override
    protected void initView() {
        //设置状态栏背景颜色
        setWindowColor(PopupWindowMenuActivity.this, Color.BLUE);
    }

    @Override
    protected void initData() {
        tvTitle.setText(R.string.popupwindow_tv);
    }

    @OnClick({R.id.btn_back, R.id.btn_enter_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                //返回上一层
                finish();
                break;
            case R.id.btn_enter_more:
                //菜单按钮点击事件
                onMenu(view);
                break;
        }
    }

    private void onMenu(View view) {
        //获取自定义的菜单布局文件
        View popupWindow_view = getLayoutInflater().inflate(R.layout.popup_menu, null, false);
        //创建PopupWindow实例，设置菜单宽度和高度为包裹其自身内容
        popupWindow = new PopupWindow(popupWindow_view, ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT, true);
        //设置菜单显示在按钮的下面
//        popupWindow.showAsDropDown(findViewById(R.id.btn_enter_more), 0, 0);
        popupWindow.showAsDropDown(btnEnterMore, 0, 0);
        //设置点击其他地方消失
        popupWindow_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //如果菜单存在并且未显示状态，就关闭并初始化菜单
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    popupWindow = null;
                }
                return false;
            }
        });

        Button btnOne = popupWindow_view.findViewById(R.id.menu_one);
        Button btnTwo = popupWindow_view.findViewById(R.id.menu_two);
        Button btnThree = popupWindow_view.findViewById(R.id.menu_three);
        Button btnFour = popupWindow_view.findViewById(R.id.menu_four);
        Button btnFive = popupWindow_view.findViewById(R.id.menu_five);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_one:
                Toast.makeText(mActivity, "发起群聊", Toast.LENGTH_SHORT).show();
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    popupWindow = null;
                }
                break;

            case R.id.menu_two:
                Toast.makeText(mActivity, "添加好友", Toast.LENGTH_SHORT).show();
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    popupWindow = null;
                }
                break;

            case R.id.menu_three:
                Toast.makeText(mActivity, "扫一扫", Toast.LENGTH_SHORT).show();
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    popupWindow = null;
                }
                break;

            case R.id.menu_four:
                Toast.makeText(mActivity, "收付款", Toast.LENGTH_SHORT).show();
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    popupWindow = null;
                }
                break;

            case R.id.menu_five:
                Toast.makeText(mActivity, "帮助与反馈", Toast.LENGTH_SHORT).show();
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    popupWindow = null;
                }
                break;
        }
    }
}
