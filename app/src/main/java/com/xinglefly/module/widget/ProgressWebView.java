package com.xinglefly.module.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * use:
	 WebSettings settings = progressWebView.getSettings();
	 settings.setUseWideViewPort(true);
	 settings.setLoadWithOverviewMode(true);
	 settings.setBuiltInZoomControls(false);
	 if (jump_url != null) progressWebView.loadUrl(jump_url);
 */

@SuppressLint("SetJavaScriptEnabled")
public class ProgressWebView extends WebView {

	private ProgressBar progressbar;
	/** 进度条 */
	private WebSettings mWebSettings;

	public ProgressWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// 初始化进度条
		progressbar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
		// 设置进度条风格
		progressbar.setLayoutParams(new LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, 5, 0, 0));
		addView(progressbar);
		setWebChromeClient(new WebChromeClient());
		mWebSettings = this.getSettings();
		mWebSettings.setJavaScriptEnabled(true); // 允许加载javascript
		mWebSettings.setSupportZoom(true); // 允许缩放
		mWebSettings.setBuiltInZoomControls(true); // 原网页基础上缩放
		mWebSettings.setUseWideViewPort(true); // 任意比例缩放
		this.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return super.shouldOverrideUrlLoading(view, url);
			}
		});
	}

	public class WebChromeClient extends android.webkit.WebChromeClient {
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			if (newProgress == 100) {
				progressbar.setVisibility(GONE); // 加载完成隐藏进度条
			} else {
				if (progressbar.getVisibility() == GONE)
					progressbar.setVisibility(VISIBLE);
				progressbar.setProgress(newProgress);
			}
			super.onProgressChanged(view, newProgress);
		}
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		LayoutParams lp = (LayoutParams) progressbar.getLayoutParams();
		lp.x = l;
		lp.y = t;
		progressbar.setLayoutParams(lp);
		super.onScrollChanged(l, t, oldl, oldt);
	}
}
