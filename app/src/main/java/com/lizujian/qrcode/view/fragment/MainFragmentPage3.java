package com.lizujian.qrcode.view.fragment;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.lizujian.qrcode.APP;
import com.lizujian.qrcode.R;
import com.lizujian.qrcode.adapter.AdapterForRecyView;
import com.lizujian.qrcode.base.v.BaseFragment;
import com.lizujian.qrcode.bean.MilkInfo;
import com.lizujian.qrcode.sql.action.SelectRecord;
import com.lizujian.qrcode.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainFragmentPage3 extends BaseFragment<MainActivity> {
    protected Context mContext;
    @BindView(R.id.recycler)
    protected RecyclerView mRecyclerView;
    @BindView(R.id.fresh)
    protected SwipeRefreshLayout swipeRefreshLayout;
    private List<MilkInfo> mList;

    private List<MilkInfo.T1Bean> list1;
    private List<MilkInfo.T2Bean> list2;
    private List<MilkInfo.T3Bean> list3;
    private List<MilkInfo.T4Bean> list4;

    @Override
    protected int getLayout() {
        return R.layout.fragment_main_page3;
    }

    @Override
    protected void initView(View v) {
        mContext = this.getContext();
        mList = new ArrayList<>();

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();

        getDataFromSql();

        final AdapterForRecyView adapter = new AdapterForRecyView(this.getContext(), mList);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter.setOnItemClickListener(new AdapterForRecyView.ItemOnClickListence() {

            @Override
            public void itemClick(int position) {
                Log.e("TAG","点击了"+position);

            }
        });
        //下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mList.clear();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        getActivity().runOnUiThread(new Runnable(){
                            @Override
                            public void run() {
                                getDataFromSql();
                                APP.getPreferencesService().save("counts",mList.size()+"");
                                swipeRefreshLayout.setRefreshing(false);
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                }).start();
            }
        });
    }

    private void getDataFromSql(){
        list1.clear();
        list2.clear();
        list3.clear();
        list4.clear();
        //从数据库里拿数据
        list1 = SelectRecord.selectT1(mContext,list1);
        list2 = SelectRecord.selectT2(mContext,list2);
        list3 = SelectRecord.selectT3(mContext,list3);
        list4 = SelectRecord.selectT4(mContext,list4);

        for (int i = 0; i < list1.size(); i++) {
            mList.add(new MilkInfo());
            mList.get(i).setT1(list1.get(i));
            mList.get(i).setT2(list2.get(i));
            mList.get(i).setT3(list3.get(i));
            mList.get(i).setT4(list4.get(i));
        }
    }
}
