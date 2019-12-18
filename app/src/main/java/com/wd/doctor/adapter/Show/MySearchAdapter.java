package com.wd.doctor.adapter.Show;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.bean.Show.SearchBean;
import com.wd.doctor.view.Sick.SearchActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/12/13
 * 描述:Doctor
 * 功能：
 **/
public class MySearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<SearchBean.ResultBean> result;
    public MySearchAdapter(Context context, List<SearchBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sick_item, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ((ViewHolder1) holder).tv_title.setText(result.get(position).getTitle());
            ((ViewHolder1) holder).tv_nei.setText(result.get(position).getDetail());
            Date date = new Date(result.get(position).getReleaseTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh:mm");
            ((ViewHolder1) holder).tv_time.setText(simpleDateFormat.format(date));
          /*  ((ViewHolder1) holder).tv_title.setText(result.get(position).getTitle());
            ((ViewHolder1) holder).tv_nei.setText(result.get(position).getDetail());
            Date date = new Date(result.get(position).getReleaseTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh:mm");
            ((ViewHolder1) holder).tv_time.setText(simpleDateFormat.format(date));*/
        }
    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {
        private final LinearLayout linear_sick;
        private final TextView tv_title;
        private final TextView tv_nei;
        private final TextView tv_time;
        private final ImageView img_h;

        public ViewHolder1(View view) {
            super(view);
            linear_sick = view.findViewById(R.id.linear_sick);
            tv_title = view.findViewById(R.id.tv_title);
            tv_nei = view.findViewById(R.id.tv_nei);
            tv_time = view.findViewById(R.id.tv_time);
            img_h = view.findViewById(R.id.img_h);
        }
    }
}
