package com.wd.doctor.view.Show;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
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
import com.wd.mvp.app.App;
import com.wd.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MySelfActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {


    @BindView(R.id.my_photo)
    ImageView myPhoto;
    @BindView(R.id.my_back)
    ImageView myBack;
    @BindView(R.id.my_ling)
    ImageView myLing;
    @BindView(R.id.tv_look)
    TextView tvLook;
    @BindView(R.id.liner_history)
    LinearLayout linerHistory;
    @BindView(R.id.linear_money)
    LinearLayout linearMoney;
    @BindView(R.id.linear_caina)
    LinearLayout linearCaina;
    @BindView(R.id.linear_huifu)
    LinearLayout linearHuifu;
    @BindView(R.id.relative_alpha)
    RelativeLayout relativeAlpha;
    @BindView(R.id.self_update)
    Button selfUpdate;
    @BindView(R.id.self_cancel)
    Button selfCancel;
    @BindView(R.id.relative_self)
    RelativeLayout relativeSelf;
    private Dialog mDialog;
    private View mInflate;
    private Button mBut;
    private Button mDismiss;
    private String departmentName;
    private String jobTitle;
    private String inauguralHospital;
    private String name;
    private String image1;

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
        return R.layout.activity_my_self;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        name = intent.getStringExtra("name");
        inauguralHospital = intent.getStringExtra("inauguralHospital");
        jobTitle = intent.getStringExtra("jobTitle");
        departmentName = intent.getStringExtra("departmentName");
        Glide.with(App.getAppContext()).load(image)
                .placeholder(R.mipmap.image_doctor)
                .into(myPhoto);
myPhoto.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        show(view);
    }
});

    }

    private void show(View view) {
        mDialog = new Dialog(this, R.style.DialogTheme);
        //填充对话框的布局
        mInflate = LayoutInflater.from(this).inflate(R.layout.layout_dialog, null);
        mBut = mInflate.findViewById(R.id.set_but_album);
        mDismiss = mInflate.findViewById(R.id.set_but_dismiss);
        //将布局设置给Dialog
        mDialog.setContentView(mInflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = mDialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;//设置Dialog距离底部的距离
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        mDialog.show();//显示对话框
        //跳转页面
        mBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MySelfActivity.this, UpdateActivity.class);
                startActivityForResult(intent,101);
                mDialog.hide();
            }
        });
        //取消
        mDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });
//
    }

    @OnClick({R.id.my_back, R.id.my_ling, R.id.tv_look, R.id.liner_history, R.id.linear_money, R.id.linear_caina, R.id.linear_huifu, R.id.my_photo, R.id.self_update, R.id.self_cancel,R.id.relative_self})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_back:
                finish();
                break;
            case R.id.my_ling:
                Toast.makeText(this, "铃铛", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_look:

                Intent intent = new Intent(MySelfActivity.this, PersonalActivity.class);

                startActivity(intent);
                break;
            case R.id.liner_history:
                Intent intent1 = new Intent(MySelfActivity.this, HistoryActivity.class);
                startActivity(intent1);

                break;
            case R.id.linear_money:
                Intent intent2 = new Intent(MySelfActivity.this, MoneyActivity.class);
                startActivity(intent2);
                break;
            case R.id.linear_caina:
                Toast.makeText(this, "采纳", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linear_huifu:
                Toast.makeText(this, "回复", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_photo:
                relativeAlpha.setVisibility(View.VISIBLE);
                selfCancel.setVisibility(View.VISIBLE);
                selfUpdate.setVisibility(View.VISIBLE);
                break;
            case R.id.self_update:
                break;
            case R.id.self_cancel:
                relativeAlpha.setVisibility(View.GONE);
                selfCancel.setVisibility(View.GONE);
                selfUpdate.setVisibility(View.GONE);

                break;
            case R.id.relative_self:

                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent();
            intent.putExtra("image",image1);
            setResult(123,intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==101&&resultCode==100) {
            image1 = data.getStringExtra("image");
            Glide.with(App.getAppContext()).load(image1)
                    .placeholder(R.mipmap.image_doctor)
                    .into(myPhoto);
        }
    }

}
