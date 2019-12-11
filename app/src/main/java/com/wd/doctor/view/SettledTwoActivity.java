package com.wd.doctor.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.wd.doctor.R;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.login.CodeBean;
import com.wd.doctor.bean.login.KeShiBean;
import com.wd.doctor.bean.login.SettledInBean;
import com.wd.doctor.bean.login.ZhiZeBean;
import com.wd.doctor.contract.HomeContract;
import com.wd.doctor.presenter.HomePresenter;
import com.wd.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettledTwoActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {

    @BindView(R.id.settled_name)
    EditText settledName;
    @BindView(R.id.et_yiyuan)
    EditText etYiyuan;
    @BindView(R.id.et_keshi)
    EditText etKeshi;
    @BindView(R.id.img_keshi)
    ImageView imgKeshi;
    @BindView(R.id.et_zhize)
    EditText etZhize;
    @BindView(R.id.img_zhize)
    ImageView imgZhize;
    @BindView(R.id.bt_two_next)
    Button btTwoNext;

    @Override
    public void onLoginSuccess(LoginBean data) {

    }

    @Override
    public void onSendCodeSuccess(CodeBean data) {

    }

    @Override
    public void onKeShiSuccess(KeShiBean data) {

    }

    @Override
    public void onZhiZeSuccess(ZhiZeBean data) {

    }

    @Override
    public void onSettledIn(SettledInBean data) {

    }

    @Override
    public void onHomeError(String e) {

    }

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_settled_two;
    }


    @OnClick({R.id.img_keshi, R.id.img_zhize, R.id.bt_two_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_keshi:
                break;
            case R.id.img_zhize:
                break;
            case R.id.bt_two_next:
                break;
        }
    }
}
