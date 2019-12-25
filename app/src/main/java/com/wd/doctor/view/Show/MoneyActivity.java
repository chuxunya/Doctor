package com.wd.doctor.view.Show;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.bean.Show.MoneyBean;
import com.wd.doctor.contract.MoneyContract;
import com.wd.doctor.presenter.MoneyPresenter;
import com.wd.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoneyActivity extends BaseActivity<MoneyPresenter> implements MoneyContract.Iview {


    @BindView(R.id.money_back)
    ImageView moneyBack;
    @BindView(R.id.tv_card_bang)
    TextView tvCardBang;
    @BindView(R.id.tv_card_look)
    TextView tvCardLook;
    @BindView(R.id.money_num)
    TextView moneyNum;
    @BindView(R.id.bt_ti_money)
    Button btTiMoney;
    @BindView(R.id.card_bg)
    RelativeLayout cardBg;
    @BindView(R.id.recycler_money)
    RecyclerView recyclerMoney;

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences doctor = getSharedPreferences("doctor", MODE_PRIVATE);
        String id = doctor.getString("id", "");
        String sessionId = doctor.getString("sessionId", "");
        mPresenter.getMoneyPresenter(id,sessionId);
    }

    @Override
    public void onMoneySuccess(MoneyBean data) {
        if (data.getResult()!=null) {
            int balance = data.getResult().getBalance();
            moneyNum.setText(balance+"");
        }
    }

    @Override
    public void onMoneyError(String e) {

    }

    @Override
    protected MoneyPresenter providePresenter() {
        return new MoneyPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_money;
    }



    @OnClick({R.id.money_back, R.id.tv_card_bang, R.id.tv_card_look, R.id.bt_ti_money})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.money_back:
                finish();
                break;
            case R.id.tv_card_bang:
                Intent intent = new Intent(MoneyActivity.this, BangCardActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_card_look:
                break;
            case R.id.bt_ti_money:
                break;
        }
    }
}
