package com.xinglefly;

import android.app.Fragment;

import rx.Subscription;

public class BaseFragment extends Fragment {

    protected Subscription subscription;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unsubscribe();
    }

    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }


}