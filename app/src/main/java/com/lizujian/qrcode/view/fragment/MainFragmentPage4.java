package com.lizujian.qrcode.view.fragment;

import android.view.View;
import android.widget.TextView;

import com.lizujian.qrcode.APP;
import com.lizujian.qrcode.R;
import com.lizujian.qrcode.base.v.BaseFragment;
import com.lizujian.qrcode.sql.PreferencesService;
import com.lizujian.qrcode.view.MainActivity;

import butterknife.BindView;

public class MainFragmentPage4 extends BaseFragment<MainActivity> {

    @BindView(R.id.fragment4_username)
    protected TextView userName;

    @Override
    protected int getLayout() {
        return R.layout.fragment_main_page4;
    }

    @Override
    protected void initView(View v) {

        PreferencesService ps = APP.getPreferencesService();

        userName.setText(ps.getValue(APP.USER,"lizujian"));

    }
}
