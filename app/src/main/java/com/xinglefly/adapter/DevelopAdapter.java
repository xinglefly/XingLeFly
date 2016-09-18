package com.xinglefly.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xinglefly.R;
import com.xinglefly.model.DeveloperItem;
import com.xinglefly.util.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class DevelopAdapter extends BaseAdapter {

    private Context context;
    private List<DeveloperItem> data;

    public DevelopAdapter(Context context) {
        this.context = context;
    }

    public void addData(List<DeveloperItem> list) {
        if (data == null)
            data = new ArrayList();
        data.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.develop_item, parent, false);

        ImageView imgRight = ViewHolder.get(convertView, R.id.pic_imageview);
        TextView tvTitle = ViewHolder.get(convertView, R.id.tv_title);
        TextView tvTime = ViewHolder.get(convertView, R.id.tv_date);

        DeveloperItem model = data.get(position);

        if (!TextUtils.isEmpty(model.getSubject().getImage()))
            Picasso.with(context).load(model.getSubject().getImage()).into(imgRight);

        tvTitle.setText(model.getTitle());
        tvTime.setText(model.getCreated_at()+"");

        return convertView;
    }

}
