package com.example.yangliang.menuanddialog.utils;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.yangliang.menuanddialog.R;
import com.example.yangliang.menuanddialog.widget.ToastLayout;

public class FloatToastUtil {

    private Activity mActivity;
    private RelativeLayout mToastLayout;
    private ToastLayout mToast;
    private ViewGroup mView;
    private String text;
    private long times;
    private static FloatToastUtil mToastInstance;

    public FloatToastUtil(Activity mActivity, String text, long times) {
        this.mActivity = mActivity;
        this.text = text;
        this.times = times;
    }

    public FloatToastUtil(ViewGroup mView, String text, long times) {
        this.mView = mView;
        this.text = text;
        this.times = times;
    }

    public static FloatToastUtil makeText(Activity mActivity, String text, long times) {
        mToastInstance = new FloatToastUtil(mActivity, text, times);
        return mToastInstance;
    }

    public static FloatToastUtil makeText(ViewGroup mView, String text, long times) {
        mToastInstance = new FloatToastUtil(mView, text, times);
        return mToastInstance;
    }

    public void show() {
        if (mActivity != null) {
            mToastLayout = mActivity.findViewById(R.id.rl_toast);
            if (mToastLayout == null) {
                //判断是否已经添加进母VIEW里，没有则添加进去
                mToast = new ToastLayout(mActivity);
                mActivity.addContentView(mToast, new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, DisplayUtil.dip2px(mActivity, 60)));
            } else {
                //判断是否已经添加进母VIEW里,如果有，则直接取出
                mToast = (ToastLayout) mToastLayout.getParent();
            }
            mToast.setContent(text);
            mToast.showToast(times);
        } else if (mView != null) {
            mToastLayout = mView.findViewById(R.id.rl_toast);
            if (mToastLayout == null) {
                mToast = new ToastLayout(mView.getContext());
                mView.addView(mToast, new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, DisplayUtil.dip2px(mView.getContext(), 60)));
            } else {
                mToast = (ToastLayout) mToastLayout.getParent();
            }
            mToast.setContent(text);
            mToast.showToast(times);
        }
    }

    private boolean isShowToast() {
        if (mToast == null) {
            return false;
        }
        return mToast.isShow();
    }

    public static boolean isShow() {
        if (mToastInstance == null) {
            return false;
        } else {
            boolean isShow = mToastInstance.isShowToast();
            mToastInstance = null;
            return isShow;
        }
    }
}
