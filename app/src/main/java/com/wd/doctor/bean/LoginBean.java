package com.wd.doctor.bean;

/**
 * 作者:dongyanjun
 * 时间：2019/12/11
 * 描述:Doctor
 * 功能：
 **/
public class LoginBean {


    /**
     * result : {"departmentId":5,"departmentName":"小儿科","id":158,"imagePic":"http://172.17.8.100/images/health/doctor/image_pic/2019-12-11/F3EAZn20191211135120.png","inauguralHospital":"清华大学附属医院","jiGuangPwd":"enlOnObxlUlF74bz96CjPAF7DJv5WDYHfpyXPw9EkGiGK5VMYIm9+xblEVkY3jUw1SQ8R1pIZQV/ueLVisXlImCSkfHJ6BTbN39s+smgAYz4grYDwYAzFcH2c2ywv3HrP79oCMpGnR7oB4lQzePxzArW+4K17baeCzxyO6m7Epk=","jobTitle":"主任","name":"董先生","reviewStatus":2,"sessionId":"1581576234700709158","userName":"l42lX41758992398","whetherHaveImagePic":1}
     * message : 登录成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
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

    public static class ResultBean {
        /**
         * departmentId : 5
         * departmentName : 小儿科
         * id : 158
         * imagePic : http://172.17.8.100/images/health/doctor/image_pic/2019-12-11/F3EAZn20191211135120.png
         * inauguralHospital : 清华大学附属医院
         * jiGuangPwd : enlOnObxlUlF74bz96CjPAF7DJv5WDYHfpyXPw9EkGiGK5VMYIm9+xblEVkY3jUw1SQ8R1pIZQV/ueLVisXlImCSkfHJ6BTbN39s+smgAYz4grYDwYAzFcH2c2ywv3HrP79oCMpGnR7oB4lQzePxzArW+4K17baeCzxyO6m7Epk=
         * jobTitle : 主任
         * name : 董先生
         * reviewStatus : 2
         * sessionId : 1581576234700709158
         * userName : l42lX41758992398
         * whetherHaveImagePic : 1
         */

        private String departmentId;
        private String departmentName;
        private String id;
        private String imagePic;
        private String inauguralHospital;
        private String jiGuangPwd;
        private String jobTitle;
        private String name;
        private String reviewStatus;
        private String sessionId;
        private String userName;
        private String whetherHaveImagePic;

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImagePic() {
            return imagePic;
        }

        public void setImagePic(String imagePic) {
            this.imagePic = imagePic;
        }

        public String getInauguralHospital() {
            return inauguralHospital;
        }

        public void setInauguralHospital(String inauguralHospital) {
            this.inauguralHospital = inauguralHospital;
        }

        public String getJiGuangPwd() {
            return jiGuangPwd;
        }

        public void setJiGuangPwd(String jiGuangPwd) {
            this.jiGuangPwd = jiGuangPwd;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getReviewStatus() {
            return reviewStatus;
        }

        public void setReviewStatus(String reviewStatus) {
            this.reviewStatus = reviewStatus;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getWhetherHaveImagePic() {
            return whetherHaveImagePic;
        }

        public void setWhetherHaveImagePic(String whetherHaveImagePic) {
            this.whetherHaveImagePic = whetherHaveImagePic;
        }
    }
}
