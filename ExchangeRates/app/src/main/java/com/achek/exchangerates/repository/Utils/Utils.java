package com.achek.exchangerates.repository.Utils;


import androidx.annotation.NonNull;

import com.achek.exchangerates.repository.model.ResponseModel;
import com.achek.exchangerates.repository.model.Valute;
import com.achek.exchangerates.repository.model.ValutesHolder;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Valute> getListValuteByResponseModel(ResponseModel responseModel) {
        List<Valute> valuteList =  new ArrayList<>();
        ValutesHolder vh = responseModel.getCbrInfo().getValutesHolder();

        valuteList.add(vh.getaUD());
        valuteList.add(vh.getaZN());
        valuteList.add(vh.getgBP());
        valuteList.add(vh.getaMD());
        valuteList.add(vh.getbYN());
        valuteList.add(vh.getbGN());
        valuteList.add(vh.getbRL());
        valuteList.add(vh.gethUF());
        valuteList.add(vh.gethKD());
        valuteList.add(vh.getdKK());

        valuteList.add(vh.getuSD());
        valuteList.add(vh.geteUR());
        valuteList.add(vh.getiNR());
        valuteList.add(vh.getkZT());
        valuteList.add(vh.getcAD());
        valuteList.add(vh.getkGS());
        valuteList.add(vh.getcNY());
        valuteList.add(vh.getmDL());
        valuteList.add(vh.getnOK());
        valuteList.add(vh.getpLN());

        valuteList.add(vh.getrON());
        valuteList.add(vh.getxDR());
        valuteList.add(vh.getsGD());
        valuteList.add(vh.gettJS());
        valuteList.add(vh.gettRY());
        valuteList.add(vh.gettMT());
        valuteList.add(vh.getuZS());
        valuteList.add(vh.getuAH());
        valuteList.add(vh.getcZK());
        valuteList.add(vh.getsEK());

        valuteList.add(vh.getcHF());
        valuteList.add(vh.getzAR());
        valuteList.add(vh.getkRW());
        valuteList.add(vh.getjPY());
        return valuteList;
    }
}