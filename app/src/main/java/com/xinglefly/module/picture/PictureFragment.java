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
import android.widget.TextView;
import com.xinglefly.BaseFragment;
import com.xinglefly.R;
import com.xinglefly.adapter.ItemListAdapter;
import com.xinglefly.entity.PictureItem;
import com.xinglefly.module.picture.prensenter.PicturePresenter;
import com.xinglefly.util.LogUtil;
import com.xinglefly.util.ToastUtil;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;


public class PictureFragment extends BaseFragment {

    @BindView(R.id.tv_page) TextView tvPage;
    @BindView(R.id.btn_previous) AppCompatButton btnPrevious;
    @BindView(R.id.btn_next) AppCompatButton btnNext;
    @BindView(R.id.rv_grid) RecyclerView rvGrid;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;

    private PicturePresenter picturePresenter;
    private ItemListAdapter adapter;
    private int page = 0;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this, view);

        picturePresenter = new PicturePresenter(this);
        adapter = new ItemListAdapter();

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
        picturePresenter.getPictrueInfo(page,subscriber);
    }

    Subscriber<List<PictureItem>> subscriber = new Subscriber<List<PictureItem>>() {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            swipeRefreshLayout.setRefreshing(false);
            ToastUtil.showToast(e.getMessage());
        }

        @Override
        public void onNext(List<PictureItem> mapItems) {
            swipeRefreshLayout.setRefreshing(false);
            tvPage.setText(getString(R.string.page_with_number,page));
            adapter.setImages(mapItems);
        }
    };

}