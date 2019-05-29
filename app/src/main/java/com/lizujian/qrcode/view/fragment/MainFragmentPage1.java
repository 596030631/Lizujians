package com.lizujian.qrcode.view.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.lizujian.qrcode.R;
import com.lizujian.qrcode.base.v.BaseFragment;
import com.lizujian.qrcode.view.MainActivity;
import com.lizujian.qrcode.util.NoAdWebViewClient;

import butterknife.BindView;
public class MainFragmentPage1 extends BaseFragment<MainActivity>  {
    private long mExitTime;
    private Handler mHandler = new Handler();
    @BindView(R.id.web_view_frahment_home)
    WebView mWebView;
    @Override
    protected int getLayout() {
        return R.layout.fragment_main_page1;
    }

    @SuppressLint("JavascriptInterface")
    @Override
    protected void initView(View v) {
        //在当前app中加载网页
        mWebView.setWebViewClient(new NoAdWebViewClient(this.getContext(),mWebView));
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new Object() {
            public void clickOnAndroid() {
                mHandler.post(new Runnable() {
                    public void run() {
                        mWebView.loadUrl("javascript:wave()");
                    }
                });
            }
        }, "demo");
        mWebView.loadUrl("https://list.tmall.com/search_product.htm?q=%E7%89%9B%" +
                "E5%A5%B6&type=p&vmarket=&spm=875.7931836%2FB.a2227oh.d100&from=mallfp." +
                ".pc_1_searchbutton");// 加载url，也可以执行js函数
    }

    public boolean onKeyDownChild(int keyCode, KeyEvent event, Context context) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
                mWebView.goBack();
                return true;
            }
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

                if ((System.currentTimeMillis() - mExitTime) > 2000) {
                    Toast.makeText(context, "再按一次退出！", Toast.LENGTH_SHORT).show();
                    mExitTime = System.currentTimeMillis();
                } else {
                    mView.finish();
                    System.exit(0);
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
