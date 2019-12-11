package com.wd.mvp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/**
 *@describe(描述)：NetUtil
 *@data（日期）: 2019/11/11
 *@time（时间）: 16:07
 *@author（作者）: xin
 **/
public class NetUtil {
    public static boolean hasNet(Context context){
       ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null  && activeNetworkInfo.isConnected()){
            return true;
        }else {
            return false;
        }

    }
}
