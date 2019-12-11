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

import com.wd.doctor.R;
import com.wd.doctor.RsaCoder;
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

public class LoginActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {


    private static final String TAG = "LoginActivity";
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.pwd_bi)
    ImageView pwdBi;
    @BindView(R.id.pwd_kai)
    ImageView pwdKai;
    @BindView(R.id.tv_forget_pwd)
    TextView tvForgetPwd;
    @BindView(R.id.tv_settled_in)
    TextView tvSettledIn;
    @BindView(R.id.bt_login)
    Button btLogin;
    private String email;
    private String trim;
    private String pwd;
    private int count=1;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void onLoginSuccess(LoginBean data) {
        if (data.getResult()!=null) {
            String message = data.getMessage();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            if (message.equals("登录成功")) {
                Intent intent = new Intent(LoginActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        }

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



    @OnClick({R.id.pwd_bi, R.id.pwd_kai, R.id.tv_forget_pwd, R.id.tv_settled_in, R.id.bt_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pwd_bi:
                count++;
                if (count%2==0) {
                    //隐藏闭眼
                    pwdBi.setVisibility(View.GONE);
                    //显示睁眼
                    pwdKai.setVisibility(View.VISIBLE);
                    //显示密码
                   etPwd.setInputType(128);
                }
                break;
            case R.id.pwd_kai:
                count++;
                if (count%2==1) {
                    //显示闭眼
                    pwdBi.setVisibility(View.VISIBLE);
                    //隐藏睁眼
                    pwdKai.setVisibility(View.GONE);
                    //隐藏密码
                    etPwd.setInputType(129);
                }
                break;
            case R.id.tv_forget_pwd:

                break;
            case R.id.tv_settled_in:
                Intent intent = new Intent(LoginActivity.this, SettledInActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_login:
                email = etEmail.getText().toString().trim();
                trim = etPwd.getText().toString().trim();
                try {
                    pwd = RsaCoder.encryptByPublicKey(trim);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TextUtils.isEmpty(email)||TextUtils.isEmpty(pwd)) {
                    Toast.makeText(this, "您输入的邮箱或密码为空", Toast.LENGTH_SHORT).show();
                }else {
                    mPresenter.postLoginPresenter(email,pwd);
                }
                break;
        }
    }
}
