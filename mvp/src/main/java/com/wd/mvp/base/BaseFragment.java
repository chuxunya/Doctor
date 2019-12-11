package com.wd.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.fragment.app.Fragment;

import com.wd.mvp.app.App;
import com.wd.mvp.utils.NetUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 *@describe(描述)：BaseFragment
 *@data（日期）: 2019/11/11
 *@time（时间）: 16:06
 *@author（作者）: xin
 **/
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {

    private Unbinder bind;
    private P mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View inflate = inflater.inflate(provideLayoutId(), container, false);
        bind = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = providePresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initView();
        initData();
    }

    protected abstract P providePresenter();

    protected abstract int provideLayoutId();

    protected void initView() {

    }

    protected void initData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    //判断是否有网络
    public boolean hasNetwork() {
        return NetUtil.hasNet(context());
    }

    //无网提醒
    public void showNoNetTip() {
        Toast.makeText(context(), "无网，请检查网络", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getContext()==null ? App.getAppContext() :getContext();
    }
}