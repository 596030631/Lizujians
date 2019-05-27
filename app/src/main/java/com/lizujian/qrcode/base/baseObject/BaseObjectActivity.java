package com.lizujian.qrcode.base.baseObject;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
public abstract class BaseObjectActivity extends AppCompatActivity {
    private Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
        initEvent();
        initData();
    }
    public abstract void initView();
    public abstract void initEvent();
    public abstract void initData();
    public abstract int getLayoutId();


    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
