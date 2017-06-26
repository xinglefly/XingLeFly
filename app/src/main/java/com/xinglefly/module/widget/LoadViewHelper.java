package com.xinglefly.module.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.xinglefly.R;

import butterknife.ButterKnife;


public class LoadViewHelper {

	private IVaryViewHelper helper;

	public LoadViewHelper(View view) {
		this(new VaryViewHelper(view));
	}

	public LoadViewHelper(IVaryViewHelper helper) {
		super();
		this.helper = helper;
	}

	public void showError(String errorText, String buttonText, OnClickListener onClickListener) {
		View layout = helper.inflate(R.layout.load_error);
		TextView textView = ButterKnife.findById(layout,R.id.textView1);
		textView.setText(errorText);
		Button button = ButterKnife.findById(layout,R.id.button1);
		button.setText(buttonText);
		button.setOnClickListener(onClickListener);
		layout.setClickable(true);
		helper.showLayout(layout);
	}

	public void showEmpty(String errorText, String buttonText, OnClickListener onClickListener) {
		View layout = helper.inflate(R.layout.load_empty);
		TextView textView = ButterKnife.findById(layout,R.id.textView1);
		textView.setText(errorText);
		Button button = ButterKnife.findById(layout,R.id.button1);
		button.setText(buttonText);
		button.setOnClickListener(onClickListener);
		layout.setClickable(true);
		helper.showLayout(layout);
	}

	public void showLoading(String loadText) {
		View layout = helper.inflate(R.layout.load_ing);
		TextView textView = ButterKnife.findById(layout,R.id.textView1);
		textView.setText(loadText);
		layout.setClickable(true);
		helper.showLayout(layout);
	}

	public void restore() {
		helper.restoreView();
	}
}
