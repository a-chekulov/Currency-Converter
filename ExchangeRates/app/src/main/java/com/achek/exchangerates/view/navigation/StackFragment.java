package com.achek.exchangerates.view.navigation;


import com.achek.exchangerates.R;
import com.achek.exchangerates.di.DaggerAppComponent;
import com.achek.exchangerates.di.DataModule;
import com.achek.exchangerates.view.MainActivityView;
import com.achek.exchangerates.view.fragment.AboutFragment;
import com.achek.exchangerates.view.fragment.ConverterFragment;
import com.achek.exchangerates.view.fragment.MainFragment;

import java.util.Stack;

import javax.inject.Inject;

public class StackFragment {

    @Inject
    protected MainFragment mainFragment;
    @Inject
    protected ConverterFragment converterFragment;
    @Inject
    protected AboutFragment aboutFragment;

    public StackFragment() {
        DaggerAppComponent.builder().dataModule(new DataModule()).build().injectStackFragment(this);
    }

    public static final String TAG_MAIN_FRAGMENT = "main";
    public static final String TAG_CONVERTER_FRAGMENT = "converter";
    public static final String TAG_ABOUT_FRAGMENT = "about";

    private Stack<String> stack = new Stack<>();
    private String currentFragment = null;
    private Boolean isMainFragmentInit = Boolean.FALSE;
    private Boolean isConverterFragmentInit = Boolean.FALSE;
    private Boolean isAboutFragmentInit = Boolean.FALSE;

    private MainActivityView v;

    public void bind(MainActivityView v) {
        this.v = v;
    }

    public void debind() {
        v = null;
    }

    private void hideFragmentByTag(String tag) {
        if (v != null) {
            switch (tag) {
                case TAG_MAIN_FRAGMENT: {
                    v.getFragmentTransaction().hide(mainFragment).commit();
                    break;
                }
                case TAG_CONVERTER_FRAGMENT: {
                    v.getFragmentTransaction().hide(converterFragment).commit();
                    break;
                }
                case TAG_ABOUT_FRAGMENT: {
                    v.getFragmentTransaction().hide(aboutFragment).commit();
                }
            }
        }
    }

    public void getBack() {
        stack.pop(); // del current
        if (stack.empty()) {
            v.showError("Конец стека");
            stack.push(currentFragment);
        } else {
            showFrgmentByTag(stack.pop());
        }
    }

    public void showFrgmentByTag(String tag) {
        if (v != null) {
            switch (tag) {
                case TAG_MAIN_FRAGMENT: {
                    if (currentFragment != TAG_MAIN_FRAGMENT) {
                        if (currentFragment != null) {
                            hideFragmentByTag(currentFragment);
                        }
                        if (isMainFragmentInit) {
                            stack.push(TAG_MAIN_FRAGMENT);
                            v.getFragmentTransaction().show(mainFragment).commit();
                        } else {
                            stack.push(TAG_MAIN_FRAGMENT);
                            isMainFragmentInit = Boolean.TRUE;
                            v.getFragmentTransaction().add(R.id.fragment_container, mainFragment).commit();
                        }

                    }
                }
                break;

                case TAG_CONVERTER_FRAGMENT: {
                    if (currentFragment != TAG_CONVERTER_FRAGMENT) {
                        if (currentFragment != null) {
                            hideFragmentByTag(currentFragment);
                        }
                        if (isConverterFragmentInit) {
                            stack.push(TAG_CONVERTER_FRAGMENT);
                            v.getFragmentTransaction().show(converterFragment).commit();
                        } else {
                            stack.push(TAG_CONVERTER_FRAGMENT);
                            isConverterFragmentInit = Boolean.TRUE;
                            v.getFragmentTransaction().add(R.id.fragment_container, converterFragment).commit();
                        }
                    }
                }
                break;

                case TAG_ABOUT_FRAGMENT: {
                    if (currentFragment != TAG_ABOUT_FRAGMENT) {
                        if (currentFragment != null) {
                            hideFragmentByTag(currentFragment);
                        }
                        if (isAboutFragmentInit) {
                            stack.push(TAG_ABOUT_FRAGMENT);
                            v.getFragmentTransaction().show(aboutFragment).commit();
                        } else {
                            stack.push(TAG_ABOUT_FRAGMENT);
                            isAboutFragmentInit = Boolean.TRUE;
                            v.getFragmentTransaction().add(R.id.fragment_container, aboutFragment).commit();
                        }
                    }
                }
                break;
            }
            currentFragment = tag;
        }
    }
}
