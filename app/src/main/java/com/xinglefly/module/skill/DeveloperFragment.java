package com.xinglefly.module.skill;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.xinglefly.BaseFragment;
import com.xinglefly.R;
import com.xinglefly.adapter.DevelopAdapter;
import com.xinglefly.entity.Article;
import com.xinglefly.entity.DeveloperInfo;
import com.xinglefly.module.skill.presenter.DevelopPresenter;
import com.xinglefly.module.widget.SubPageDetailActivity;
import com.xinglefly.util.LogUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import rx.Subscriber;


public class DeveloperFragment extends BaseFragment {

    @BindView(R.id.tv_page) TextView tvPage;
    @BindView(R.id.btn_previous) AppCompatButton btnPrevious;
    @BindView(R.id.btn_next) AppCompatButton btnNext;
    @BindView(R.id.listview) ListView listView;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;

    private DevelopAdapter mAdapter;
    private DevelopPresenter presenter;
    private int page = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_developer, container, false);
        ButterKnife.bind(this, view);

        presenter = new DevelopPresenter(this);

        mAdapter = new DevelopAdapter(getActivity());
        listView.setAdapter(mAdapter);

        swipeRefreshLayout.setColorSchemeColors(Color.BLUE,Color.RED,Color.GREEN,Color.YELLOW);
        swipeRefreshLayout.setEnabled(false);
        return view;
    }

    @OnItemClick(R.id.listview)
    void onItemClick(AdapterView<?> adapterView,int position){
        Article article = (Article) adapterView.getAdapter().getItem(position);
        if (article!=null)
            startActivity(new Intent(getActivity(), SubPageDetailActivity.class)
                    .putExtra("url", article.getOriginal_url())
                    .putExtra("title",article.getOriginal_site_name())
                    .putExtra("sharetitle",""));
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
        presenter.getDevelopInfo(subscribe);
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