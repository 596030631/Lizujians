package com.lizujian.qrcode.base.p;
import com.lizujian.qrcode.base.v.BaseView;

public class BasePresenter<V extends BaseView> {
    protected V mView;

    /**
     * 绑定View
     * 一般在初始化中调用
     * presenter绑定view
     * */
    public void attachView(V v){
        mView = v;
    }

    /**
     * 解除绑定View
     * 一般在Destory中调用
     * presenter解除绑定view
     * */
    public void removeView(){
        mView = null;
    }

    /**
     * 绑定结果
     * presenter是否绑定view
     * */
    public boolean isAttach(){
        return mView != null;
    }
}
