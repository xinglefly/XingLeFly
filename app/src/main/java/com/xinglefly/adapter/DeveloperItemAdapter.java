package com.xinglefly.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.entity.Article;
import com.xinglefly.util.LogUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@Deprecated
public class DeveloperItemAdapter extends RecyclerView.Adapter {

    private List<Article> items;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.technology_item, parent, false);
        return new BindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BindViewHolder viewHolder = (BindViewHolder) holder;
        Article item = items.get(position);
        LogUtil.Object(item);
//        viewHolder.tvTitle.setText(item.getDescription());
//        Picasso.with(holder.itemView.getContext()).load(item.getImage()).into(viewHolder.imgIcon);
    }

    public void setData(List<Article> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items == null ? 0: items.size();
    }

    static class BindViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_icon) ImageView imgIcon;
        @BindView(R.id.tv_title) TextView tvTitle;

        public BindViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}