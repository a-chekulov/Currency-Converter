package com.achek.exchangerates.di;

import com.achek.exchangerates.presenter.ConverterPresenter;
import com.achek.exchangerates.presenter.MainActivityPresenter;
import com.achek.exchangerates.presenter.MainPresenter;
import com.achek.exchangerates.repository.network.CbrServer;
import com.achek.exchangerates.view.fragment.AboutFragment;
import com.achek.exchangerates.view.fragment.ConverterFragment;
import com.achek.exchangerates.view.fragment.MainFragment;
import com.achek.exchangerates.view.navigation.StackFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    @Provides
    @Singleton
    static Retrofit provideRetrofit() { return new Retrofit.Builder()
            .baseUrl("https://www.cbr-xml-daily.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
    @Provides
    static CbrServer provideCbrServer(){return  new CbrServer();}

    @Provides
    @Singleton
    static MainActivityPresenter provideMainActivityPresenter(){return new MainActivityPresenter();}

    @Provides
    @Singleton
    static MainPresenter provideMainPresenter(){return new MainPresenter();}

    @Provides
    @Singleton
    static ConverterPresenter provideConverterPresentor(){return  new ConverterPresenter();}

    @Provides
    @Singleton
    static MainFragment provideMainFragment() {return new MainFragment();}

    @Provides
    @Singleton
    static ConverterFragment converterFragment() {return new ConverterFragment();}

    @Provides
    @Singleton
    static AboutFragment aboutFragment() {return new AboutFragment();}

    @Provides
    @Singleton
    protected StackFragment stackFragment() {return  new StackFragment();}
}
