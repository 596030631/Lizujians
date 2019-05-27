package com.lizujian.qrcode.Contract;

import com.lizujian.qrcode.base.v.BaseView;

public interface MainContract {
    /**
     * MainModel
     * */
    interface Model {

    }

    /**
     * MainPresenter
     * */
    interface Presenter {
        /**
         * 退出App
         * */
        void exitApp();
    }

    /**
     * MainView
     * */
    interface View extends BaseView {
        void selectedPage(int i);
    }
}
