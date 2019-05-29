package com.lizujian.qrcode.presenter;
import android.content.Intent;
import android.widget.Toast;

import com.lizujian.qrcode.APP;
import com.lizujian.qrcode.Contract.LoginContract;
import com.lizujian.qrcode.base.p.BasePresenter;
import com.lizujian.qrcode.bean.Base.BaseObjectBean;
import com.lizujian.qrcode.bean.LoginBean;
import com.lizujian.qrcode.http.RxScheduler;
import com.lizujian.qrcode.model.LoginModel;
import com.lizujian.qrcode.sql.PreferencesService;
import com.lizujian.qrcode.view.LoginActivity;
import com.lizujian.qrcode.view.MainActivity;

import io.reactivex.functions.Consumer;

/**
 * 登录
 * Presenter
 * */
public class LoginPresenter extends BasePresenter<LoginActivity> implements LoginContract.Presenter {

    private LoginContract.Model model;
    public LoginPresenter(){
        model = new LoginModel();
    }
    @Override
    public void Login(final String name, final String password) {
        if(!isAttach()) { //绑定了view之后才执行请求
            return;
        }
        mView.showLoading();
        model.login(name,password)
                .compose(RxScheduler.<BaseObjectBean<LoginBean>>FIo_io_main())
                .as(mView.<BaseObjectBean<LoginBean>>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean<LoginBean>>() {
                    @Override
                    public void accept(BaseObjectBean<LoginBean> bean) throws Exception {
                        mView.onSuccess(bean);
                        //登陆成功
                        if(bean.getErrorCode() == 0) {
                            mView.startActivity(new Intent(mView, MainActivity.class));
                            //保存当前用户名、密码
                            PreferencesService sp = APP.getPreferencesService();
                            sp.save(APP.USER,name);
                            sp.save(APP.PASSWORD,password);

                            mView.finish();
                        } else {
                            Toast.makeText(mView,"登陆失败",Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }

    @Override
    public void Register(String name, String password, String rePassword) {
        if(!isAttach()) {
            return;
        }
        mView.showLoading();
        model.register(name,password,rePassword)
                .compose(RxScheduler.<BaseObjectBean<LoginBean>>FIo_io_main())
                .as(mView.<BaseObjectBean<LoginBean>>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean<LoginBean>>() {
                    @Override
                    public void accept(BaseObjectBean<LoginBean> bean) throws Exception {
                        mView.onSuccess(bean);
                        if(bean.getErrorCode()== 0)
                            Toast.makeText(mView, "注册成功", Toast.LENGTH_SHORT).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }
}
