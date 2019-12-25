package com.wd.doctor.adapter.Show;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.SimpleBannerInfo;
import com.wd.doctor.R;
import com.wd.doctor.bean.Show.PictureBean;

import org.greenrobot.eventbus.EventBus;

import java.util.AbstractList;
import java.util.List;

/**
 * 作者:dongyanjun
 * 时间：2019/12/21
 * 描述:Doctor
 * 功能：
 **/
public class MyPicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<PictureBean.ResultBean> result;
    public MyPicAdapter(Context context, List<PictureBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.spic_item, parent, false);
        return new ViewHolder1(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
/*
            ((ViewHolder1) holder).x_banner_pic.setBannerData(R.layout.sim_layout, new AbstractList<SimpleBannerInfo>() {
                @Override
                public SimpleBannerInfo get(int i) {
                    return null;
                }

                @Override
                public int size() {
                    return result.size();
                }
            });
*/

/*
            ((ViewHolder1) holder).x_banner_pic.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    SimpleDraweeView simp = view.findViewById(R.id.simp);
                  DraweeController controller = Fresco.newDraweeControllerBuilder()
                            .setUri(result.get(position).getImagePic())
                            .setAutoPlayAnimations(true)
                            .build();
                    simp.setController(controller);

                }
            });
*/
          Glide.with(context).load(result.get(position).getImagePic()).into(((ViewHolder1) holder).img_pic_one);


          ((ViewHolder1) holder).img_pic_one.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  onClickListener.onItemClick(position);
              }
          });

        }
    }


    @Override
    public int getItemCount() {
        return result.size();
    }
    OnItemClickListener onClickListener;
    public void setOnClickListener(OnItemClickListener onClickListener){
        this.onClickListener=onClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    private class ViewHolder1 extends RecyclerView.ViewHolder {
       // private final XBanner x_banner_pic;

        private final ImageView img_pic_one;

        public ViewHolder1(View view) {
            super(view);
            //x_banner_pic = view.findViewById(R.id.x_banner_pic);
            img_pic_one = view.findViewById(R.id.img_pic_one);
        }
    }
}
