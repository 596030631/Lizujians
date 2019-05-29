package com.lizujian.qrcode.view;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lizujian.qrcode.Contract.MainContract;
import com.lizujian.qrcode.R;
import com.lizujian.qrcode.base.v.BaseActivity;
import com.lizujian.qrcode.base.v.BaseFragment;
import com.lizujian.qrcode.presenter.MainPresenter;
import com.lizujian.qrcode.view.fragment.MainFragmentPage1;
import com.lizujian.qrcode.view.fragment.MainFragmentPage2;
import com.lizujian.qrcode.view.fragment.MainFragmentPage3;
import com.lizujian.qrcode.view.fragment.MainFragmentPage4;
import com.lizujian.qrcode.util.CaptureActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View{
    private long mExitTime;
    @BindView(R.id.fragment_viewpage_content)
    protected ViewPager mViewPager;

    @BindViews({ R.id.icon_page1, R.id.icon_page2, R.id.icon_page3, R.id.icon_page4})
    List<TextView> mIconList;

    @BindViews({R.id.btn_page1,R.id.btn_page2,R.id.btn_page3,R.id.btn_page4})
    List<LinearLayout> mBtnList;

    @BindViews({R.id.title_line_1,R.id.title_line_2,R.id.title_line_3})
    List<View> mTitleLineList;

//    @BindViews({R.id.title_text_1,R.id.title_text_2,R.id.title_text_3})
//    List<TextView> mTitleTextBtn;
    private List<BaseFragment> mFragment = new ArrayList<>();
    private FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()){
        @Override
        public int getCount() { return mFragment.size(); }
        @Override
        public Fragment getItem(int i) { return mFragment.get(i); }
    };
    @Override
    public void initView() {
        //绑定view
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
        BaseFragment Tab1 = new MainFragmentPage1();
        BaseFragment Tab2 = new MainFragmentPage2();
        BaseFragment Tab3 = new MainFragmentPage3();
        BaseFragment Tab4 = new MainFragmentPage4();
        mFragment.add(Tab1);
        mFragment.add(Tab2);
        mFragment.add(Tab3);
        mFragment.add(Tab4);
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) { }
            @Override
            public void onPageSelected(int i) {
                int currrentPage = i;
                setButton(currrentPage);
            }
            @Override
            public void onPageScrollStateChanged(int i) { }
        });
    }
    @OnClick(R.id.title_text_1)
    void SelectHomePage_1_ByTop(){ selectedPage(0); }
    @OnClick(R.id.title_text_2)
    void SelectHomePage_2_ByTop(){
        selectedPage(1);
    }
    @OnClick(R.id.title_text_3)
    void SelectHomePage_4_ByTop(){
        selectedPage(3);
    }
    @OnClick(R.id.btn_page1)
    void SelectHomePage1(){
        selectedPage(0);
    }
    @OnClick(R.id.btn_page2)
    void SelectMinePage2(){ selectedPage(1); }
    @OnClick(R.id.btn_page3)
    void SelectMinePage3(){ selectedPage(2); }
    @OnClick(R.id.btn_page4)
    void SelectMinePage4(){ selectedPage(3); }
    @Override
    public void selectedPage(int i) {
        mViewPager.setCurrentItem(i);
    }
    public int RESULT_REQUEST_CODE = 2;
    @OnClick(R.id.btn_main_scan)//点击开始扫码
    void Scan(){
        Toast.makeText(this, "打开扫码器", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, CaptureActivity.class));
    }

    private void setButton(int i){
        //在此改变按钮状态
        initAllDetail();
        switch (i){
            case 0:
                mIconList.get(0).setBackgroundResource(R.drawable.page1_1);
                mTitleLineList.get(0).setVisibility(View.VISIBLE);
                break;

            case 1:
                mIconList.get(1).setBackgroundResource(R.drawable.page2_1);
                mTitleLineList.get(1).setVisibility(View.VISIBLE);
                break;

            case 2:
                mIconList.get(2).setBackgroundResource(R.drawable.page3_1);
                break;

            case 3:
                mIconList.get(3).setBackgroundResource(R.drawable.page4_1);
                mTitleLineList.get(2).setVisibility(View.VISIBLE);
                break;
        }
    }
    /**
     * 监听返回按键
     * 点击两次退出app
     * */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ( mFragment!= null && mFragment .size() >= 1) {
            MainFragmentPage1 fragment =(MainFragmentPage1) mFragment .get(0);
            return  fragment.onKeyDownChild(keyCode, event,MainActivity.this);
        }else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public void initData() {

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("温馨提示")
                    .setMessage("为了您更好的使用扫描功能，请您赋予相机权限")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.M)
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
                        }
                    }).show();
        } else {

        }
    }

    @Override
    public int getLayoutId() { return R.layout.activity_main; }

    @Override
    public void showLoading() { }

    @Override
    public void hideLoading() { }
    @Override
    public void onError(Throwable throwable) {

    }
    @Override
    public void initEvent() {
        selectedPage(1);
        mTitleLineList.get(1).setVisibility(View.VISIBLE);
        mIconList.get(1).setBackgroundResource(R.drawable.page2_1);
    }
    private void initAllDetail(){
        mIconList.get(0).setBackgroundResource(R.drawable.page1_0);
        mIconList.get(1).setBackgroundResource(R.drawable.page2_0);
        mIconList.get(2).setBackgroundResource(R.drawable.page3_0);
        mIconList.get(3).setBackgroundResource(R.drawable.page4_0);
        mTitleLineList.get(0).setVisibility(View.GONE);
        mTitleLineList.get(1).setVisibility(View.GONE);
        mTitleLineList.get(2).setVisibility(View.GONE);
    }
}
