package com.lizujian.qrcode.presenter;

import com.lizujian.qrcode.Contract.MainContract;
import com.lizujian.qrcode.base.p.BasePresenter;
import com.lizujian.qrcode.ui.MainActivity;
import com.uber.autodispose.AutoDisposeConverter;

public class MainPresenter extends BasePresenter<MainActivity> implements MainContract.Presenter {


    @Override
    public void exitApp() {
        mView.finish();
    }
}
