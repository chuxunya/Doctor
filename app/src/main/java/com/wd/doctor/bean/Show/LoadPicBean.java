package com.wd.doctor.bean.Show;

/**
 * 作者:dongyanjun
 * 时间：2019/12/21
 * 描述:Doctor
 * 功能：
 **/
public class LoadPicBean {


    /**
     * result : http://172.17.8.100/images/health/doctor/image_pic/2019-12-21/PII8Um20191221100746.jpg
     * message : 上传成功
     * status : 0000
     */

    private String result;
    private String message;
    private String status;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
