package com.achek.exchangerates.view.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.achek.exchangerates.R;;
import com.achek.exchangerates.di.DaggerAppComponent;
import com.achek.exchangerates.di.DataModule;
import com.achek.exchangerates.presenter.MainPresenter;
import com.achek.exchangerates.repository.Adapters.RVAdapter;
import com.achek.exchangerates.repository.model.Valute;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainFragment extends Fragment implements MainFragmentView {

    public MainFragment(){
       DaggerAppComponent.builder().dataModule(new DataModule()).build().injectMainFragment(this);
    }
    @Inject
    protected MainPresenter mainPresenter;

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RVAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Boolean isDataAdded = Boolean.FALSE;
    private List<Valute> valuteList = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_main, null);
        progressBar = v.findViewById(R.id.progress_bar_main_fragment);

        recyclerView = v.findViewById(R.id.rv_valutes_main_fragment);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter = new RVAdapter(valuteList));
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        mainPresenter.bind(this);
        if (isDataAdded == Boolean.FALSE) {
            isDataAdded = Boolean.TRUE;
            mainPresenter.fillDataByServer();
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        mainPresenter.debind();
        super.onPause();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void startLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void endLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void fillData() {
        List<Valute> list = mainPresenter.getValuteList();
        for (int i = 0; i < list.size(); i++) {
            valuteList.add(list.get(i));
            adapter.notifyItemInserted(i);
        }
    }
}