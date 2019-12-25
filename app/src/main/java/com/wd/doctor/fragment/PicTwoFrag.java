package com.wd.doctor.fragment;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.wd.doctor.ImageUtil;
import com.wd.doctor.R;
import com.wd.doctor.SPUtils;
import com.wd.doctor.bean.Show.LoadPicBean;
import com.wd.doctor.bean.Show.PictureBean;
import com.wd.doctor.contract.PictureContract;
import com.wd.doctor.presenter.PicPresenter;
import com.wd.mvp.app.App;
import com.wd.mvp.base.BaseFragment;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

/**
 * 作者:dongyanjun
 * 时间：2019/12/21
 * 描述:Doctor
 * 功能：
 **/
public class PicTwoFrag extends BaseFragment<PicPresenter> implements PictureContract.Iview {
    private static final String TAG = "PicTwoFrag";
    @BindView(R.id.shangchuan)
    ImageView shangchuan;
    @BindView(R.id.self_pai)
    Button selfPai;
    @BindView(R.id.self_ce)
    Button selfCe;
    @BindView(R.id.self_qu)
    Button selfQu;
    @BindView(R.id.relative_alpha_self)
    RelativeLayout relativeAlphaSelf;
    @BindView(R.id.butedk_two)
    Button butedkTwo;
    @BindView(R.id.self_img)
    ImageView selfImg;
    @BindView(R.id.linear_xuan)
    LinearLayout linearXuan;
    private PicPresenter picPresenter;
    private MultipartBody.Part imagePic;

    @Override
    public void onPictureSuccess(PictureBean data) {

    }

    @Override
    public void onLoadPicSuccess(LoadPicBean data) {

    }

    @Override
    public void onChooseSuccess(LoadPicBean data) {

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
        return R.layout.picturefragmenttwo;
    }

    @OnClick({R.id.shangchuan, R.id.self_pai, R.id.self_ce, R.id.self_qu, R.id.relative_alpha_self, R.id.butedk_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shangchuan:
              /*  Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 20);
                getActivity().finish();*/
                selfPai.setVisibility(View.VISIBLE);
                selfCe.setVisibility(View.VISIBLE);
                selfQu.setVisibility(View.VISIBLE);
                relativeAlphaSelf.setVisibility(View.VISIBLE);
                break;
            case R.id.self_pai:
                selfPai.setVisibility(View.GONE);
                selfCe.setVisibility(View.GONE);
                selfQu.setVisibility(View.GONE);
                relativeAlphaSelf.setVisibility(View.GONE);
                break;
            case R.id.self_ce:

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 111);

                selfPai.setVisibility(View.GONE);
                selfCe.setVisibility(View.GONE);
                selfQu.setVisibility(View.GONE);
                relativeAlphaSelf.setVisibility(View.GONE);
                break;
            case R.id.self_qu:
                selfPai.setVisibility(View.GONE);
                selfCe.setVisibility(View.GONE);
                selfQu.setVisibility(View.GONE);
                relativeAlphaSelf.setVisibility(View.GONE);
                break;
            case R.id.relative_alpha_self:
                selfPai.setVisibility(View.GONE);
                selfCe.setVisibility(View.GONE);
                selfQu.setVisibility(View.GONE);
                relativeAlphaSelf.setVisibility(View.GONE);
                break;
            case R.id.butedk_two:
                getActivity().finish();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==111) {
            if (resultCode== Activity.RESULT_OK) {
                Uri uri = data.getData();
                if (uri != null) {

                    String path = ImageUtil.getPath(getActivity(), uri);
                    Log.d(TAG, "onActivityResult: "+path);
                   /* SPUtils spImagePhoto = new SPUtils(getActivity(), "ImagePhoto");
                    spImagePhoto.putString("ImagePhoto", path);*/
                    selfImg.setVisibility(View.VISIBLE);
                    Glide.with(getActivity()).load(path)
                            .placeholder(R.mipmap.ic_launcher_round)
                            .error(R.mipmap.ic_launcher)
                            .into(selfImg);

                    linearXuan.setVisibility(View.GONE);
                    if (path != null) {
                        //转换为file类型
                        File file = new File(path);
                        //进行类型转换,因为在RetrofitService定义的是@Part MultipartBody.Part,所以要转成这样的格式
                        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                        imagePic = MultipartBody.Part.createFormData("imagePic", file.getName(), requestBody);

                    }
                }
            }
        }else {
            Toast.makeText(getActivity(), "取消相册", Toast.LENGTH_SHORT).show();
        }
    }
}
