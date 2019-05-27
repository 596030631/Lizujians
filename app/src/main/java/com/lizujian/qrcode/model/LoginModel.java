package com.lizujian.qrcode.model;


import com.lizujian.qrcode.Contract.LoginContract;
import com.lizujian.qrcode.bean.Base.BaseObjectBean;
import com.lizujian.qrcode.bean.LoginBean;
import com.lizujian.qrcode.http.RetrofitClient;

import io.reactivex.Flowable;

/**
 * 登录
 * model
 * */
public class LoginModel implements LoginContract.Model {

    @Override
    public Flowable<BaseObjectBean<LoginBean>> login(String name, String password) {
        return RetrofitClient.getInstance().getApi().login(name,password);
    }

    @Override
    public Flowable<BaseObjectBean<LoginBean>> register(String name, String password, String rePassword) {
        return RetrofitClient.getInstance().getApi().register(name,password,rePassword);
    }
}
