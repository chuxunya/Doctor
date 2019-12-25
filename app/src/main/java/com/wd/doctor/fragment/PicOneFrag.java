package com.wd.doctor.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.adapter.Show.MyPicAdapter;
import com.wd.doctor.bean.Show.LoadPicBean;
import com.wd.doctor.bean.Show.PictureBean;
import com.wd.doctor.contract.PictureContract;
import com.wd.doctor.presenter.PicPresenter;
import com.wd.doctor.view.Show.MySelfActivity;
import com.wd.mvp.base.BaseFragment;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 作者:dongyanjun
 * 时间：2019/12/21
 * 描述:Doctor
 * 功能：
 **/
public class PicOneFrag extends BaseFragment<PicPresenter> implements PictureContract.Iview {

    @BindView(R.id.recyfdf)
    RecyclerView recyfdf;
    @BindView(R.id.butedk)
    Button butedk;
    private PicPresenter picPresenter;
    private String sessionId;
    private String id;
    private String imagePic;
    private static final String TAG = "OneFragPic";

    private MultipartBody.Part image1;
    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences doctor = getActivity().getSharedPreferences("doctor", Context.MODE_PRIVATE);
        id = doctor.getString("id", "");
        sessionId = doctor.getString("sessionId", "");

        picPresenter.getPicPresenter();
    }

    @Override
    public void onPictureSuccess(PictureBean data) {
      //  Toast.makeText(getActivity(), data.getMessage(), Toast.LENGTH_SHORT).show();
        if (data.getResult() != null) {
            List<PictureBean.ResultBean> result = data.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            recyfdf.setLayoutManager(linearLayoutManager);
            MyPicAdapter myPicAdapter = new MyPicAdapter(getActivity(), result);
            recyfdf.setAdapter(myPicAdapter);
            PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
            pagerSnapHelper.attachToRecyclerView(recyfdf);
            myPicAdapter.setOnClickListener(new MyPicAdapter.OnItemClickListener() {



                @Override
                public void onItemClick(int position) {
                    imagePic = data.getResult().get(position).getImagePic();
                    Log.d(TAG, "onItemClick: "+imagePic);
                }
            });

        } else {
            Toast.makeText(getContext(), data.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoadPicSuccess(LoadPicBean data) {

        //Toast.makeText(getActivity(), data.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onChooseSuccess(LoadPicBean data) {
        Toast.makeText(getActivity(), data.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String e) {

    }

    @Override
    protected PicPresenter providePresenter() {
        picPresenter = new PicPresenter();
        return picPresenter;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.picturefragmentone;
    }

    @OnClick(R.id.butedk)
    public void onViewClicked() {
        if (imagePic != null) {
            //转换为file类型
           picPresenter.postChoosePresenter(id,sessionId,imagePic);

            Intent intent = getActivity().getIntent();

            intent.putExtra("image",imagePic);
            getActivity().setResult(100,intent);
            getActivity().finish();

        }else {
            Toast.makeText(getActivity(), "您没有选择图片", Toast.LENGTH_SHORT).show();
        }

    }
}
