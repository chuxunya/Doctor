package com.wd.doctor.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.adapter.MyKeShiAdapter;
import com.wd.doctor.adapter.MyZhiZeAdapter;
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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettledTwoActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {

    @BindView(R.id.settled_name)
    EditText settledName;
    @BindView(R.id.et_yiyuan)
    EditText etYiyuan;
    @BindView(R.id.et_keshi)
    TextView etKeshi;
    @BindView(R.id.img_keshi)
    ImageView imgKeshi;
    @BindView(R.id.et_zhize)
    TextView etZhize;
    @BindView(R.id.img_zhize)
    ImageView imgZhize;
    @BindView(R.id.bt_two_next)
    Button btTwoNext;
    @BindView(R.id.recycler_keshi)
    RecyclerView recyclerKeshi;
    @BindView(R.id.recycler_zhize)
    RecyclerView recyclerZhize;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;
    @BindView(R.id.relative_layout)
    RelativeLayout relativeLayout;
    private int count=1;
    private int count1=1;
    private String email;
    private String code;
    private String pwd1;
    private String pwd2;

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
        if (data.getResult()!=null) {
            List<KeShiBean.ResultBean> result = data.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerKeshi.setLayoutManager(linearLayoutManager);
            MyKeShiAdapter myKeShiAdapter = new MyKeShiAdapter(this, result);
            recyclerKeshi.setAdapter(myKeShiAdapter);
            myKeShiAdapter.setOnItemClickListener(new MyKeShiAdapter.OnItemClickListener() {
                @Override
                public void onItem(String name) {

                    etKeshi.setText(name);
                    recyclerKeshi.setVisibility(View.GONE);
                }
            });
        }else {
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onZhiZeSuccess(ZhiZeBean data) {
        if (data.getResult()!=null) {
            List<ZhiZeBean.ResultBean> result = data.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerZhize.setLayoutManager(linearLayoutManager);
            MyZhiZeAdapter myZhiZeAdapter = new MyZhiZeAdapter(this,result);
            recyclerZhize.setAdapter(myZhiZeAdapter);
            myZhiZeAdapter.setOnItemClickListener(new MyZhiZeAdapter.OnItemClickListener() {
                @Override
                public void onItem(String name) {
                    etZhize.setText(name);
                    recyclerZhize.setVisibility(View.GONE);
                }
            });
        }else {
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        }
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
        return R.layout.activity_settled_two;
    }

    @Override
    protected void initData() {
        super.initData();

        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        code = intent.getStringExtra("code");
        pwd1 = intent.getStringExtra("pwd1");
        pwd2 = intent.getStringExtra("pwd2");

    }

    @OnClick({R.id.img_keshi, R.id.img_zhize, R.id.bt_two_next, R.id.recycler_keshi, R.id.recycler_zhize, R.id.scroll_view,R.id.relative_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_keshi:
                count++;
                if (count%2==0) {
                    recyclerKeshi.setVisibility(View.VISIBLE);
                    mPresenter.getKeShiPresenter();
                }else {
                    recyclerKeshi.setVisibility(View.GONE);
                }

                break;
            case R.id.img_zhize:
                count1++;
                if (count1%2==0) {
                    mPresenter.getZhiZePresenter();
                    recyclerZhize.setVisibility(View.VISIBLE);
                }else {
                    recyclerZhize.setVisibility(View.GONE);
                }

                break;
            case R.id.bt_two_next:
                Intent intent = new Intent(SettledTwoActivity.this,SettledThreeActivity.class);
                String name = settledName.getText().toString().trim();
                String yiyuan = etYiyuan.getText().toString().trim();
                String keshi = etKeshi.getText().toString().trim();
                String zhize = etZhize.getText().toString().trim();
                intent.putExtra("email",email);
                intent.putExtra("code",code);
                intent.putExtra("pwd1",pwd1);
                intent.putExtra("pwd2",pwd2);
                intent.putExtra("name",name);
                intent.putExtra("yiyuan",yiyuan);
                intent.putExtra("keshi",keshi);
                intent.putExtra("zhize",zhize);
                startActivity(intent);

                break;
            case R.id.recycler_keshi:
                break;
            case R.id.recycler_zhize:
                break;
            case R.id.scroll_view:
                recyclerKeshi.setVisibility(View.GONE);
                recyclerZhize.setVisibility(View.GONE);
                break;
            case R.id.relative_layout:
                recyclerKeshi.setVisibility(View.GONE);
                recyclerZhize.setVisibility(View.GONE);
                break;
        }
    }



}
