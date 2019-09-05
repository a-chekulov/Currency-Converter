package com.achek.exchangerates.view.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.achek.exchangerates.R;
import com.achek.exchangerates.di.DaggerAppComponent;
import com.achek.exchangerates.di.DataModule;
import com.achek.exchangerates.presenter.ConverterPresenter;
import com.achek.exchangerates.repository.model.Valute;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ConverterFragment extends Fragment implements ConverterFragmentView {

    public ConverterFragment() {
        DaggerAppComponent.builder().dataModule(new DataModule()).build().injectConverterFragment(this);
    }

    @Inject
    protected ConverterPresenter converterPresenter;

    private Spinner sp_from;
    private Spinner sp_to;
    private EditText et_from;
    private EditText et_to;
    private ProgressBar progressBar;
    private Boolean isDataAdded = Boolean.FALSE;
    private List<Valute> valuteList = new ArrayList<>();
    private ArrayAdapter<String> adapterFrom;
    private ArrayAdapter<String> adapterTo;
    private String[] spinner_data;
    private Boolean isInitSpinner = Boolean.FALSE;
    private Boolean allowEditEdFrom = Boolean.FALSE;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_converter, null);

        progressBar = v.findViewById(R.id.progress_bar_converter_fragment);
        sp_from = v.findViewById(R.id.sp_from);
        sp_to = v.findViewById(R.id.sp_to);

        et_from = v.findViewById(R.id.et_from);
        et_to = v.findViewById(R.id.et_to);
        et_from.setText("1.0");
        et_to.setText("1.0");

        et_to.setEnabled(false);

        et_from.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                if (isInitSpinner) updateValue("to");
            }
        });

//        et_to.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
//            @Override
//            public void afterTextChanged(Editable editable) {
//                if (isInitSpinner && allowEditEdFrom) updateValue("from");
//            }
//        });

        return v;
    }

    @Override
    public void onResume() {
        converterPresenter.bind(this);
        if (isDataAdded == Boolean.FALSE) {
            isDataAdded = Boolean.TRUE;
            converterPresenter.fillDataByServer();
        }
        super.onResume();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    private void updateValue(String tag) {
        switch (tag) {
            case "to": {
                int posSpFrom = sp_from.getSelectedItemPosition();
                int posSpTo = sp_to.getSelectedItemPosition();

                double costFrom = valuteList.get(posSpFrom).getValue() / valuteList.get(posSpFrom).getNominal();
                double costTo = valuteList.get(posSpTo).getValue() / valuteList.get(posSpTo).getNominal();
                double valueFrom;
                try {
                    valueFrom = Double.parseDouble(et_from.getText().toString());
                } catch (Exception e) {
                    valueFrom = 1;
                }
                double rezult = (Math.round(100000.0 * costTo / costFrom * valueFrom)) / 100000.0;
                et_to.setText((Double.toString(rezult)));
                break;
            }
            // от изменения поля et_to пришлось отказаться
//            case "from": {
//                int posSpFrom = sp_from.getSelectedItemPosition();
//                int posSpTo = sp_to.getSelectedItemPosition();
//
//                double costFrom = valuteList.get(posSpFrom).getValue() / valuteList.get(posSpFrom).getNominal();
//                double costTo = valuteList.get(posSpTo).getValue() / valuteList.get(posSpTo).getNominal();
//
//                double valueTo;
//
//                try {
//                    valueTo = Double.parseDouble(et_to.getText().toString());
//                } catch (Exception e) {
//                    valueTo = 1;
//                }
//
//                double rezult = Math.round(100000.0 * costFrom / costTo / valueTo)/100000.0;
//                allowEditEdFrom = Boolean.FALSE;
//                et_from.setText(Double.toString(rezult));
//                allowEditEdFrom = Boolean.TRUE;
//                break;
//            }
        }
    }

    @Override
    public void startLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void endLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }


    public void fillData() {
        spinner_data = new String[converterPresenter.getValuteList().size() + 1];
        valuteList.add(new Valute("0", "RUB", "RUB", 1, "Российский рубль", 1, 1));
        for (int i = 0; i < converterPresenter.getValuteList().size(); i++) {
            valuteList.add(converterPresenter.getValuteList().get(i));
            spinner_data[i] = valuteList.get(i).getCharCode();
        }
        initSpinner();
    }

    @Override
    public void initSpinner() {
        adapterFrom = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, spinner_data);
        adapterTo = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, spinner_data);
        adapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_from.setAdapter(adapterFrom);
        sp_to.setAdapter(adapterTo);

        AdapterView.OnItemSelectedListener selectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                updateValue("to");
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        };
        sp_from.setOnItemSelectedListener(selectedListener);
        sp_to.setOnItemSelectedListener(selectedListener);

        isInitSpinner = Boolean.TRUE;
    }
}
