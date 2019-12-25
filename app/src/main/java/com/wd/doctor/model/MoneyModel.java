package com.wd.doctor.model;

import android.widget.Toast;

import com.wd.doctor.app.ApiServer;
import com.wd.doctor.bean.Show.MoneyBean;
import com.wd.doctor.contract.MoneyContract;
import com.wd.mvp.app.App;
import com.wd.mvp.utils.CommonSchedulers;
import com.wd.mvp.utils.NetUtil;
import com.wd.mvp.utils.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 作者:dongyanjun
 * 时间：2019/12/20
 * 描述:Doctor
 * 功能：
 **/
public class MoneyModel implements MoneyContract.Imodel {
    @Override
    public void getMoneyModel(String doctorId, String sessionId, IModelMoneyCallBack iModelMoneyCallBack) {
        if (NetUtil.hasNet(App.getAppContext())) {
            RetrofitManager.getInstance().create(ApiServer.class)
                    .getMoney(doctorId, sessionId)
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new Observer<MoneyBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(MoneyBean moneyBean) {
                            iModelMoneyCallBack.onSuccess(moneyBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iModelMoneyCallBack.onError(e.getMessage());
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
