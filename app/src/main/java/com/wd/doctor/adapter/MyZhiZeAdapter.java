package com.wd.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.bean.login.ZhiZeBean;
import com.wd.doctor.view.SettledTwoActivity;

import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/12/13
 * 描述:Doctor
 * 功能：
 **/
public class MyZhiZeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<ZhiZeBean.ResultBean> result;
    public MyZhiZeAdapter(Context context, List<ZhiZeBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.keshi_item, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ((ViewHolder1) holder).tv_keshi_name.setText(result.get(position).getJobTitle());
            ((ViewHolder1) holder).linear_keshi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String jobTitle = result.get(position).getJobTitle();
                    onItemClickListener.onItem(jobTitle);
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
        void onItem(String name);
    }
    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private final LinearLayout linear_keshi;
        private final TextView tv_keshi_name;

        public ViewHolder1(View view) {
            super(view);
            linear_keshi = view.findViewById(R.id.linear_keshi);
            tv_keshi_name = view.findViewById(R.id.tv_keshi_name);
        }
    }
}
