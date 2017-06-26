package com.xinglefly.module.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinglefly.R;


public class TopTitleView extends FrameLayout {

	/**
	 * 最左返回键
	 */
	private View mLeftView;
	private TextView mTitleTextView;
	private TextView mTitleTextExtra;
	private ImageView mRightImg;

	public TopTitleView(Context context) {
		this(context, null);
	}

	public TopTitleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {

	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		setDrawingCacheEnabled(true);
		setAlwaysDrawnWithCacheEnabled(true);

		mLeftView = findViewById(R.id.backImage);
		mTitleTextView = (TextView) findViewById(R.id.title);
		mTitleTextExtra = (TextView) findViewById(R.id.sub_title);
		mRightImg = (ImageView) findViewById(R.id.sub_img);
	}

	public void setTitle(String title) {
		if (mTitleTextView != null) {
			mTitleTextView.setText(title);
		}
	}

	public void setTitle(String title, String extra) {
		if (mTitleTextView != null) {
			mTitleTextView.setText(title);
		}
		if (!TextUtils.isEmpty(extra)) {
			mTitleTextExtra.setText(extra);
			mTitleTextExtra.setVisibility(View.VISIBLE);
		}
	}
	public void setSubTitle(String title, View.OnClickListener listener){
		if (mTitleTextExtra != null) {
			mTitleTextExtra.setText(title);
			mTitleTextExtra.setVisibility(View.VISIBLE);
			setView(mTitleTextExtra, 0, listener);
		}
	}

	public void setSubDraw(int imgId, View.OnClickListener listener){
		if (mRightImg != null) {
			mRightImg.setBackgroundResource(imgId);
			mRightImg.setVisibility(View.VISIBLE);
			setView(mRightImg, 0, listener);
		}
	}

	public void setSubTitleColor(String title, String color, View.OnClickListener listener) {
		if (mTitleTextExtra != null) {
			mTitleTextExtra.setText(title);
			mTitleTextExtra.setTextColor(Color.parseColor(color));
			mTitleTextExtra.setVisibility(View.VISIBLE);
			setView(mTitleTextExtra, 0, listener);
		}
	}

	public void setTitle(String title, View.OnClickListener listener) {
		if (mTitleTextView != null) {
			mTitleTextView.setText(title);
			setView(mTitleTextView, 0, listener);
		}
	}

	public View setLeftView(int backgroudResId, String name,
							View.OnClickListener listener, boolean needLeftPic) {
		mLeftView.setVisibility(VISIBLE);
		if (mLeftView != null) {
			mLeftView.setVisibility(VISIBLE);
			if (backgroudResId != 0) {
				mLeftView.setBackgroundResource(backgroudResId);
			}
			mLeftView.setOnClickListener(listener);
		}
		return mLeftView;
	}

	public View setLeftView(int backgroudResId, String name,
							View.OnClickListener listener) {
		backgroudResId = 0;
		return setLeftView(backgroudResId, name, listener, false);
	}

	public View setLeftView(View.OnClickListener listener) {
		mLeftView.setOnClickListener(listener);
		return setLeftView(0, "", listener, false);
	}

	private void setView(View view, int backgroudResId,
						 View.OnClickListener listener) {
		if (view != null) {
			view.setVisibility(View.VISIBLE);
			if (backgroudResId != 0) {
				view.setBackgroundResource(backgroudResId);
			}
			if (listener != null) {
				view.setOnClickListener(listener);
			}
		}
	}

	public void setOnBackClickLitener(OnClickListener onClickListener) {
		mLeftView.setOnClickListener(onClickListener);
	}

}
