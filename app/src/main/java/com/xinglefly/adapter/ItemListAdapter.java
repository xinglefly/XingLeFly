package com.xinglefly.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.xinglefly.R;
import com.xinglefly.model.PictureItem;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemListAdapter extends RecyclerView.Adapter {

    private List<PictureItem> images;

    public void setImages(List<PictureItem> images) {
        this.images = images;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new BindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BindViewHolder viewHolder = (BindViewHolder) holder;
        PictureItem mapItem = images.get(position);
        viewHolder.descriptionTv.setText(mapItem.description);
//        Glide.with(holder.itemView.getContext()).load(mapItem.imageUrl).placeholder(R.mipmap.ic_launcher).crossFade().into(viewHolder.imageIv);
        Picasso.with(holder.itemView.getContext()).load(mapItem.imageUrl).into(viewHolder.imageIv);
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