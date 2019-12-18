package com.wd.doctor.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wd.doctor.R;
import com.wd.doctor.RsaCoder;
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

public class ForgetTwoActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {


    @BindView(R.id.img_back_forget_finish)
    ImageView imgBackForgetFinish;
    @BindView(R.id.et_forget_pwd_finish)
    EditText etForgetPwdFinish;
    @BindView(R.id.img_forget_bi)
    ImageView imgForgetBi;
    @BindView(R.id.img_forget_kai)
    ImageView imgForgetKai;
    @BindView(R.id.et_forget_pwd1_finish)
    EditText etForgetPwd1Finish;
    @BindView(R.id.img_forget_bi1)
    ImageView imgForgetBi1;
    @BindView(R.id.img_forget_kai1)
    ImageView imgForgetKai1;
    @BindView(R.id.bt_finish_forget)
    Button btFinishForget;
    private int count=1;
    private String email;
    private String pwdOne;
    private String pwdTwo;

    @Override
    public void onLoginSuccess(LoginBean data) {

    }

    @Override
    public void onDoctorSuccess(DoctorBean data) {

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
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
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
        return R.layout.activity_forget_two;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
    }

    @OnClick({R.id.img_back_forget_finish, R.id.img_forget_bi, R.id.img_forget_kai, R.id.img_forget_bi1, R.id.img_forget_kai1, R.id.bt_finish_forget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_forget_finish:
                Intent intent = new Intent(ForgetTwoActivity.this, ForgetActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_forget_bi:
                count++;
                if (count%2==0) {
                    imgForgetBi.setVisibility(View.GONE);
                    imgForgetKai.setVisibility(View.VISIBLE);
                    etForgetPwdFinish.setInputType(128);
                }
                break;
            case R.id.img_forget_kai:
                count++;
                if (count%2==1) {
                    imgForgetBi.setVisibility(View.VISIBLE);
                    imgForgetKai.setVisibility(View.GONE);
                    etForgetPwdFinish.setInputType(129);
                }
                break;
            case R.id.img_forget_bi1:
                count++;
                if (count%2==0) {
                    imgForgetBi1.setVisibility(View.GONE);
                    imgForgetKai1.setVisibility(View.VISIBLE);
                    etForgetPwd1Finish.setInputType(128);
                }
                break;
            case R.id.img_forget_kai1:
                count++;
                if (count%2==1) {
                    imgForgetBi1.setVisibility(View.VISIBLE);
                    imgForgetKai1.setVisibility(View.GONE);
                    etForgetPwd1Finish.setInputType(129);
                }
                break;
            case R.id.bt_finish_forget:
                String pwd1 = etForgetPwdFinish.getText().toString().trim();
                String pwd2 = etForgetPwd1Finish.getText().toString().trim();
                if (pwd1.equals(pwd2) ) {
                    try {
                        pwdOne = RsaCoder.encryptByPublicKey(pwd1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    mPresenter.postForgetPresenter(email,pwdOne,pwdOne);
                    Intent intent1 = new Intent(ForgetTwoActivity.this, LoginActivity.class);
                    startActivity(intent1);
                    finish();

                }else {
                    Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                }



                break;
        }
    }
}
