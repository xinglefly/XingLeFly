package com.xinglefly.module.test;

import android.graphics.Color;
import android.graphics.Picture;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xinglefly.BaseFragment;
import com.xinglefly.R;
import com.xinglefly.adapter.ItemListAdapter;
import com.xinglefly.model.PictureItem;
import com.xinglefly.network.Network;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TestFragment extends BaseFragment{

    @BindView(R.id.tv_page) TextView tvPage;
    @BindView(R.id.rv_grid) RecyclerView rvGrid;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;

    private ItemListAdapter adapter = new ItemListAdapter();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        ButterKnife.bind(this, view);

        rvGrid.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rvGrid.setAdapter(adapter);

        swipeRefreshLayout.setColorSchemeColors(Color.BLUE,Color.RED,Color.GREEN,Color.YELLOW);
        swipeRefreshLayout.setEnabled(false);

        return view;
    }

    @OnClick(R.id.btn_load)
    void loadData(){
        swipeRefreshLayout.setRefreshing(true);
        subscription = Network.getTestApi()
                .search("装逼")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    Observer<List<PictureItem>> observer = new Observer<List<PictureItem>>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            swipeRefreshLayout.setRefreshing(false);
        }

        @Override
        public void onNext(List<PictureItem> pictureItems) {
            swipeRefreshLayout.setRefreshing(false);
            adapter.setImages(pictureItems);
        }
    };



}