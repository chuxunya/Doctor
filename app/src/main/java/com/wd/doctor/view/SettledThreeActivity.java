package com.wd.doctor.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wd.doctor.R;
import com.wd.doctor.RsaCoder;
import com.wd.doctor.bean.ForgetBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.Show.BodyBean;
import com.wd.doctor.bean.Show.DoctorBean;
import com.wd.doctor.bean.Show.SearchBean;
import com.wd.doctor.bean.login.CodeBean;
import com.wd.doctor.bean.login.KeShiBean;
import com.wd.doctor.bean.login.SettledInBean;
import com.wd.doctor.bean.login.ZhiZeBean;
import com.wd.doctor.bean.message.MessageBean;
import com.wd.doctor.contract.HomeContract;
import com.wd.doctor.presenter.HomePresenter;
import com.wd.mvp.base.BaseActivity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettledThreeActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {


    private static final String TAG = "TagSettledThree";
    @BindView(R.id.back_ru)
    ImageView backRu;
    @BindView(R.id.tv_jian)
    TextView tvJian;
    @BindView(R.id.tv_jian1)
    TextView tvJian1;
    @BindView(R.id.et_jian)
    EditText etJian;
    @BindView(R.id.tv_shan)
    TextView tvShan;
    @BindView(R.id.tv_shan1)
    TextView tvShan1;
    @BindView(R.id.et_shan)
    EditText etShan;
    @BindView(R.id.bt_ruzhu)
    Button btRuzhu;
    private String email;
    private String code;
    private String pwd1;
    private String pwd2;
    private String name;
    private String yiyuan;
    private String keshi;
    private String zhize;
    private String jian;
    private String shan;
    private String pwdOne;
    private String pwdTwo;

    @Override
    public void onLoginSuccess(LoginBean data) {

    }

    @Override
    public void onDoctorSuccess(DoctorBean data) {

    }

    @Override
    public void onAllMeaageSuccess(MessageBean data) {

    }

    @Override
    public void onSearchSuccess(SearchBean data) {

    }

    @Override
    public void onBodySuccess(BodyBean data) {

    }

    @Override
    public void onForgetSuccess(ForgetBean data) {

    }

    @Override
    public void onChecKCodeSuccess(ForgetBean data) {

    }

    @Override
    public void onSendCodeSuccess(CodeBean data) {

    }

    @Override
    public void onKeShiSuccess(KeShiBean data) {

    }

    @Override
    public void onZhiZeSuccess(ZhiZeBean data) {

    }

    @Override
    public void onSettledIn(SettledInBean data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onHomeError(String e) {

    }

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_settled_three;
    }

    @Override
    protected void initData() {
        super.initData();

//        intent.putExtra("email",email);
//                intent.putExtra("code",code);
//                intent.putExtra("pwd1",pwd1);
//                intent.putExtra("pwd2",pwd2);
//                intent.putExtra("name",name);
//                intent.putExtra("yiyuan",yiyuan);
//                intent.putExtra("keshi",keshi);
//                intent.putExtra("zhize",zhize);
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        code = intent.getStringExtra("code");
        pwd1 = intent.getStringExtra("pwd1");
        try {
            pwdOne = RsaCoder.encryptByPublicKey(pwd1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pwd2 = intent.getStringExtra("pwd2");
        try {
            pwdTwo = RsaCoder.encryptByPublicKey(pwd2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        name = intent.getStringExtra("name");
        yiyuan = intent.getStringExtra("yiyuan");
        keshi = intent.getStringExtra("keshi");
        zhize = intent.getStringExtra("zhize");
    }

    @OnClick({R.id.back_ru, R.id.bt_ruzhu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_ru:
                finish();
                break;
            case R.id.bt_ruzhu:
                jian = etJian.getText().toString().trim();
                shan = etShan.getText().toString().trim();
                HashMap<String, String> map = new HashMap<>();
                map.put("email:",email);
                map.put("code:",code);
                map.put("pwd1:",pwdOne);
                map.put("pwd2:",pwdOne);
                map.put("name:",name);
                map.put("inauguralHospital:",yiyuan);
                map.put("departmentName:",keshi);
                map.put("jobTitle:",zhize);
                map.put("personalProfile:",jian);
                map.put("goodField:",shan);
                Gson gson = new Gson();
                String s = gson.toJson(map);
                Log.d(TAG, "onViewClicked: "+s);
                Set<Map.Entry<String, String>> entries = map.entrySet();
                Iterator<Map.Entry<String, String>> iterator = entries.iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, String> next = iterator.next();
                    String key=next.getKey();
                    String value=next.getValue();
                    System.out.println(key+":"+value);
                }


              /*  Log.d(TAG, "email: "+email+"code:"+code+"pwd1:"+pwdOne+"pwd2:"+pwdOne+"name:"+name+"inauguralHospital"+yiyuan+"departmentName"+keshi+"jobTitle:"+"personalProfile:"+jian+"goodField:"+shan);*/
               // mPresenter.postSettledIn(email,code,pwdOne,pwdOne,name,yiyuan,keshi,zhize,jian,shan);
                break;
        }
    }
}
