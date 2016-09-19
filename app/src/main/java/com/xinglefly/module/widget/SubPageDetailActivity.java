package com.xinglefly.module.widget;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.xinglefly.BaseActivity;
import com.xinglefly.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubPageDetailActivity extends BaseActivity{

    @BindView(R.id.webview) WebView webView;
    private LoadViewHelper helper;
    private String title = "";
    private String sharetitles = "";
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        ButterKnife.bind(this);
        getIntentVal();
        initView();
        WebviewConfig();
    }

    private void getIntentVal() {
        title = getIntent().getStringExtra("title");
        url = getIntent().getStringExtra("url");
        sharetitles = getIntent().getStringExtra("sharetitle");
    }

    private void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
//            webView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        helper = new LoadViewHelper(new VaryViewHelperX(webView));
        helper.showLoading("加载中...");

        setTitle(title);
        /*mTopTitleView.setSubDraw(R.drawable.share, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PopupWindowManager(new ShareEntity(baseContext, sharetitles.equals("")?title:sharetitles, url, UmengShareListener.umShareListener));
            }
        });*/
    }

    private void WebviewConfig() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);// 设置此属性，可任意比例缩放
        webSettings.setLoadWithOverviewMode(true);
        loadWebEvent();
        if (!TextUtils.isEmpty(url)) webView.loadUrl(url);
    }

    private void loadWebEvent() {
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                showErrorPage();
            }

            @Override
            public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                helper.restore();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
    }

    protected void showErrorPage() {
        helper.showError("加载失败！", "重试", new OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(url);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        UMShareAPI.get(baseContext).onActivityResult(requestCode, resultCode, data);
    }

    /*@Override
    protected boolean showTitleBar() {
        return true;
    }*/

}
