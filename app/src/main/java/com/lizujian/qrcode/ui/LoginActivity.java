package com.lizujian.qrcode.ui;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.widget.Toast;
import com.lizujian.qrcode.Contract.LoginContract;
import com.lizujian.qrcode.R;
import com.lizujian.qrcode.base.v.BaseActivity;
import com.lizujian.qrcode.bean.Base.BaseObjectBean;
import com.lizujian.qrcode.bean.LoginBean;
import com.lizujian.qrcode.presenter.LoginPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录
 * View
 * */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_login_username)
    TextInputEditText mLoginUserName;
    @BindView(R.id.et_login_password)
    TextInputEditText mLoginPassword;
    /**
     * 布局文件
     **/
    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }
    @Override
    public void initView() {
        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);
    }
    @Override
    public void initEvent() { }
    @Override
    public void initData() { }
    @Override
    public void showLoading() {
    }
    @Override
    public void hideLoading() {
    }
    /**
     * 获得
     * username
     * */
    private String getUsername(){
        return mLoginUserName.getText().toString().trim();
    }
    /**
     * 获得
     * Password
     * */
    private String getPassword(){
        return mLoginPassword.getText().toString().trim();
    }
    @Override
    public void onSuccess(BaseObjectBean<LoginBean> bean) {
        if(bean.getMsg().isEmpty()){
            return;
        }
        Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onError(Throwable throwable) {

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_login_in)
    public void login(){
        if(getUsername().isEmpty() || getPassword().isEmpty()) {
            Toast.makeText(this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        mPresenter.Login(getUsername(),getPassword());
    }
    @OnClick(R.id.btn_register_in)
    public void register(){
        if(getUsername().isEmpty() || getPassword().isEmpty()) {
            Toast.makeText(this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        mPresenter.Register(getUsername(),getPassword(),getPassword());
    }
}
