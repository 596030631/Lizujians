package com.lizujian.qrcode.view.fragment;

import android.view.View;
import android.widget.TextView;

import com.lizujian.qrcode.APP;
import com.lizujian.qrcode.R;
import com.lizujian.qrcode.base.v.BaseFragment;
import com.lizujian.qrcode.sql.PreferencesService;
import com.lizujian.qrcode.view.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainFragmentPage4 extends BaseFragment<MainActivity> {

    @BindView(R.id.fragment4_username)
    protected TextView userName;

    @BindView(R.id.nicheng)
    protected TextView nicheng;

    @BindView(R.id.counts)
    protected TextView counts;


    @Override
    protected int getLayout() {
        return R.layout.fragment_main_page4;
    }

    @Override
    protected void initView(View v) {
        PreferencesService ps = APP.getPreferencesService();
        userName.setText(ps.getValue(APP.USER,"lizujian"));
        counts.setText(ps.getValue("counts","-1"));
    }

    @OnClick(R.id.freshs)
    void fresh(){
        PreferencesService ps = APP.getPreferencesService();
        counts.setText(ps.getValue("counts","-1"));

    }
@OnClick(R.id.exit)
    void exit(){
        userName.setText("");
        nicheng.setText("");
    }


    @OnClick(R.id.quit)
    void quit(){
        mView.finish();
    }


}
