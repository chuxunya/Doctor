package com.wd.doctor.view.Show;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.doctor.R;
import com.wd.doctor.bean.ForgetBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.Show.BodyBean;
import com.wd.doctor.bean.Show.DoctorBean;
import com.wd.doctor.bean.Show.SearchBean;
import com.wd.doctor.bean.Show.SendBean;
import com.wd.doctor.bean.Show.XinagQBean;
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

public class PersonalActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {


    @BindView(R.id.personal_back)
    ImageView personalBack;
    @BindView(R.id.personal_name)
    TextView personalName;
    @BindView(R.id.personal_yiyuan)
    TextView personalYiyuan;
    @BindView(R.id.personal_keshi)
    TextView personalKeshi;
    @BindView(R.id.personal_zhicheng)
    TextView personalZhicheng;
    @BindView(R.id.personal_self)
    TextView personalSelf;
    @BindView(R.id.personal_shanchang)
    TextView personalShanchang;
    @BindView(R.id.personal_phone)
    TextView personalPhone;
    private String name;
    private String inauguralHospital;
    private String departmentName;
    private String jobTitle;
    private String personalProfile;
    private String goodField;


    @Override
    public void onLoginSuccess(LoginBean data) {


    }

    @Override
    public void onSendSuccess(SendBean data) {

    }

    @Override
    public void onXiangSuccess(XinagQBean data) {

    }

    @Override
    public void onDoctorSuccess(DoctorBean data) {
        if (data.getResult()!=null) {
            name = data.getResult().getName();
            inauguralHospital = data.getResult().getInauguralHospital();
            departmentName = data.getResult().getDepartmentName();
            jobTitle = data.getResult().getJobTitle();
            personalProfile = data.getResult().getPersonalProfile();
            goodField = data.getResult().getGoodField();
            personalName.setText(name);
            personalYiyuan.setText(inauguralHospital);
            personalKeshi.setText(departmentName);
            personalZhicheng.setText(jobTitle);
            personalSelf.setText(personalProfile);
            personalShanchang.setText(goodField);
        }else {
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAllMeaageSuccess(MessageBean data) {

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
        return R.layout.activity_personal;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences doctor = getSharedPreferences("doctor", MODE_PRIVATE);
        String id = doctor.getString("id", "");
        String sessionId = doctor.getString("sessionId", "");
        mPresenter.getDoctorPresenter(id,sessionId);


    }

    @OnClick({R.id.personal_back, R.id.personal_phone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_back:
                finish();
                break;
            case R.id.personal_phone:
                break;
        }
    }
}
