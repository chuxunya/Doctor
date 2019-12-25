package com.wd.doctor.presenter;

import com.wd.doctor.bean.Show.MoneyBean;
import com.wd.doctor.contract.MoneyContract;
import com.wd.doctor.model.MoneyModel;
import com.wd.mvp.base.BasePresenter;

/**
 * 作者:dongyanjun
 * 时间：2019/12/20
 * 描述:Doctor
 * 功能：
 **/
public class MoneyPresenter extends BasePresenter<MoneyContract.Iview> implements MoneyContract.Ipresenter {

    private MoneyModel moneyModel;

    @Override
    public void getMoneyPresenter(String doctorId, String sessionId) {
        moneyModel.getMoneyModel(doctorId, sessionId, new MoneyContract.Imodel.IModelMoneyCallBack() {
            @Override
            public void onSuccess(MoneyBean data) {
                getView().onMoneySuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onMoneyError(e);
            }
        });
    }

    @Override
    protected void initModel() {
        moneyModel = new MoneyModel();
    }
}
