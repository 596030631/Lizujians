package com.lizujian.qrcode.http;

import com.lizujian.qrcode.bean.Base.BaseObjectBean;
import com.lizujian.qrcode.bean.LoginBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIServices {
    /**
     * 登陆
     * @param username 账号
     * @param password 密码
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Flowable<BaseObjectBean<LoginBean>>login(@Field("username") String username,
    @Field("password")String password);

    /**
     * 注册
     * @param username 账号
     * @param password 密码
     * @param repassword 重复密码
     * @return
     */
    @FormUrlEncoded
    @POST("user/register")
    Flowable<BaseObjectBean<LoginBean>>register(@Field("username") String username,
    @Field("password")String password,@Field("repassword") String repassword);

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

}
