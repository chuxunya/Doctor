package com.wd.doctor.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.doctor.MainActivity;
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

public class SettledInActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {

    @BindView(R.id.et_in_email)
    EditText etInEmail;
    @BindView(R.id.tv_in_code)
    TextView tvInCode;
    @BindView(R.id.et_in_code)
    EditText etInCode;
    @BindView(R.id.et_in_pwd)
    EditText etInPwd;
    @BindView(R.id.img_bi)
    ImageView imgBi;
    @BindView(R.id.img_kai)
    ImageView imgKai;
    @BindView(R.id.et_in_pwd_two)
    EditText etInPwdTwo;
    @BindView(R.id.img_bi_two)
    ImageView imgBiTwo;
    @BindView(R.id.img_kai_two)
    ImageView imgKaiTwo;
    @BindView(R.id.bt_next)
    Button btNext;
    private String email;
    private int count=1;

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

    }

    @Override
    public void onChecKCodeSuccess(ForgetBean data) {

    }

    @Override
    public void onSendCodeSuccess(CodeBean data) {
        String message = data.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
        return R.layout.activity_settled_in;
    }


    @OnClick({R.id.tv_in_code, R.id.img_bi, R.id.img_kai, R.id.img_bi_two, R.id.img_kai_two, R.id.bt_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_in_code:

                email = etInEmail.getText().toString().trim();

                mPresenter.postSendCodePresenter(email);
                break;
            case R.id.img_bi:
                count++;
                if (count%2==0) {
                    //隐藏闭眼
                    imgBi.setVisibility(View.GONE);
                    //显示睁眼
                    imgKai.setVisibility(View.VISIBLE);
                    //显示密码
                    etInPwd.setInputType(128);
                }
                break;
            case R.id.img_kai:
                count++;
                if (count%2==1) {
                    //显示闭眼
                    imgBi.setVisibility(View.VISIBLE);
                    //隐藏睁眼
                    imgKai.setVisibility(View.GONE);
                    //隐藏密码
                    etInPwd.setInputType(129);
                }
                break;
            case R.id.img_bi_two:
                count++;
                if (count%2==0) {
                    //隐藏闭眼
                    imgBiTwo.setVisibility(View.GONE);
                    //显示睁眼
                    imgKaiTwo.setVisibility(View.VISIBLE);
                    //显示密码
                    etInPwdTwo.setInputType(128);
                }
                break;
            case R.id.img_kai_two:
                count++;
                if (count%2==1) {
                    //显示闭眼
                    imgBiTwo.setVisibility(View.VISIBLE);
                    //隐藏睁眼
                    imgKaiTwo.setVisibility(View.GONE);
                    //隐藏密码
                    etInPwdTwo.setInputType(129);
                }
                break;
            case R.id.bt_next:
                String email = etInEmail.getText().toString().trim();
                String code = etInCode.getText().toString().trim();
                String pwd1 = etInPwd.getText().toString().trim();
                String pwd2 = etInPwdTwo.getText().toString().trim();
                Intent intent = new Intent(SettledInActivity.this, SettledTwoActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("code",code);
                intent.putExtra("pwd1",pwd1);
                intent.putExtra("pwd2",pwd2);
                startActivity(intent);

                break;
        }
    }
}
