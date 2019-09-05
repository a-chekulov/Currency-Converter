package com.achek.exchangerates.view;

import androidx.fragment.app.FragmentTransaction;

public interface MainActivityView {
    void showError(String error);
    void setTitle(String title);
    FragmentTransaction getFragmentTransaction();
}
