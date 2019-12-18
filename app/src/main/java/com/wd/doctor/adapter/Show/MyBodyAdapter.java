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

import com.bumptech.glide.Glide;
import com.wd.doctor.R;
import com.wd.doctor.bean.Show.BodyBean;
import com.wd.doctor.view.Sick.SickActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/12/13
 * 描述:Doctor
 * 功能：
 **/
public class MyBodyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    Context context;
    List<BodyBean.ResultBean> result;
    public MyBodyAdapter(Context context, List<BodyBean.ResultBean> result) {
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
            if (result.get(position).getAmount()!=0) {
                Glide.with(context).load(R.mipmap.h_currency).into(((ViewHolder1) holder).img_h);
                ((ViewHolder1) holder).tv_hb.setText(result.get(position).getAmount()+"");
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh:mm");
            ((ViewHolder1) holder).tv_time.setText(simpleDateFormat.format(date));

            ((ViewHolder1) holder).linear_sick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String sickCircleId = result.get(position).getSickCircleId();
                    onItemClickListener.onItem(sickCircleId);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return result.size();
    }
    OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public interface OnItemClickListener{
        void onItem(String id);
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private final LinearLayout linear_sick;
        private final TextView tv_title;
        private final TextView tv_nei;
        private final TextView tv_time;
        private final ImageView img_h;
        private final TextView tv_hb;

        public ViewHolder1(View view) {
            super(view);
            linear_sick = view.findViewById(R.id.linear_sick);
            tv_title = view.findViewById(R.id.tv_title);
            tv_nei = view.findViewById(R.id.tv_nei);
            tv_time = view.findViewById(R.id.tv_time);
            img_h = view.findViewById(R.id.img_h);
            tv_hb = view.findViewById(R.id.tv_hb);
        }
    }
}
