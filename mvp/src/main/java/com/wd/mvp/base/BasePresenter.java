package com.wd.mvp.base;

import android.content.Context;


import com.wd.mvp.app.App;

import java.lang.ref.WeakReference;
/**
 *@describe(描述)：BasePresenter
 *@data（日期）: 2019/11/11
 *@time（时间）: 16:06
 *@author（作者）: xin
 **/
public abstract class BasePresenter <V extends IBaseView> {

    private WeakReference<V> vWeakReference;

    public BasePresenter(){
        initModel();
    }

    protected abstract void initModel();

    protected void attachView(V v){
        vWeakReference = new WeakReference<>(v);
    }
    protected void detachView(){
        if (vWeakReference!=null){
            vWeakReference.clear();
            vWeakReference=null;
        }
    }
    //判断view是否挂载
    protected boolean isViewAttached(){
        if (vWeakReference==null  || vWeakReference.get() ==null){
            return false;
        }
        return true;
    }
    //获取view 接口
    protected V getView(){
        return vWeakReference.get();
    }


    protected Context context(){
        if (isViewAttached() && getView().context()!=null){
            return getView().context();
        }
        return App.getAppContext();
    }
}
