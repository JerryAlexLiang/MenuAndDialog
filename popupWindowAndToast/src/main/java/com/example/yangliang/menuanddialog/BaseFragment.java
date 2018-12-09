package com.example.yangliang.menuanddialog;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建日期：2018/6/17 on 下午9:44
 * 描述:封装一个BaseFragment
 * 作者:yangliang
 */
public abstract class BaseFragment extends Fragment{

    public static final String TAG = BaseFragment.class.getSimpleName();
    private View mRootView;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutResId(), container, false);
        mUnbinder = ButterKnife.bind(this, mRootView);
        init(savedInstanceState);
        return mRootView;
    }

    protected abstract void init(Bundle savedInstanceState);

    protected abstract int getLayoutResId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
