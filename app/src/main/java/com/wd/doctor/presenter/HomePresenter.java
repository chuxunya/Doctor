package com.wd.doctor.presenter;

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
    public void getSearchModel(String keyWord) {
        homeModel.getSearchModel(keyWord, new HomeContract.Imodel.IModelKeyWordCallBack() {
            @Override
            public void onSuccess(SearchBean data) {
                getView().onSearchSuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onHomeError(e);
            }
        });
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
    public void putAllMessagePresenter(String doctorId, String sessionId) {
        homeModel.putAllMessageModel(doctorId, sessionId, new HomeContract.Imodel.IModelAllMessageCallBack() {
            @Override
            public void onSuccess(MessageBean data) {
                getView().onAllMeaageSuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void postForgetPresenter(String email, String pwd1, String pwd2) {
        homeModel.putForgetModel(email, pwd1, pwd2, new HomeContract.Imodel.IModelForgetCallBack() {
            @Override
            public void onSuccess(ForgetBean data) {
                getView().onForgetSuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void getBodyPresenter(String departmentId, String page, String count) {
        homeModel.getBodyModel(departmentId, page, count, new HomeContract.Imodel.IModelBodyCallBack() {
            @Override
            public void onSuccess(BodyBean data) {
                getView().onBodySuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void postCheckCodePresenter(String email, String code) {
        homeModel.postCheckCodeModel(email, code, new HomeContract.Imodel.IModelCheckCodeCallBack() {
            @Override
            public void onSuccess(ForgetBean data) {
                getView().onChecKCodeSuccess(data);
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
