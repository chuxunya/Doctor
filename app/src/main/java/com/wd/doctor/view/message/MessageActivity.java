package com.wd.doctor.view.message;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.doctor.R;
import com.wd.doctor.bean.ForgetBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.Show.BodyBean;
import com.wd.doctor.bean.Show.DoctorBean;
import com.wd.doctor.bean.Show.SearchBean;
import com.wd.doctor.bean.login.CodeBean;
import com.wd.doctor.bean.login.KeShiBean;
import com.wd.doctor.bean.login.SettledInBean;
import com.wd.doctor.bean.login.ZhiZeBean;
import com.wd.doctor.bean.message.MessageBean;
import com.wd.doctor.contract.HomeContract;
import com.wd.doctor.presenter.HomePresenter;
import com.wd.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {

    @BindView(R.id.message_back)
    ImageView messageBack;
    @BindView(R.id.message_yidu)
    TextView messageYidu;
    @BindView(R.id.message_x)
    ImageView messageX;
    @BindView(R.id.message_bt)
    Button messageBt;
    @BindView(R.id.message_xitong)
    LinearLayout messageXitong;
    @BindView(R.id.message_wen)
    LinearLayout messageWen;
    @BindView(R.id.message_hb)
    LinearLayout messageHb;
    @BindView(R.id.relative_delete)
    RelativeLayout relativeDelete;
    private String sessionId;
    private String id;

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences doctor = getSharedPreferences("doctor", MODE_PRIVATE);
        id = doctor.getString("id", "");
        sessionId = doctor.getString("sessionId", "");

    }

    @Override
    public void onLoginSuccess(LoginBean data) {

    }

    @Override
    public void onDoctorSuccess(DoctorBean data) {

    }

    @Override
    public void onAllMeaageSuccess(MessageBean data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSearchSuccess(SearchBean data) {

    }

    @Override
    public void onBodySuccess(BodyBean data) {

    }

    @Override
    public void onForgetSuccess(ForgetBean data) {

    }

    @Override
    public void onChecKCodeSuccess(ForgetBean data) {

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
        return R.layout.activity_message;
    }


    @OnClick({R.id.message_back, R.id.message_yidu, R.id.message_x, R.id.message_bt, R.id.message_xitong, R.id.message_wen, R.id.message_hb})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.message_back:
                finish();
                break;
            case R.id.message_yidu:
                mPresenter.putAllMessagePresenter(id, sessionId);
                break;
            case R.id.message_x:
                break;
            case R.id.message_bt:

                break;
            case R.id.message_xitong:
                break;
            case R.id.message_wen:
                break;
            case R.id.message_hb:
                break;
        }
    }

}
