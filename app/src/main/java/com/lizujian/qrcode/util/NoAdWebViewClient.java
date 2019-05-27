package com.lizujian.qrcode.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lizujian.qrcode.R;

/**
 * 去掉WebView
 * 指定ID的广告
 * */
public class NoAdWebViewClient extends WebViewClient {
    private Context mContext;
    private WebView webView;
    private boolean isClose;

    public NoAdWebViewClient(Context context,WebView webView) {
        this.mContext = context;
        this.webView = webView;
    }


    @Override
    public boolean shouldOverrideUrlLoading(WebView wv, String url) {
        if(url == null) return false;
        try {
            if(url.startsWith("weixin://") //微信
                    || url.startsWith("alipays://") //支付宝
                    || url.startsWith("mailto://") //邮件
                    || url.startsWith("tel://")//电话
                    || url.startsWith("dianping://")//大众点评
                    || url.startsWith("tmall://")//淘宝
                    || url.startsWith("tbopen://")//淘宝
                //其他自定义的scheme
            ) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                mContext.startActivity(intent);
                return true;
            }
        } catch (Exception e) { //防止crash (如果手机上没有安装处理某个scheme开头的url的APP, 会导致crash)
            return true;//没有安装该app时，返回true，表示拦截自定义链接，但不跳转，避免弹出上面的错误页面
        }

        //处理http和https开头的url
        wv.loadUrl(url);
        return true;
    }


    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if(isClose){ //如果线程正在运行就不用重新开启一个线程了
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                isClose = true;
                while (isClose){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(0x001);
                }
            }
        }).start();
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String js = getClearAdDivJs(mContext);
            Log.v("adJs",js);
            webView.loadUrl(js);
        }
    };

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        isClose = false;
    }
    public String getClearAdDivJs(Context context){
        String js = "javascript:";
        Resources res = context.getResources();
        String[] adDivs = res.getStringArray(R.array.adBlockDiv);
        for(int i=0;i<adDivs.length;i++){

            js += "var adDiv"+i+"= document.getElementByclassName('"+adDivs[i]+"');if(adDiv"+i+" != null)adDiv"+i+".parentNode.removeChild(adDiv"+i+");";
        }
        return js;
    }

}

