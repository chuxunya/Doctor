package com.wd.doctor.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.doctor.R;
import com.wd.doctor.RsaCoder;
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
import com.wd.doctor.view.Show.ShowActivity;
import com.wd.mvp.base.BaseActivity;

import butterknife.BindView;
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

            String message = data.getMessage();
        if (data.getResult()!=null) {
            String name = data.getResult().getName();
            String id = data.getResult().getId();
            String sessionId = data.getResult().getSessionId();
            String inauguralHospital = data.getResult().getInauguralHospital();
            String jobTitle = data.getResult().getJobTitle();
            String departmentName = data.getResult().getDepartmentName();
            String image = data.getResult().getImagePic();
            SharedPreferences doctor = getSharedPreferences("doctor", MODE_PRIVATE);
            SharedPreferences.Editor edit = doctor.edit();
            edit.putString("id",id);
            edit.putString("sessionId",sessionId);
            edit.putString("inauguralHospital",inauguralHospital);
            edit.putString("name",name);
            edit.putString("jobTitle",jobTitle);
            edit.putString("image",image);
            edit.putString("departmentName",departmentName);
            edit.commit();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            if (message.equals("登录成功")) {
                Intent intent = new Intent(LoginActivity.this, ShowActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("inauguralHospital",inauguralHospital);
                intent.putExtra("jobTitle",jobTitle);
                intent.putExtra("image",image);
                intent.putExtra("departmentName",departmentName);
                startActivity(intent);
                finish();
            }
        }else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSendSuccess(SendBean data) {

    }

    @Override
    public void onXiangSuccess(XinagQBean data) {

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
                Intent intent1 = new Intent(LoginActivity.this, ForgetActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.tv_settled_in:
                Intent intent = new Intent(LoginActivity.this, SettledInActivity.class);
                startActivity(intent);
                finish();
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
