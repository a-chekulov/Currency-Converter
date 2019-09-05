package com.achek.exchangerates.view.fragment;

public interface MainFragmentView {
    void showError(String error);
    void startLoading();
    void endLoading();
    void fillData();
}
