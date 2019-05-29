package com.lizujian.qrcode.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lizujian.qrcode.R;
import com.lizujian.qrcode.bean.MilkInfo;
import com.lizujian.qrcode.dialog.SelfDialog;

import java.util.ArrayList;
import java.util.List;

public class AdapterForRecyView extends RecyclerView.Adapter<AdapterForRecyView.MyAdapter> {
    private List<MilkInfo> mList;
    private Context mContext;
    public AdapterForRecyView(Context context,List list){
        mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new MyAdapter(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull final MyAdapter myAdapter, final int i) {
        myAdapter.index.setText("第"+(i+1)+"条");
        myAdapter.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "1", Toast.LENGTH_SHORT).show();
                List<String> s = new ArrayList<>();
                s.add(mList.get(i).getT1().getLyfs());
                s.add(mList.get(i).getT1().getNnzk());
                s.add(mList.get(i).getT1().getCzy());
                s.add(mList.get(i).getT1().getBatch());
                new SelfDialog(mContext,1,s).show();
            }
        });
        myAdapter.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> s = new ArrayList<>();
                s.add(mList.get(i).getT2().getJgcs());
                s.add(mList.get(i).getT2().getJgzq());
                s.add(mList.get(i).getT2().getGlbz());
                s.add(mList.get(i).getT2().getBatch());
                new SelfDialog(mContext,2,s).show();
            }
        });
        myAdapter.bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> s = new ArrayList<>();
                s.add(mList.get(i).getT3().getYsy());
                s.add(mList.get(i).getT3().getCph());
                s.add(mList.get(i).getT3().getCnwd());
                s.add(mList.get(i).getT3().getBatch());
                new SelfDialog(mContext,3,s).show();
            }
        });
        myAdapter.bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> s = new ArrayList<>();
                s.add(mList.get(i).getT4().getXsfs());
                s.add(mList.get(i).getT4().getBzrq());
                s.add(mList.get(i).getT4().getLsjg());
                s.add(mList.get(i).getT4().getBatch());
                new SelfDialog(mContext,4,s).show();
            }
        });

        myAdapter.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemOnClickListence.itemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class MyAdapter extends RecyclerView.ViewHolder {

        private TextView bt1;
        private TextView bt2;
        private TextView bt3;
        private TextView bt4;
        private TextView index;

        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            bt1 = itemView.findViewById(R.id.onebtn);
            bt2 = itemView.findViewById(R.id.twebtn);
            bt3 = itemView.findViewById(R.id.threebtn);
            bt4 = itemView.findViewById(R.id.forebtn);
            index = itemView.findViewById(R.id.index);
        }
    }
    public ItemOnClickListence itemOnClickListence;
    public interface ItemOnClickListence { void itemClick(int position);}

    public void setOnItemClickListener(ItemOnClickListence listener){
        this.itemOnClickListence = listener;
    }
}
