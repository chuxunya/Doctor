package com.wd.doctor.view.Show;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.wd.doctor.R;
import com.wd.doctor.bean.Show.LoadPicBean;
import com.wd.doctor.bean.Show.PictureBean;
import com.wd.doctor.contract.PictureContract;
import com.wd.doctor.fragment.PicOneFrag;
import com.wd.doctor.fragment.PicTwoFrag;
import com.wd.doctor.presenter.PicPresenter;
import com.wd.mvp.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpdateActivity extends BaseActivity<PicPresenter> implements PictureContract.Iview {


    @BindView(R.id.viewpagg)
    ViewPager viewpagg;
    @BindView(R.id.ragoup)
    RadioGroup ragoup;
    private List<Fragment> list;

    @Override
    protected void initData() {
        super.initData();
        PicOneFrag picOneFrag = new PicOneFrag();
        PicTwoFrag picTwoFrag = new PicTwoFrag();
        list = new ArrayList<>();
        list.add(picOneFrag);
        list.add(picTwoFrag);
        viewpagg.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

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
        return new PicPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_update;
    }


}
