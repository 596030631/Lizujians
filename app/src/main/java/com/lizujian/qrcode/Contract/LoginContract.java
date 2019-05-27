package com.lizujian.qrcode.Contract;

import com.lizujian.qrcode.base.v.BaseView;
import com.lizujian.qrcode.bean.Base.BaseObjectBean;
import com.lizujian.qrcode.bean.LoginBean;

import io.reactivex.Flowable;

public interface LoginContract {
    /**
     * model
     * @Login
     * */
    interface Model{
        /**
         * Flowable
         * 登录
         */
        Flowable<BaseObjectBean<LoginBean>> login(String name,String password);
        Flowable<BaseObjectBean<LoginBean>> register(String name,String password,String rePassword);
    }


    /**
     * Presenter
     * @Login
     *  param   name
     *  param  password
     * */
    interface Presenter{
        void Login(String name,String password);
        void Register(String name,String password,String rePassword);
    }


    /**
     * @Login    view
     * */
    interface View extends BaseView {
        @Override
        void showLoading();
        @Override
        void hideLoading();
        @Override
        void onError(Throwable throwable);
        void onSuccess(BaseObjectBean<LoginBean> bean);
    }
}
