package com.wd.doctor.view.Sick;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wd.doctor.R;
import com.wd.doctor.adapter.MyKeShiAdapter;
import com.wd.doctor.adapter.Show.MyBodyAdapter;
import com.wd.doctor.adapter.Show.MySickAdapter;
import com.wd.doctor.bean.ForgetBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.Show.BodyBean;
import com.wd.doctor.bean.Show.SearchBean;
import com.wd.doctor.bean.login.CodeBean;
import com.wd.doctor.bean.login.KeShiBean;
import com.wd.doctor.bean.login.SettledInBean;
import com.wd.doctor.bean.login.ZhiZeBean;
import com.wd.doctor.bean.message.MessageBean;
import com.wd.doctor.contract.HomeContract;
import com.wd.doctor.fragment.SickFrag;
import com.wd.doctor.presenter.HomePresenter;
import com.wd.doctor.view.Show.ShowActivity;
import com.wd.mvp.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SickActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {


    @BindView(R.id.sick_back)
    ImageView sickBack;
    @BindView(R.id.sick_ling)
    ImageView sickLing;
    @BindView(R.id.sick_search)
    ImageView sickSearch;
    @BindView(R.id.sick_tab)
    TabLayout sickTab;
    @BindView(R.id.sick_vp)
    ViewPager sickVp;
    private ArrayList<String> tab=new ArrayList<>();
    @Override
    protected void initData() {
        super.initData();
        mPresenter.getKeShiPresenter();


    }

    @Override
    public void onLoginSuccess(LoginBean data) {

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
            for (int i = 0; i < result.size(); i++) {
              //  KeShiBean.ResultBean resultBean = result.get(i);
                tab.add(result.get(i).getDepartmentName());

            }

            sickTab.setupWithViewPager(sickVp);
            MySickAdapter mySickAdapter = new MySickAdapter(getSupportFragmentManager(),tab,result);
            sickVp.setAdapter(mySickAdapter);

        }else {
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        }

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
        return R.layout.activity_sick;
    }


    @OnClick({R.id.sick_back, R.id.sick_ling, R.id.sick_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sick_back:
                finish();
                break;
            case R.id.sick_ling:
                break;
            case R.id.sick_search:
                Intent intent1 = new Intent(SickActivity.this, SearchActivity.class);
                startActivity(intent1);
                break;
        }
    }



}
