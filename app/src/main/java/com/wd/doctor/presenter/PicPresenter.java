package com.wd.doctor.presenter;

import com.wd.doctor.bean.Show.LoadPicBean;
import com.wd.doctor.bean.Show.PictureBean;
import com.wd.doctor.contract.PictureContract;
import com.wd.doctor.model.PicModel;
import com.wd.mvp.base.BasePresenter;

import okhttp3.MultipartBody;

/**
 * 作者:dongyanjun
 * 时间：2019/12/20
 * 描述:Doctor
 * 功能：
 **/
public class PicPresenter extends BasePresenter<PictureContract.Iview> implements PictureContract.Ipresenter {

    private PicModel picModel;

    @Override
    public void getPicPresenter() {
        picModel.getPicModel(new PictureContract.Imodel.IModelPicCallBack() {
            @Override
            public void onSuccess(PictureBean data) {
                getView().onPictureSuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onError(e);
            }
        });
    }

    @Override
    public void postLoadPicPresenter(String doctorId, String sessionId, MultipartBody.Part map) {
        picModel.postLoadPicModel(doctorId, sessionId, map, new PictureContract.Imodel.IModelLoadPicCallBack() {
            @Override
            public void onSuccess(LoadPicBean data) {
                getView().onLoadPicSuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onError(e);
            }
        });
    }

    @Override
    public void postChoosePresenter(String doctorId, String sessionId, String imagePic) {
        picModel.postChoosePicModel(doctorId, sessionId, imagePic, new PictureContract.Imodel.IModelChooseCallBack() {
            @Override
            public void onSuccess(LoadPicBean data) {
                getView().onChooseSuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onError(e);
            }
        });
    }

    @Override
    protected void initModel() {
        picModel = new PicModel();
    }
}
