package com.wd.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.wd.mvp.utils.NetUtil;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 *@describe(描述)：BaseActivity
 *@data（日期）: 2019/11/11
 *@time（时间）: 16:06
 *@author（作者）: xin
 **/
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    private Unbinder bind;
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutId());
        bind = ButterKnife.bind(this);
        mPresenter = providePresenter();
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
        initData();
        initView();
    }

    protected  abstract P providePresenter();

    protected abstract int provideLayoutId();
    protected void initView(){

    }

    protected void initData(){

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }

    //判断是否有网络
    public boolean hasNet(){
        return NetUtil.hasNet(this);
    }
    //无网提醒
    public void showNoNetTip(){
        Toast.makeText(this, "当前网络无连接", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return this;
    }
}
