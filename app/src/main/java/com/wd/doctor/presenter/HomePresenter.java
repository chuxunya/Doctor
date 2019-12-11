package com.wd.doctor.presenter;

import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.login.CodeBean;
import com.wd.doctor.bean.login.KeShiBean;
import com.wd.doctor.bean.login.SettledInBean;
import com.wd.doctor.bean.login.ZhiZeBean;
import com.wd.doctor.contract.HomeContract;
import com.wd.doctor.model.HomeModel;
import com.wd.mvp.base.BasePresenter;

/**
 * 作者:dongyanjun
 * 时间：2019/12/11
 * 描述:Doctor
 * 功能：
 **/
public class HomePresenter extends BasePresenter<HomeContract.Iview> implements HomeContract.Ipresenter {


    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void postLoginPresenter(String email, String pwd) {
        homeModel.postLoginModel(email, pwd, new HomeContract.Imodel.IModelCallBack() {
            @Override
            public void onSuccess(LoginBean data) {
                getView().onLoginSuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getKeShiPresenter() {
        homeModel.getKeShiModel(new HomeContract.Imodel.IModelKeShiCallBack() {
            @Override
            public void onSuccess(KeShiBean data) {
                getView().onKeShiSuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getZhiZePresenter() {
        homeModel.getZhiZeModel(new HomeContract.Imodel.IModelZhiZeCallBack() {
            @Override
            public void onSuccess(ZhiZeBean data) {
                getView().onZhiZeSuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void postSendCodePresenter(String email) {
        homeModel.postSendCodeModel(email, new HomeContract.Imodel.IModelSendCodeCallBack() {
            @Override
            public void onSuccess(CodeBean data) {
                getView().onSendCodeSuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void postSettledIn(String email, String code, String pwd1, String pwd2, String name, String inauguralHospital, String departmentName, String jobTitle, String personalProfile, String goodField) {
        homeModel.postSettledInModel(email, code, pwd1, pwd2, name, inauguralHospital, departmentName, jobTitle, personalProfile, goodField, new HomeContract.Imodel.IModelSettledInCallBack() {
            @Override
            public void onSuccess(SettledInBean data) {
                getView().onSettledIn(data);
            }

            @Override
            public void onError(String e) {
                getView().onHomeError(e);
            }
        });
    }
}
