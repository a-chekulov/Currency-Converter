package com.achek.exchangerates.view.fragment;

public interface ConverterFragmentView {
    void showError(String error);
    void startLoading();
    void endLoading();
    void fillData();
    void initSpinner();
}
