package com.wd.doctor.app;

import com.wd.doctor.bean.ForgetBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.Show.BodyBean;
import com.wd.doctor.bean.Show.SearchBean;
import com.wd.doctor.bean.login.CodeBean;
import com.wd.doctor.bean.login.KeShiBean;
import com.wd.doctor.bean.login.SettledInBean;
import com.wd.doctor.bean.login.ZhiZeBean;
import com.wd.doctor.bean.message.MessageBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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
    Observable<SettledInBean> postSettledIn(@Field("email") String email,@Field("code")String code,@Field("pwd1")String pwd1,@Field("pwd2")String pwd2,@Field("name")String name,@Field("inauguralHospital")String inauguralHospital,@Field("departmentName")String departmentName,@Field("jobTitle") String jobTitle,@Field("personalProfile")String personalProfile,@Field("goodField")String goodField);
    //获取验证码
    @POST("health/doctor/v1/sendEmailCode")
    Observable<CodeBean> postSendCode(@Query("email")String email);
    //查询科室
    @GET("health/share/knowledgeBase/v1/findDepartment")
    Observable<KeShiBean> getKeShi();
    //查询职责
    @GET("health/doctor/v1/findJobTitleList")
    Observable<ZhiZeBean> getZhiZe();
    //重置密码
    @PUT("health/doctor/v1/resetUserPwd")
    Observable<ForgetBean> postForgetBean(@Query("email")String email,@Query("pwd1")String pwd1,@Query("pwd2")String pwd2);
    //校验验证码
    @POST("health/doctor/v1/checkCode")
    Observable<ForgetBean> postCheckCode(@Query("email")String email,@Query("code")String code);
    //病友圈
    @GET("health/doctor/sickCircle/v1/findSickCircleList")
    Observable<BodyBean> getBody(@Query("departmentId")String departmentId,@Query("page")String page,@Query("count")String count);
    //搜索病友圈
    @GET("health/doctor/sickCircle/v1/searchSickCircle")
    Observable<SearchBean> getSearch(@Query("keyWord")String keyWord);
    //修改消息状态为全部已读
    @PUT("health/doctor/verify/v1/modifyAllStatus")
    Observable<MessageBean> putAllMessage(@Header("doctorId") String doctorId,@Header("sessionId")String sessionId);
}
