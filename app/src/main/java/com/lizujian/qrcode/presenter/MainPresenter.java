package com.lizujian.qrcode.presenter;

import com.lizujian.qrcode.Contract.MainContract;
import com.lizujian.qrcode.base.p.BasePresenter;
import com.lizujian.qrcode.view.MainActivity;

public class MainPresenter extends BasePresenter<MainActivity> implements MainContract.Presenter {


    @Override
    public void exitApp() {
        mView.finish();
    }
}
