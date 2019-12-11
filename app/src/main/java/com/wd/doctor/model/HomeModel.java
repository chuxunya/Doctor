package com.wd.doctor.model;

import android.widget.Toast;

import com.wd.doctor.app.ApiServer;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.login.CodeBean;
import com.wd.doctor.bean.login.KeShiBean;
import com.wd.doctor.bean.login.SettledInBean;
import com.wd.doctor.bean.login.ZhiZeBean;
import com.wd.doctor.contract.HomeContract;
import com.wd.mvp.app.Api;
import com.wd.mvp.app.App;
import com.wd.mvp.utils.CommonSchedulers;
import com.wd.mvp.utils.NetUtil;
import com.wd.mvp.utils.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 作者:dongyanjun
 * 时间：2019/12/11
 * 描述:Doctor
 * 功能：
 **/
public class HomeModel implements HomeContract.Imodel {
    //登录
    @Override
    public void postLoginModel(String email, String pwd, IModelCallBack iModelCallBack) {

        if (NetUtil.hasNet(App.getAppContext())) {
            RetrofitManager.getInstance().create(ApiServer.class)
                    .postLogin(email, pwd)
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new Observer<LoginBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(LoginBean loginBean) {
                            iModelCallBack.onSuccess(loginBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iModelCallBack.onError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });

        }else {
            Toast.makeText(App.getAppContext(), "网络开小差了,请检查网络", Toast.LENGTH_SHORT).show();
        }


        }

    @Override
    public void getKeShiModel(IModelKeShiCallBack iModelCallBack) {
        if (NetUtil.hasNet(App.getAppContext())) {
            RetrofitManager.getInstance().create(ApiServer.class)
                    .getKeShi()
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new Observer<KeShiBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(KeShiBean keShiBean) {
                            iModelCallBack.onSuccess(keShiBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iModelCallBack.onError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }else {
            Toast.makeText(App.getAppContext(), "网络开小差了,请检查网络", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getZhiZeModel(IModelZhiZeCallBack iModelCallBack) {
        if (NetUtil.hasNet(App.getAppContext())) {
            RetrofitManager.getInstance().create(ApiServer.class)
                    .getZhiZe()
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new Observer<ZhiZeBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(ZhiZeBean zhiZeBean) {
                            iModelCallBack.onSuccess(zhiZeBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iModelCallBack.onError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }else {
            Toast.makeText(App.getAppContext(), "网络开小差了,请检查网络", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void postSendCodeModel(String email, IModelSendCodeCallBack iModelCallBack) {
        if (NetUtil.hasNet(App.getAppContext())) {
            RetrofitManager.getInstance().create(ApiServer.class)
                    .postSendCode(email)
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new Observer<CodeBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(CodeBean codeBean) {
                            iModelCallBack.onSuccess(codeBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iModelCallBack.onError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }else {
            Toast.makeText(App.getAppContext(), "网络开小差了,请检查网络", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void postSettledInModel(String email, String code, String pwd1, String pwd2, String name, String inauguralHospital, String departmentName, String jobTitle, String personalProfile, String goodField, IModelSettledInCallBack iModelCallBack) {
        if (NetUtil.hasNet(App.getAppContext())) {
            RetrofitManager.getInstance().create(ApiServer.class)
                    .postSettledIn(email, code, pwd1, pwd2, name, inauguralHospital, departmentName, jobTitle, personalProfile, goodField)
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new Observer<SettledInBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(SettledInBean settledInBean) {
                            iModelCallBack.onSuccess(settledInBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iModelCallBack.onError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }else {
            Toast.makeText(App.getAppContext(), "网络开小差了,请检查网络", Toast.LENGTH_SHORT).show();
        }
    }


}
