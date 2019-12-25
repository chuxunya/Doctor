package com.wd.doctor.contract;

import com.wd.doctor.bean.Show.LoadPicBean;
import com.wd.doctor.bean.Show.MoneyBean;
import com.wd.doctor.bean.Show.PictureBean;
import com.wd.mvp.base.IBaseView;

import okhttp3.MultipartBody;

/**
 * 作者:dongyanjun
 * 时间：2019/12/20
 * 描述:Doctor
 * 功能：
 **/
public interface PictureContract {
    interface Iview extends IBaseView{
        void onPictureSuccess(PictureBean data);
        void onLoadPicSuccess(LoadPicBean data);
        void onChooseSuccess(LoadPicBean data);
        void onError(String e);
    }
    interface Imodel{
        void getPicModel(IModelPicCallBack iModelPicCallBack);
        void postLoadPicModel(String doctorId, String sessionId, MultipartBody.Part map,IModelLoadPicCallBack iModelLoadPicCallBack);
        void postChoosePicModel(String doctorId, String sessionId, String imagePic,IModelChooseCallBack iModelLoadPicCallBack);

        interface IModelPicCallBack {
            void onSuccess(PictureBean data);
            void onError(String e);
        }

        interface IModelLoadPicCallBack {
            void onSuccess(LoadPicBean data);
            void onError(String e);
        }

        interface IModelChooseCallBack {
            void onSuccess(LoadPicBean data);
            void onError(String e);
        }
    }
    interface Ipresenter{
        void getPicPresenter();
        void postLoadPicPresenter(String doctorId, String sessionId, MultipartBody.Part map);
        void postChoosePresenter(String doctorId, String sessionId, String imagePic);
    }
}
