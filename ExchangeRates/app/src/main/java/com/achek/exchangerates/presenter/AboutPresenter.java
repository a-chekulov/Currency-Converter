package com.achek.exchangerates.presenter;

import com.achek.exchangerates.view.MainActivityView;
import com.achek.exchangerates.view.fragment.AboutFragment;

public class AboutPresenter {

    private AboutFragment aboutFragment;

    private MainActivityView view;

    public void bind(MainActivityView view) {
        this.view = view;
    }

    public void debind() {
        view = null;
    }
}
