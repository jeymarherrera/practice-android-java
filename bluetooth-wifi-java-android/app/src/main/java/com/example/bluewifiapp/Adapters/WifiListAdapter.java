package com.example.bluewifiapp.Adapters;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bluewifiapp.R;

import java.util.List;

public class WifiListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    List<ScanResult> wifiList;

    public WifiListAdapter(Context context, List wifiList) {
        this.context = context;
        this.wifiList = wifiList;

        inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return wifiList.size();
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
        Holder holder;
        View view = convertView;

        if (view == null){
            view = inflater.inflate(R.layout.wifi_template, null);
            holder = new Holder();

            holder.tvDetails = (TextView) view.findViewById(R.id.txtWifiName);
            view.setTag(holder);
        }else {
            holder = (Holder)view.getTag();
        }

        holder.tvDetails.setText(wifiList.get(position).SSID);

        return view;
    }

    class Holder {
        TextView tvDetails;
    }
}
