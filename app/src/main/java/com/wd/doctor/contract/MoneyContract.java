package com.wd.doctor.contract;

import com.wd.doctor.bean.Show.MoneyBean;
import com.wd.mvp.base.IBaseView;

/**
 * 作者:dongyanjun
 * 时间：2019/12/20
 * 描述:Doctor
 * 功能：
 **/
public interface MoneyContract {
    interface Iview extends IBaseView{
        void onMoneySuccess(MoneyBean data);
        void onMoneyError(String e);
    }
    interface Imodel{
        void getMoneyModel(String doctorId,String sessionId,IModelMoneyCallBack iModelMoneyCallBack);

        interface IModelMoneyCallBack {
            void onSuccess(MoneyBean data);
            void onError(String e);
        }
    }
    interface Ipresenter{
        void getMoneyPresenter(String doctorId,String sessionId);
    }
}
