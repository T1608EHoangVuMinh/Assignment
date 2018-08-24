package com.example.hoangminhk4b.dwsj_banking.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hoangminhk4b.dwsj_banking.R;
import com.example.hoangminhk4b.dwsj_banking.Utils.utils;
import com.example.hoangminhk4b.dwsj_banking.models.ResultHistoryModel;

import java.util.List;

public class HistoryAdapter extends BaseAdapter {
    private Activity activity;
    private List<ResultHistoryModel> data;
    View convertView;
    @Override
    public int getCount() {
        return data.size();
    }

    public HistoryAdapter(Activity activity, List<ResultHistoryModel> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView ==null){
            convertView= LayoutInflater.from(activity).inflate(R.layout.item_history,parent,false);
            HistoryViewHolder historyViewHolder=new HistoryViewHolder();
            historyViewHolder.tvUsername=convertView.findViewById(R.id.tvUsername);
            historyViewHolder.tvNgayGD=convertView.findViewById(R.id.tvNgayGD);
            historyViewHolder.tvPhi=convertView.findViewById(R.id.tvPhi);
            historyViewHolder.tvSoTien=convertView.findViewById(R.id.tvSoTien);

            convertView.setTag(historyViewHolder);
        }
        HistoryViewHolder historyViewHolder= (HistoryViewHolder) convertView.getTag();
        historyViewHolder.tvUsername.setText(data.get(position).getUsername());
        String date= utils.convertTimestampToDate(Integer.parseInt(data.get(position).getNgayGD()));
        historyViewHolder.tvNgayGD.setText(date);
        historyViewHolder.tvSoTien.setText(data.get(position).getSoTien());
        historyViewHolder.tvPhi.setText(data.get(position).getPhiGD()+"");

        return convertView;
    }
    public class HistoryViewHolder{
        TextView tvUsername;
        TextView tvNgayGD;
        TextView tvSoTien;
        TextView tvPhi;
    }
}
