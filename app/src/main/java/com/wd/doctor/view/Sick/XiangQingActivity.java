package com.wd.doctor.view.Sick;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wd.doctor.HideIMEUtil;
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

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiangQingActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {


    @BindView(R.id.xiang_back)
    ImageView xiangBack;
    @BindView(R.id.xiang_title)
    TextView xiangTitle;
    @BindView(R.id.xiang_name)
    TextView xiangName;
    @BindView(R.id.xiang_bing)
    TextView xiangBing;
    @BindView(R.id.xiang_keshi)
    TextView xiangKeshi;
    @BindView(R.id.xiang_xq)
    TextView xiangXq;
    @BindView(R.id.xiang_yiyuan)
    TextView xiangYiyuan;
    @BindView(R.id.xiang_time)
    TextView xiangTime;
    @BindView(R.id.xiang_jl)
    TextView xiangJl;
    @BindView(R.id.xiang_img)
    ImageView xiangImg;
    @BindView(R.id.xiang_hb)
    TextView xiangHb;
    @BindView(R.id.xiang_jd)
    TextView xiangJd;
    @BindView(R.id.xiang_end_time)
    TextView xiangEndTime;
    @BindView(R.id.et_text)
    EditText etText;
    @BindView(R.id.img_enjoy)
    ImageView imgEnjoy;
    @BindView(R.id.img_send)
    ImageView imgSend;
    @BindView(R.id.linear_et)
    LinearLayout linearEt;
    @BindView(R.id.relative_edit)
    RelativeLayout relativeEdit;
    @BindView(R.id.linear_jd)
    LinearLayout linearJd;
    @BindView(R.id.linear_show)
    LinearLayout linearShow;
    @BindView(R.id.tv_my_jd)
    TextView tvMyJd;
    @BindView(R.id.linear_cancel_jd)
    LinearLayout linearCancelJd;
    @BindView(R.id.line_view)
    View lineView;
    private String sickId;
    private String id;
    private String sessionId;
    private int whetherContent;

    @Override
    public void onLoginSuccess(LoginBean data) {

    }

    @Override
    public void onSendSuccess(SendBean data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        if (data.getMessage().equals("发表成功")) {
            relativeEdit.setVisibility(View.GONE);
            HideIMEUtil.wrap(this);
            mPresenter.getXiangPresenter(id, sessionId, sickId);
        }

    }

    @Override
    public void onXiangSuccess(XinagQBean data) {
        if (data.getResult() != null) {
            whetherContent = data.getResult().getWhetherContent();
            if (whetherContent == 1) {
                linearCancelJd.setVisibility(View.VISIBLE);
                linearJd.setVisibility(View.GONE);
                lineView.setVisibility(View.GONE);
            } else if (whetherContent == 2) {
                linearCancelJd.setVisibility(View.GONE);
                linearJd.setVisibility(View.VISIBLE);
                lineView.setVisibility(View.VISIBLE);
            }
            //标题
            String title = data.getResult().getTitle();
            xiangTitle.setText(title);
            //名字
            String authorName = data.getResult().getAuthorName();
            xiangName.setText(authorName);
            //病症
            String disease = data.getResult().getDisease();
            xiangBing.setText(disease);
            //科室
            String departmentName = data.getResult().getDepartmentName();
            xiangKeshi.setText(departmentName);
            //详情
            String detail = data.getResult().getDetail();
            xiangXq.setText(detail);
            //经历
            String treatmentProcess = data.getResult().getTreatmentProcess();
            xiangJl.setText(treatmentProcess);
            //医院
            String treatmentHospital = data.getResult().getTreatmentHospital();
            xiangYiyuan.setText(treatmentHospital);
            //解答
            String content = data.getResult().getContent();
            tvMyJd.setText(content);
            //开始时间
            long treatmentStartTime = data.getResult().getTreatmentStartTime();
            Date date = new Date(treatmentStartTime);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            xiangTime.setText(simpleDateFormat.format(date));
            //结束时间
            long treatmentEndTime = data.getResult().getTreatmentEndTime();
            Date date1 = new Date(treatmentEndTime);
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MM.dd");
            xiangEndTime.setText(simpleDateFormat1.format(date1));

            //相关图片
            String picture = data.getResult().getPicture();
            Glide.with(App.getAppContext()).load(picture).into(xiangImg);
            //悬赏奖励数
            int amount = data.getResult().getAmount();
            xiangHb.setText(amount + "H币");
        } else {
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        }
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
        return R.layout.activity_xiang_qing;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        sickId = intent.getStringExtra("sickId");
        SharedPreferences doctor = getSharedPreferences("doctor", MODE_PRIVATE);
        id = doctor.getString("id", "");
        sessionId = doctor.getString("sessionId", "");
        mPresenter.getXiangPresenter(id, sessionId, sickId);
    }

    @OnClick({R.id.xiang_back, R.id.xiang_hb, R.id.xiang_jd, R.id.img_enjoy, R.id.img_send, R.id.linear_show})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xiang_back:
                finish();
                break;
            case R.id.xiang_hb:
                break;
            case R.id.xiang_jd:
                linearJd.setVisibility(View.GONE);
                relativeEdit.setVisibility(View.VISIBLE);
                break;
            case R.id.img_enjoy:
                break;
            case R.id.img_send:
                String ed_tive = etText.getText().toString().trim();
                mPresenter.postSendPresenter(id, sessionId, sickId, ed_tive);
                break;
            case R.id.linear_show:
                if (whetherContent == 1) {
                    linearCancelJd.setVisibility(View.VISIBLE);
                    linearJd.setVisibility(View.GONE);
                    lineView.setVisibility(View.GONE);
                } else if (whetherContent == 2) {
                    linearCancelJd.setVisibility(View.GONE);
                    linearJd.setVisibility(View.VISIBLE);
                    lineView.setVisibility(View.VISIBLE);
                }
                relativeEdit.setVisibility(View.GONE);
                HideIMEUtil.wrap(this);
                //取消editText焦点
                //linearShow.setFocusableInTouchMode(true);
                break;
        }
    }



}