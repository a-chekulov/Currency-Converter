package com.achek.exchangerates.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.achek.exchangerates.R;
import com.achek.exchangerates.di.DaggerAppComponent;
import com.achek.exchangerates.di.DataModule;
import com.achek.exchangerates.presenter.MainActivityPresenter;
import com.achek.exchangerates.view.navigation.StackFragment;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private Button btn_main;
    private Button btn_converter;
    private Button btn_about;
    private ClickListener clickListener;

    @Inject
    protected MainActivityPresenter mainActivityPresenter;
    @Inject
    protected StackFragment stackFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerAppComponent.builder().dataModule(new DataModule()).build().injectMainActivity(this);
        mainActivityPresenter.bind(this);

        btn_main = findViewById(R.id.btn_main);
        btn_converter = findViewById(R.id.btn_converter);
        btn_about = findViewById(R.id.btn_about);

        clickListener = new ClickListener();

        btn_main.setOnClickListener(clickListener);
        btn_converter.setOnClickListener(clickListener);
        btn_about.setOnClickListener(clickListener);

        stackFragment.bind(this);
        stackFragment.showFrgmentByTag(StackFragment.TAG_MAIN_FRAGMENT);

        Log.d("debug", "activity is created");

    }

    private class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_main: {
                    stackFragment.showFrgmentByTag(StackFragment.TAG_MAIN_FRAGMENT);
                    break;
                }
                case R.id.btn_converter: {
                    stackFragment.showFrgmentByTag(StackFragment.TAG_CONVERTER_FRAGMENT);
                    break;
                }
                case R.id.btn_about: {
                    stackFragment.showFrgmentByTag(StackFragment.TAG_ABOUT_FRAGMENT);
                    break;
                }
            }
        }
    }

    @Override
    public void setTitle(String title) {
        setTitle(title);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            stackFragment.getBack();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public FragmentTransaction getFragmentTransaction() {
        return getSupportFragmentManager().beginTransaction();
    }

    @Override
    protected void onDestroy() {
        stackFragment.debind();
        mainActivityPresenter.debind();
        super.onDestroy();
    }
}
