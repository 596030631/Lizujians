package com.lizujian.qrcode.view.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lizujian.qrcode.APP;
import com.lizujian.qrcode.R;
import com.lizujian.qrcode.base.v.BaseFragment;
import com.lizujian.qrcode.bean.MilkInfo;
import com.lizujian.qrcode.dialog.SelfDialog;
import com.lizujian.qrcode.sql.PreferencesService;
import com.lizujian.qrcode.sql.action.SelectRecord;
import com.lizujian.qrcode.view.MainActivity;
import com.lizujian.qrcode.util.makerqrcode.QrCodeUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainFragmentPage2 extends BaseFragment<MainActivity> implements View.OnClickListener {

    protected final Context mContext = MainFragmentPage2.this.getContext();
    public final String TAG = "Page2";
    List<EditText> list_text;
    private MilkInfo milkInfo;
    @Override
    protected int getLayout() {
        return R.layout.fragment_main_page2;
    }

    @BindView(R.id.qrcode)
    protected ImageView qrcode;

    @BindView(R.id.btn_make_qrcode)
    protected TextView btn_make_qrcode;

    @BindView(R.id.batchnumber)
    protected EditText batchNumber;

    @BindView(R.id.one)
    protected TextView btn_1;

    @BindView(R.id.twe)
    protected TextView btn_2;

    @BindView(R.id.three)
    protected TextView btn_3;

    @BindView(R.id.fore)
    protected TextView btn_4;

    @Override
    protected void initView(View v) {

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_make_qrcode.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        PreferencesService pf = APP.getPreferencesService();
        pf.save("batchNumber",batchNumber.getText().toString());
        Log.e("TAG",batchNumber.getText().toString());
        switch (v.getId()) {
            case R.id.one:
                   final SelfDialog dialog1 = new SelfDialog(getContext(),1);
                   dialog1.setYesOnclickListener("确定", new SelfDialog.onYesOnclickListener() {
                       @Override
                       public void onYesClick() {

                           dialog1.dismiss();
                       }
                   });

                   dialog1.setNoOnclickListener("取消", new SelfDialog.onNoOnclickListener() {
                       @Override
                       public void onNoClick() {

                           dialog1.dismiss();
                       }
                   });
                   if(!batchNumber.getText().toString().isEmpty() ) {
                       dialog1.show();
                   }else {
                       Toast.makeText(this.getContext(), "未输入批次号！", Toast.LENGTH_SHORT).show();
                   }

                break;

                case R.id.twe:
                    final SelfDialog dialog2 = new SelfDialog(getContext(),2);
                    dialog2.setYesOnclickListener("确定", new SelfDialog.onYesOnclickListener() {
                        @Override
                        public void onYesClick() {
                            dialog2.dismiss();
                        }
                    });

                    dialog2.setNoOnclickListener("取消", new SelfDialog.onNoOnclickListener() {
                        @Override
                        public void onNoClick() {

                            dialog2.dismiss();
                        }
                    });

                    if(!batchNumber.getText().toString().isEmpty() ) {
                        dialog2.show();
                    }else {
                        Toast.makeText(this.getContext(), "batchNumber is empty！", Toast.LENGTH_SHORT).show();
                    }
                break;

                case R.id.three:
                    final SelfDialog dialog3 = new SelfDialog(getContext(),3);
                    dialog3.setYesOnclickListener("确定", new SelfDialog.onYesOnclickListener() {
                        @Override
                        public void onYesClick() {

                            dialog3.dismiss();
                        }
                    });

                    dialog3.setNoOnclickListener("取消", new SelfDialog.onNoOnclickListener() {
                        @Override
                        public void onNoClick() {

                            dialog3.dismiss();
                        }
                    });

                    if(!batchNumber.getText().toString().isEmpty() ) {
                        dialog3.show();
                    }else {
                        Toast.makeText(this.getContext(), "batchNumber is empty！", Toast.LENGTH_SHORT).show();
                    }
                break;

                case R.id.fore:
                    final SelfDialog dialog4 = new SelfDialog(getContext(),4);
                    dialog4.setYesOnclickListener("确定", new SelfDialog.onYesOnclickListener() {
                        @Override
                        public void onYesClick() {

                            dialog4.dismiss();
                        }
                    });

                    dialog4.setNoOnclickListener("取消", new SelfDialog.onNoOnclickListener() {
                        @Override
                        public void onNoClick() {

                            dialog4.dismiss();
                        }
                    });

                    if(!batchNumber.getText().toString().isEmpty() ) {
                        dialog4.show();
                    }else {
                        Toast.makeText(this.getContext(), "batchNumber is empty！", Toast.LENGTH_SHORT).show();
                    }
                break;

            case R.id.btn_make_qrcode:

                List<MilkInfo> mList = getDataFromSql();
                String info =
                        mList.get(mList.size()-1).getT1().getLyfs()+","       +mList.get(mList.size()-1).getT1().getNnzk()+","    +mList.get(mList.size()-1).getT1().getCzy()+","+
                        mList.get(mList.size()-1).getT2().getJgcs()+","       +mList.get(mList.size()-1).getT2().getJgzq()+","    +mList.get(mList.size()-1).getT2().getGlbz()+","     +mList.get(mList.size()-1).getT2().getSjfs()+","+
                        mList.get(mList.size()-1).getT3().getYsy()+","        +mList.get(mList.size()-1).getT3().getCph()+","     +mList.get(mList.size()-1).getT3().getCnwd()+","+
                        mList.get(mList.size()-1).getT4().getXsfs()+","       +mList.get(mList.size()-1).getT4().getBzrq()+","    +mList.get(mList.size()-1).getT4().getLsjg();

                Log.e("TAG",info);
                //生成二维码
                Bitmap bitmap = QrCodeUtil.createQRCodeBitmap(info,600,600);
                qrcode.setImageBitmap(bitmap);
                break;
        }
    }

    private List<MilkInfo> getDataFromSql(){
        List<MilkInfo.T1Bean> list1 = new ArrayList<>();
        List<MilkInfo.T2Bean> list2 = new ArrayList<>();
        List<MilkInfo.T3Bean> list3 = new ArrayList<>();
        List<MilkInfo.T4Bean> list4 = new ArrayList<>();

        List<MilkInfo> list = new ArrayList<>();
        //从数据库里拿数据
        list1 = SelectRecord.selectT1(this.getContext(),list1);
        list2 = SelectRecord.selectT2(this.getContext(),list2);
        list3 = SelectRecord.selectT3(this.getContext(),list3);
        list4 = SelectRecord.selectT4(this.getContext(),list4);

        for (int i = 0; i < list1.size(); i++) {
            list.add(new MilkInfo());
            list.get(i).setT1(list1.get(i));
            list.get(i).setT2(list2.get(i));
            list.get(i).setT3(list3.get(i));
            list.get(i).setT4(list4.get(i));
        }
        return list;
    }
}
