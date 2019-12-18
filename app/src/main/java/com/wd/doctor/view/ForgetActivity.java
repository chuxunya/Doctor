package com.wd.doctor.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class ForgetActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {


    @BindView(R.id.img_back_forget)
    ImageView imgBackForget;
    @BindView(R.id.et_forget_email)
    EditText etForgetEmail;
    @BindView(R.id.bt_code_forget)
    Button btCodeForget;
    @BindView(R.id.et_forget_pwd)
    EditText etForgetPwd;
    @BindView(R.id.bt_next_forget)
    Button btNextForget;
    private String message;
    private String message1;
    private String email;
    private String code;

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
        message1 = data.getMessage();
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        if (message1.equals("验证通过")){
            Intent intent = new Intent(ForgetActivity.this, ForgetTwoActivity.class);
            intent.putExtra("email",email);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSendCodeSuccess(CodeBean data) {
        message = data.getMessage();

        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
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
        return R.layout.activity_forget;
    }



    @OnClick({R.id.img_back_forget, R.id.bt_code_forget, R.id.bt_next_forget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back_forget:
                Intent intent = new Intent(ForgetActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.bt_code_forget:
                email = etForgetEmail.getText().toString().trim();
                mPresenter.postSendCodePresenter(email);
                break;
            case R.id.bt_next_forget:
                String trim = etForgetEmail.getText().toString().trim();
                code = etForgetPwd.getText().toString().trim();
                if (TextUtils.isEmpty(trim)||TextUtils.isEmpty(code)){
                    Toast.makeText(this, "邮箱或验证码为空", Toast.LENGTH_SHORT).show();
                }else {
                    mPresenter.postCheckCodePresenter(trim,code);
                }



                break;
        }
    }
}
