package com.xinglefly.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.xinglefly.R;
import com.xinglefly.entity.TestItem;
import com.xinglefly.util.LogUtil;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TestItemListAdapter extends RecyclerView.Adapter {

    private List<TestItem> images;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new BindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BindViewHolder viewHolder = (BindViewHolder) holder;
        TestItem mapItem = images.get(position);
        LogUtil.Object(mapItem);
        viewHolder.descriptionTv.setText(mapItem.description);
        Glide.with(holder.itemView.getContext()).load(mapItem.image_url).into(viewHolder.imageIv);
    }

    public void setImages(List<TestItem> images) {
        this.images = images;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return images == null ? 0: images.size();
    }

    static class BindViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageIv) ImageView imageIv;
        @BindView(R.id.descriptionTv) TextView descriptionTv;

        public BindViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}