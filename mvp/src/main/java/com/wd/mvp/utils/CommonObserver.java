package com.wd.mvp.utils;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 *@describe(描述)：CommonObserver
 *@data（日期）: 2019/11/11
 *@time（时间）: 16:07
 *@author（作者）: xin
 **/
public abstract class CommonObserver <T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }
}
