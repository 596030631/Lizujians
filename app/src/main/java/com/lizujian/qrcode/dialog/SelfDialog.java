package com.lizujian.qrcode.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lizujian.qrcode.APP;
import com.lizujian.qrcode.R;
import com.lizujian.qrcode.sql.PreferencesService;
import com.lizujian.qrcode.sql.action.InsetRecord;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 */
public class SelfDialog extends Dialog {

    private Button yes;//确定按钮
    private Button no;//取消按钮
    private TextView titleTv;//消息标题文本
    private TextView messageTv;//消息提示文本
    private String titleStr;//从外界设置的title文本
    private String messageStr;//从外界设置的消息文本
    //确定文本和取消文本的显示内容
    private String yesStr, noStr;

    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;//确定按钮被点击了的监听器
    private  int mIndex;

    @BindView(R.id.lyfs)
    protected EditText lyfs;
    @BindView(R.id.nnzk)
    protected EditText nnzk;
    @BindView(R.id.czy)
    protected EditText czy;


    @BindView(R.id.jgcs)
    protected EditText jgcs;
    @BindView(R.id.jgzq)
    protected EditText jgzq;
    @BindView(R.id.glbz)
    protected EditText glbz;
    @BindView(R.id.sjfs)
    protected EditText sjfs;


    @BindView(R.id.ysy)
    protected EditText ysy;
    @BindView(R.id.cph)
    protected EditText cph;
    @BindView(R.id.cnwd)
    protected EditText cnwd;


    @BindView(R.id.xsfs)
    protected EditText xsfs;
    @BindView(R.id.bzrq)
    protected EditText bzrq;
    @BindView(R.id.lsjg)
    protected EditText lsjg;
    @BindView(R.id.batch)
    protected TextView batch;

    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();
    private List<String> list3 = new ArrayList<>();
    private List<String> list4 = new ArrayList<>();

    private List<String> mList;
    private final Context mContext;
    private Boolean show = false;
    private String batchNumbers;

    /**
     * 设置取消按钮的显示内容和监听
     *
     * @param str
     * @param onNoOnclickListener
     */
    public void setNoOnclickListener(String str, onNoOnclickListener onNoOnclickListener) {
        if (str != null) {
            noStr = str;
        }
        this.noOnclickListener = onNoOnclickListener;
    }

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param str
     * @param onYesOnclickListener
     */
    public void setYesOnclickListener(String str, onYesOnclickListener onYesOnclickListener) {
        if (str != null) {
            yesStr = str;
        }
        this.yesOnclickListener = onYesOnclickListener;
    }

    public SelfDialog(Context context,int index) {
        super(context, R.style.MyDialog);
        mIndex = index;
        mContext = context;
    }

    public SelfDialog(Context context,int index,List<String> list) {
        super(context, R.style.MyDialog);
        mIndex = index;
        mContext = context;
        mList = list;
        show = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_frag2_1);
        getBatchNumber();
        layout(mIndex);
        initView();

        if(show){
            switch (mIndex) {
                case 1:
                    lyfs.setText(mList.get(0));
                    nnzk.setText(mList.get(1));
                    czy.setText(mList.get(2));
                    //batch.setText(mList.get(3));
                    show = false;
                    break;
                case 2:
                    jgcs.setText(mList.get(0));
                    jgzq.setText(mList.get(1));
                    glbz.setText(mList.get(2));
                    sjfs.setText(mList.get(3));
                    //batch.setText(mList.get(4));
                    show = false;
                    break;
                case 3:
                    ysy.setText(mList.get(0));
                    cph.setText(mList.get(1));
                    cnwd.setText(mList.get(2));
                    //batch.setText(mList.get(3));
                    show = false;
                    break;
                case 4:
                    xsfs.setText(mList.get(0));
                    bzrq.setText(mList.get(1));
                    lsjg.setText(mList.get(2));
                    //batch.setText(mList.get(3));
                    show = false;
                    break;
            }
        }else {

            if(batch != null && !batchNumbers.isEmpty()){
                batch.setText(batchNumbers);
            }else {
                batch = findViewById(R.id.batch);
                getBatchNumber();
                batch.setText(batchNumbers);
            }

        }
        //按空白处能取消动画
        setCanceledOnTouchOutside(true);
        //初始化界面控件
        initView();
        //初始化界面数据
        initData();
        //初始化界面控件的事件
        initEvent();
    }
    private void getBatchNumber() {
        PreferencesService pf = APP.getPreferencesService();
        batchNumbers = pf.getValue("batchNumber","1");
    }
    /**
     * 初始化界面的确定和取消监听器
     */
    private void initEvent() {
        //设置确定按钮被点击后，向外界提供监听
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layout(mIndex);

                if(show){
                    //不执行操作
                }else {
                    //存储数据
                    switch (mIndex) {
                        case 1:
                            clear();
                            list1.add(lyfs.getText().toString());
                            list1.add(nnzk.getText().toString());
                            list1.add(czy.getText().toString());
                            list1.add(batchNumbers);
                            InsetRecord.insertT1(mContext,list1);
                            break;

                        case 2:
                            clear();
                            list2.add(jgcs.getText().toString());
                            list2.add(jgzq.getText().toString());
                            list2.add(glbz.getText().toString());
                            list2.add(sjfs.getText().toString());
                            list2.add(batchNumbers);
                            InsetRecord.insertT2(mContext,list2);
                            break;

                        case 3:
                            clear();
                            list3.add(ysy.getText().toString());
                            list3.add(cph.getText().toString());
                            list3.add(cnwd.getText().toString());
                            list3.add(batchNumbers);
                            InsetRecord.insertT3(mContext,list3);
                            break;

                        case 4:
                            clear();
                            list4.add(xsfs.getText().toString());
                            list4.add(bzrq.getText().toString());
                            list4.add(lsjg.getText().toString());
                            list4.add(batchNumbers);
                            InsetRecord.insertT4(mContext,list4);
                            break;
                    }
                }

                if (yesOnclickListener != null) {
                    yesOnclickListener.onYesClick();
                }
            }
        });
        //设置取消按钮被点击后，向外界提供监听
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (noOnclickListener != null) {
                    noOnclickListener.onNoClick();
                }
            }
        });
    }

    private void clear(){
        list1.clear();
        list2.clear();
        list3.clear();
        list4.clear();
    }

    private void layout(int l){
        LinearLayout l1 = findViewById(R.id.layout1);
        LinearLayout l2 = findViewById(R.id.layout2);
        LinearLayout l3 = findViewById(R.id.layout3);
        LinearLayout l4 = findViewById(R.id.layout4);
        l1.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);

        switch (l){
            case 1:
                l1.setVisibility(View.VISIBLE);
                break;
            case 2:
                l2.setVisibility(View.VISIBLE);
                break;
            case 3:
                l3.setVisibility(View.VISIBLE);
                break;
            case 4:
                l4.setVisibility(View.VISIBLE);
                break;
        }
    }
    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        //如果用户自定了title和message
        if (titleStr != null) {
            titleTv.setText(titleStr);
        }
        if (messageStr != null) {
            messageTv.setText(messageStr);
        }
        //如果设置按钮的文字
        if (yesStr != null) {
            yes.setText(yesStr);
        }
        if (noStr != null) {
            no.setText(noStr);
        }
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        yes = (Button) findViewById(R.id.yes);
        no = (Button) findViewById(R.id.no);
        titleTv = (TextView) findViewById(R.id.title);
        messageTv = (TextView) findViewById(R.id.message);

        switch (mIndex){
            case 1:
                lyfs = findViewById(R.id.lyfs);
                nnzk = findViewById(R.id.nnzk);
                czy = findViewById(R.id.czy);
                batch = findViewById(R.id.batch);
                break;

            case 2:
                jgcs = findViewById(R.id.jgcs);
                jgzq = findViewById(R.id.jgzq);
                glbz = findViewById(R.id.glbz);
                sjfs = findViewById(R.id.sjfs);
                batch = findViewById(R.id.batch);

                break;

            case 3:
                ysy = findViewById(R.id.ysy);
                cph = findViewById(R.id.cph);
                cnwd = findViewById(R.id.cnwd);
                batch = findViewById(R.id.batch);
                break;
            case 4:
                xsfs = findViewById(R.id.xsfs);
                bzrq = findViewById(R.id.bzrq);
                lsjg = findViewById(R.id.lsjg);
                batch = findViewById(R.id.batch);
                break;
        }

    }

    /**
     * 从外界Activity为Dialog设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        titleStr = title;
    }

    /**
     * 从外界Activity为Dialog设置dialog的message
     *
     * @param message
     */
    public void setMessage(String message) {
        messageStr = message;
    }

    /**
     * 设置确定按钮和取消被点击的接口
     */
    public interface onYesOnclickListener {
         void onYesClick();
    }

    public interface onNoOnclickListener {
         void onNoClick();
    }
}