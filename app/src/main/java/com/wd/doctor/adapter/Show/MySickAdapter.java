package com.wd.doctor.adapter.Show;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.bean.login.KeShiBean;
import com.wd.doctor.fragment.SickFrag;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/12/14
 * 描述:Doctor
 * 功能：
 **/
public class MySickAdapter extends FragmentPagerAdapter {


    ArrayList<String> tab;
    List<KeShiBean.ResultBean> result;
    public MySickAdapter(@NonNull FragmentManager fm,ArrayList<String> tab, List<KeShiBean.ResultBean> result) {
        super(fm);
        this.tab=tab;
        this.result=result;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();bundle.putString("departmentId",result.get(position).getId()+"");
        SickFrag sickFrag = new SickFrag();
        sickFrag.setArguments(bundle);
        return sickFrag;
    }


    @Override
    public int getCount() {
        return tab.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tab.get(position);
    }
}
