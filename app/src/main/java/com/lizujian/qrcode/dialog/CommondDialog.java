package com.lizujian.qrcode.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lizujian.qrcode.R;
public class CommondDialog extends Dialog implements View.OnClickListener{
    private TextView contentTxt;
    private TextView titleTxt;
    private TextView submitTxt;
    private TextView cancelTxt;

    private Context mContext;
    private String content;
    private OnCloseListener listener;
    private String positiveName;
    private String negativeName;
    private String title;
    private Boolean Insert = true;

    public CommondDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public CommondDialog(Context context, int themeResId, String content) {
        super(context, themeResId);
        this.mContext = context;
        this.content = content;
    }

    public CommondDialog(Context context, int themeResId, String content, OnCloseListener listener) {
        super(context, themeResId);
        this.mContext = context;
        this.content = content;
        this.listener = listener;
    }

    public CommondDialog(Context context, int themeResId, String content,Boolean noInsert, OnCloseListener listener) {
        super(context, themeResId);
        this.mContext = context;
        this.content = content;
        this.listener = listener;
        this.Insert = noInsert;
    }

    protected CommondDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mContext = context;
    }

    public CommondDialog setTitle(String title){
        this.title = title;
        return this;
    }

    public CommondDialog setPositiveButton(String name){
        this.positiveName = name;
        return this;
    }

    public CommondDialog setNegativeButton(String name){
        this.negativeName = name;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_commom);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView(){
        //将扫描结果加密的数据保存到数据库
        if(Insert){

            Log.e("TAG","插入数据："+content);
        }
//        //解码
//        try {
//            Log.e("TAG",content);
//            content = new String(Base64.decode(content,Base64.NO_WRAP),"utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        String[] result = content.split(",");
        //contentTxt = (TextView)findViewById(R.id.content);
        TextView xnly = findViewById(R.id.dialog_text_xnly);
        TextView nnzk = findViewById(R.id.dialog_text_nnzk);
        TextView czy = findViewById(R.id.dialog_text_czy);

        TextView jgcs = findViewById(R.id.dialog_text_jgcs);
        TextView jgzq = findViewById(R.id.dialog_text_jgzq);
        TextView glbz = findViewById(R.id.dialog_text_glbz);
        TextView sjfs = findViewById(R.id.dialog_text_sjfs);

        TextView ysy = findViewById(R.id.dialog_ysy);
        TextView cph = findViewById(R.id.dialog_text_cph);
        TextView cnwd = findViewById(R.id.dialog_text_cnwd);

        TextView xsfs = findViewById(R.id.dialog_text_xsfs);
        TextView bzrq = findViewById(R.id.dialog_text_bzrq);
        TextView lsjg = findViewById(R.id.dialog_text_lsjg);

        xnly.setText("鲜奶来源："+result[0]);
        nnzk.setText("奶牛状况："+result[1]);
        czy.setText("操  作  员："+result[2]);

        jgcs.setText("加工厂商："+result[3]);
        jgzq.setText("加工周期："+result[4]);
        glbz.setText("过滤标准："+result[5]);
        sjfs.setText("杀菌方式："+result[6]);

        ysy.setText("运  输  员："+result[7]);
        cph.setText("车  牌  号："+result[8]);
        cnwd.setText("车内温度："+result[9]);

        xsfs.setText("销售方式："+result[10]);
        bzrq.setText("保质日期："+result[11]);
        lsjg.setText("零售价格："+result[12]);

        titleTxt = (TextView)findViewById(R.id.title);
        submitTxt = (TextView)findViewById(R.id.submit);
        submitTxt.setOnClickListener(this);
        cancelTxt = (TextView)findViewById(R.id.cancel);
        cancelTxt.setOnClickListener(this);
        //contentTxt.setText(content);
        if(!TextUtils.isEmpty(positiveName)){
            submitTxt.setText(positiveName);
        }

        if(!TextUtils.isEmpty(negativeName)){
            cancelTxt.setText(negativeName);
        }

        if(!TextUtils.isEmpty(title)){
            titleTxt.setText(title);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel:
                if(listener != null){
                    listener.onClick(this, false);
                }
                this.dismiss();
                break;
            case R.id.submit:
                if(listener != null){
                    listener.onClick(this, true);
                }
                break;
        }
    }

    public interface OnCloseListener{
        void onClick(Dialog dialog, boolean confirm);
    }
}


