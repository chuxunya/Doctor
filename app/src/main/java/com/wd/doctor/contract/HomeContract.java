package com.wd.doctor.contract;

import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.login.CodeBean;
import com.wd.doctor.bean.login.KeShiBean;
import com.wd.doctor.bean.login.SettledInBean;
import com.wd.doctor.bean.login.ZhiZeBean;
import com.wd.mvp.base.IBaseView;

/**
 * 作者:dongyanjun
 * 时间：2019/12/11
 * 描述:Doctor
 * 功能：
 **/
public interface HomeContract {
    interface Iview extends IBaseView {
        void onLoginSuccess(LoginBean data);
        void onSendCodeSuccess(CodeBean data);
        void onKeShiSuccess(KeShiBean data);
        void onZhiZeSuccess(ZhiZeBean data);
        void onSettledIn(SettledInBean data);
        void onHomeError(String e);
    }
    interface Imodel{
        void postLoginModel(String email,String pwd,IModelCallBack iModelCallBack);
        void getKeShiModel(IModelKeShiCallBack iModelCallBack);
        void getZhiZeModel(IModelZhiZeCallBack iModelCallBack);
        void postSendCodeModel(String email,IModelSendCodeCallBack iModelCallBack);
        void postSettledInModel(String email,String code,String pwd1,String pwd2,String name,String inauguralHospital,String departmentName,String jobTitle,String personalProfile,String goodField,IModelSettledInCallBack iModelCallBack);
        interface IModelCallBack {
            void onSuccess(LoginBean data);
            void onError(String e);

        }

        interface IModelSendCodeCallBack {
            void onSuccess(CodeBean data);
            void onError(String e);
        }

        interface IModelSettledInCallBack {
            void onSuccess(SettledInBean data);
            void onError(String e);
        }

        interface IModelKeShiCallBack {
            void onSuccess(KeShiBean data);
            void onError(String e);
        }

        interface IModelZhiZeCallBack {
            void onSuccess(ZhiZeBean data);
            void onError(String e);
        }
    }
    interface Ipresenter{
        void postLoginPresenter(String email,String pwd);
        void getKeShiPresenter();
        void getZhiZePresenter();
        void postSendCodePresenter(String email);
        void postSettledIn(String email,String code,String pwd1,String pwd2,String name,String inauguralHospital,String departmentName,String jobTitle,String personalProfile,String goodField);
    }
}
