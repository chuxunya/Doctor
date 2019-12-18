package com.wd.doctor.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wd.doctor.R;
import com.wd.doctor.adapter.MyKeShiAdapter;
import com.wd.doctor.adapter.Show.MyBodyAdapter;
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
import com.wd.doctor.presenter.HomePresenter;
import com.wd.doctor.view.Sick.XiangQingActivity;
import com.wd.mvp.base.BaseFragment;
import com.wd.mvp.base.BasePresenter;

import java.util.List;

import butterknife.BindView;

/**
 * 作者:dongyanjun
 * 时间：2019/12/14
 * 描述:Doctor
 * 功能：
 **/
public class SickFrag extends BaseFragment<HomePresenter> implements HomeContract.Iview {
    @BindView(R.id.sick_recycler)
    RecyclerView sickRecycler;
    @BindView(R.id.sick_smart)
    SmartRefreshLayout sickSmart;
    private HomePresenter homePresenter;
    private int count=1;
    private String departmentId;

    @Override
    protected void initView() {
        super.initView();

        sickSmart.setEnableRefresh(true);
        sickSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore();
                count++;
                homePresenter.getBodyPresenter(departmentId,count+"","5");
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(1000);
               homePresenter.getBodyPresenter(departmentId,"1","5");
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        Bundle arguments = getArguments();
        departmentId = arguments.getString("departmentId");

        homePresenter.getBodyPresenter(departmentId,"1","5");
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
        if (data.getResult()!=null) {
            List<BodyBean.ResultBean> result = data.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            sickRecycler.setLayoutManager(linearLayoutManager);
            MyBodyAdapter myBodyAdapter = new MyBodyAdapter(getActivity(), result);
            sickRecycler.setAdapter(myBodyAdapter);
            myBodyAdapter.setOnItemClickListener(new MyBodyAdapter.OnItemClickListener() {
                @Override
                public void onItem(String id) {
                    Intent intent = new Intent(getActivity(), XiangQingActivity.class);
                    startActivity(intent);
                }
            });
        }else {
            Toast.makeText(getActivity(), data.getMessage(), Toast.LENGTH_SHORT).show();
        }
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
        homePresenter = new HomePresenter();
        return homePresenter;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.sick_frag;

    }

}
