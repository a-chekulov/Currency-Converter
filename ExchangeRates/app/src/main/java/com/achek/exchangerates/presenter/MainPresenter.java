package com.achek.exchangerates.presenter;

import com.achek.exchangerates.di.DaggerAppComponent;
import com.achek.exchangerates.di.DataModule;
import com.achek.exchangerates.repository.Utils.Utils;
import com.achek.exchangerates.repository.async.CallBack;
import com.achek.exchangerates.repository.model.ResponseModel;
import com.achek.exchangerates.repository.model.Valute;
import com.achek.exchangerates.repository.network.CbrServer;
import com.achek.exchangerates.view.fragment.MainFragmentView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class MainPresenter {

    List<Valute> valuteList = new ArrayList<>();

    public MainPresenter() {
        DaggerAppComponent.builder().dataModule(new DataModule()).build().injectMainPresenter(this);
    }

    @Inject
    CbrServer cbrServer;

    private MainFragmentView view;

    public void bind(MainFragmentView view) {
        this.view = view;
    }

    public void debind() {
        view = null;
    }

    public void fillDataByServer() {
        view.startLoading();
        cbrServer.getRatesInfo(new CallBack() {
            @Override
            public void callingBack(ResponseModel responseModel) {
                view.endLoading();
                if (responseModel.getError() != null) {
                    view.showError(responseModel.getError());
                } else {
                    valuteList = Utils.getListValuteByResponseModel(responseModel);
                    view.fillData();
                }
            }
        });
    }

    public List<Valute> getValuteList() {
        return valuteList;
    }
}
