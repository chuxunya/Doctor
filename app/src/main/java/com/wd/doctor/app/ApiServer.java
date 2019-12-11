package com.wd.doctor.app;

import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.login.CodeBean;
import com.wd.doctor.bean.login.KeShiBean;
import com.wd.doctor.bean.login.SettledInBean;
import com.wd.doctor.bean.login.ZhiZeBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 作者:dongyanjun
 * 时间：2019/12/11
 * 描述:Doctor
 * 功能：
 **/
public interface ApiServer {

    //登录
    @FormUrlEncoded
    @POST("health/doctor/v1/login")
    Observable<LoginBean> postLogin(@Field("email")String email,@Field("pwd")String pwd);
    //申请入驻
    @FormUrlEncoded
    @POST("health/doctor/v1/applyJoin")
    Observable<SettledInBean> postSettledIn(@Field("email")String email,@Field("code")String code,@Field("pwd1")String pwd1,@Field("pwd2")String pwd2,@Field("name")String name,@Field("inauguralHospital")String inauguralHospital,@Field("departmentName")String departmentName,@Field("jobTitle") String jobTitle,@Field("personalProfile")String personalProfile,@Field("goodField")String goodField);
    //获取验证码
    @POST("health/doctor/v1/sendEmailCode")
    Observable<CodeBean> postSendCode(@Query("email")String email);
    //查询科室
    @GET("health/share/knowledgeBase/v1/findDepartment")
    Observable<KeShiBean> getKeShi();
    //查询职责
    @GET("health/doctor/v1/findJobTitleList")
    Observable<ZhiZeBean> getZhiZe();
}
