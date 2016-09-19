package com.xinglefly.module.skill;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.xinglefly.BaseFragment;
import com.xinglefly.R;
import com.xinglefly.adapter.DevelopAdapter;
import com.xinglefly.entity.DeveloperInfo;
import com.xinglefly.http.HttpMethods;
import com.xinglefly.util.LogUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;


public class DeveloperFragment extends BaseFragment {

    @BindView(R.id.tv_page) TextView tvPage;
    @BindView(R.id.btn_previous) AppCompatButton btnPrevious;
    @BindView(R.id.btn_next) AppCompatButton btnNext;
    @BindView(R.id.listview) ListView listView;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;

    private DevelopAdapter mAdapter;
    private int page = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_developer, container, false);
        ButterKnife.bind(this, view);

        mAdapter = new DevelopAdapter(getActivity());
        listView.setAdapter(mAdapter);

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
        /*subscription = Network.getDeveloperApi()
                .getToArtciles()
                .map(DevelopeDataMapper.getInstance())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);*/
        HttpMethods.getInstance().getDevelopInfo(subscribe);
    }



    Subscriber<DeveloperInfo> subscribe = new Subscriber<DeveloperInfo>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            swipeRefreshLayout.setRefreshing(false);
            LogUtil.e("err: %s",e.toString());
        }

        @Override
        public void onNext(DeveloperInfo info) {
            swipeRefreshLayout.setRefreshing(false);
            mAdapter.addData(info.getArticles());
        }
    };


}