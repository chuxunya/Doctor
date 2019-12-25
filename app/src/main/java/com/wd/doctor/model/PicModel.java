package com.wd.doctor.model;

import android.widget.Toast;

import com.wd.doctor.app.ApiServer;
import com.wd.doctor.bean.Show.LoadPicBean;
import com.wd.doctor.bean.Show.PictureBean;
import com.wd.doctor.contract.PictureContract;
import com.wd.mvp.app.App;
import com.wd.mvp.utils.CommonSchedulers;
import com.wd.mvp.utils.NetUtil;
import com.wd.mvp.utils.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.MultipartBody;

/**
 * 作者:dongyanjun
 * 时间：2019/12/20
 * 描述:Doctor
 * 功能：
 **/
public class PicModel implements PictureContract.Imodel {
    @Override
    public void getPicModel(IModelPicCallBack iModelPicCallBack) {
        if (NetUtil.hasNet(App.getAppContext())) {
            RetrofitManager.getInstance().create(ApiServer.class)
                    .getPicture()
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new Observer<PictureBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(PictureBean pictureBean) {
                            iModelPicCallBack.onSuccess(pictureBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iModelPicCallBack.onError(e.getMessage());
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
    public void postLoadPicModel(String doctorId, String sessionId, MultipartBody.Part map, IModelLoadPicCallBack iModelLoadPicCallBack) {
        if (NetUtil.hasNet(App.getAppContext())) {
            RetrofitManager.getInstance().create(ApiServer.class)
                    .postLoadPic(doctorId, sessionId, map)
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new Observer<LoadPicBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(LoadPicBean loadPicBean) {
                            iModelLoadPicCallBack.onSuccess(loadPicBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iModelLoadPicCallBack.onError(e.getMessage());
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
    public void postChoosePicModel(String doctorId, String sessionId, String imagePic, IModelChooseCallBack iModelLoadPicCallBack) {
        if (NetUtil.hasNet(App.getAppContext())) {
            RetrofitManager.getInstance().create(ApiServer.class)
                    .postChoosePic(doctorId, sessionId, imagePic)
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new Observer<LoadPicBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(LoadPicBean loadPicBean) {
                            iModelLoadPicCallBack.onSuccess(loadPicBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iModelLoadPicCallBack.onError(e.getMessage());
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
