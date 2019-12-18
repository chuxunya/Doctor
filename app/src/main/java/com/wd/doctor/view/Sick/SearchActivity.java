package com.wd.doctor.view.Sick;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wd.doctor.R;
import com.wd.doctor.adapter.Show.MySearchAdapter;
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

public class SearchActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {


    @BindView(R.id.back_search)
    ImageView backSearch;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.recycler_search)
    RecyclerView recyclerSearch;
    @BindView(R.id.smart_search)
    SmartRefreshLayout smartSearch;
    @BindView(R.id.linear_wu)
    LinearLayout linearWu;
    private String search;

    @Override
    protected void initData() {
        super.initData();

    }

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
        if (!data.getResult().isEmpty()) {

            List<SearchBean.ResultBean> result = data.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerSearch.setLayoutManager(linearLayoutManager);
            MySearchAdapter mySearchAdapter = new MySearchAdapter(this, result);
            recyclerSearch.setAdapter(mySearchAdapter);
            linearWu.setVisibility(View.GONE);
        } else if (data.getResult().isEmpty()) {

            linearWu.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "请检查网络", Toast.LENGTH_SHORT).show();
        }
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
        return R.layout.activity_search;
    }


    @OnClick({R.id.back_search, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_search:
                finish();
                break;
            case R.id.tv_search:

                search = etSearch.getText().toString().trim();
                if (!search.isEmpty()) {
                    mPresenter.getSearchModel(search);
                }else {
                    Toast.makeText(this, "输入框为空", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }


}
