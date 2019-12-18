package com.wd.doctor.view.Show;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
import com.wd.doctor.view.Sick.SickActivity;
import com.wd.doctor.view.message.MessageActivity;
import com.wd.mvp.app.App;
import com.wd.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {


    @BindView(R.id.img_show_ling)
    ImageView imgShowLing;
    @BindView(R.id.relative_xin_xiao_xi)
    RelativeLayout relativeXinXiaoXi;
    @BindView(R.id.show_wen)
    RelativeLayout showWen;
    @BindView(R.id.show_da)
    RelativeLayout showDa;
    @BindView(R.id.img_show_tou)
    ImageView imgShowTou;
    @BindView(R.id.tv_show_name)
    TextView tvShowName;
    @BindView(R.id.tv_show_yiyuan)
    TextView tvShowYiyuan;
    @BindView(R.id.tv_Show_zhiwei)
    TextView tvShowZhiwei;
    @BindView(R.id.tv_show_keshi)
    TextView tvShowKeshi;
    @BindView(R.id.show_guan)
    RelativeLayout showGuan;
    private String image;
    private String name;
    private String inauguralHospital;
    private String jobTitle;
    private String departmentName;

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
        return R.layout.activity_show;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        inauguralHospital = intent.getStringExtra("inauguralHospital");
        jobTitle = intent.getStringExtra("jobTitle");
        departmentName = intent.getStringExtra("departmentName");
        image = intent.getStringExtra("image");
        tvShowName.setText(name);
        tvShowYiyuan.setText(inauguralHospital);
        tvShowZhiwei.setText(jobTitle);
        tvShowKeshi.setText(departmentName);
        Glide.with(App.getAppContext()).load(image).into(imgShowTou);

    }

    @OnClick({R.id.img_show_ling, R.id.show_wen, R.id.show_da, R.id.show_guan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_show_ling:
                Intent intent2 = new Intent(ShowActivity.this, MessageActivity.class);
                startActivity(intent2);
                break;
            case R.id.show_wen:
                break;
            case R.id.show_da:
                Intent intent = new Intent(ShowActivity.this, SickActivity.class);
                startActivity(intent);
                break;
            case R.id.show_guan:
                Intent intent1 = new Intent(ShowActivity.this, MySelfActivity.class);
                intent1.putExtra("image",image);
                intent1.putExtra("name",name);
                intent1.putExtra("inauguralHospital",inauguralHospital);
                intent1.putExtra("jobTitle",jobTitle);
                intent1.putExtra("departmentName",departmentName);
                startActivity(intent1);
                break;
        }
    }
}
