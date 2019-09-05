package com.achek.exchangerates.presenter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.achek.exchangerates.R;
import com.achek.exchangerates.view.MainActivityView;


public class MainActivityPresenter {

    private MainActivityView view;

    public void showFragment(FragmentTransaction fragmentTransaction, Fragment fragment, String tag){
        fragmentTransaction.add(R.id.fragment_container, fragment).addToBackStack("stack");
        fragmentTransaction.commit();

    }

    public void bind(MainActivityView view) {
        this.view = view;
    }

    public void debind() {
        view = null;
    }

}
