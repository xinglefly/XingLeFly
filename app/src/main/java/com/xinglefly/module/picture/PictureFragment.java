package com.xinglefly.module.picture;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.xinglefly.BaseFragment;
import com.xinglefly.R;
import com.xinglefly.adapter.ItemListAdapter;
import com.xinglefly.event.NetWorkEvent;
import com.xinglefly.model.PictureItem;
import com.xinglefly.network.Network;
import com.xinglefly.util.GankBeautyResultToItemsMapper;
import com.xinglefly.util.LogUtil;
import com.xinglefly.util.ToastUtil;
import org.greenrobot.eventbus.Subscribe;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class PictureFragment extends BaseFragment {

    @BindView(R.id.tv_page) TextView tvPage;
    @BindView(R.id.btn_previous) AppCompatButton btnPrevious;
    @BindView(R.id.btn_next) AppCompatButton btnNext;
    @BindView(R.id.rv_grid) RecyclerView rvGrid;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.net_err) ViewStub netErr;

    private ItemListAdapter adapter = new ItemListAdapter();
    private int page = 0;

    Observer<List<PictureItem>> observer = new Observer<List<PictureItem>>() {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            swipeRefreshLayout.setRefreshing(false);
            ToastUtil.showToast(e.getMessage());
            LogUtil.e("%s",e.getMessage());
        }

        @Override
        public void onNext(List<PictureItem> mapItems) {
            swipeRefreshLayout.setRefreshing(false);
            tvPage.setText(getString(R.string.page_with_number,page));
            adapter.setImages(mapItems);
            LogUtil.d("%d",mapItems.size());
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this, view);

        rvGrid.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rvGrid.setAdapter(adapter);

        swipeRefreshLayout.setColorSchemeColors(Color.BLUE,Color.RED,Color.GREEN,Color.YELLOW);
        swipeRefreshLayout.setEnabled(false);

        return view;
    }


    @OnClick({R.id.btn_previous,R.id.btn_next})
    void onClick(View view){
        switch(view.getId()){
            case R.id.btn_previous:
                loadPage(--page);
                if (page==1) btnPrevious.setEnabled(false);
                break;
            case R.id.btn_next:
                loadPage(++page);
                if (page==2) btnPrevious.setEnabled(true);
                break;
        }
    }

    private void loadPage(int page) {
        swipeRefreshLayout.setRefreshing(true);
        subscription = Network.getGankApi()
                .getBeauties(10,page)
                .map(GankBeautyResultToItemsMapper.getInstance())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    @Subscribe
    public void showNetErr(NetWorkEvent event){
        if (event.isNetwork()) netErr.setVisibility(View.GONE);
        else netErr.setVisibility(View.VISIBLE);
    }

}