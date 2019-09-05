package com.achek.exchangerates.di;

import com.achek.exchangerates.presenter.ConverterPresenter;
import com.achek.exchangerates.presenter.MainPresenter;
import com.achek.exchangerates.repository.network.CbrServer;
import com.achek.exchangerates.view.MainActivity;
import com.achek.exchangerates.view.fragment.AboutFragment;
import com.achek.exchangerates.view.fragment.ConverterFragment;
import com.achek.exchangerates.view.fragment.MainFragment;
import com.achek.exchangerates.view.navigation.StackFragment;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DataModule.class)
public interface AppComponent {

    void injectMainActivity(MainActivity mainActivity);

    void injectMainFragment(MainFragment mainFragment);
    void injectStackFragment(StackFragment stackFragment);
    void injectConverterFragment(ConverterFragment converterFragment);


    void injectMainPresenter(MainPresenter mainPresenter);
    void injectConverterPresenter(ConverterPresenter converterPresenter);

    void injectCbrServer(CbrServer cbrServer);
}