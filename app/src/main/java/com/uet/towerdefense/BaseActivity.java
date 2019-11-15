package com.uet.towerdefense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Display;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

import static com.uet.towerdefense.Constants.SCREEN_HEIGHT;
import static com.uet.towerdefense.Constants.SCREEN_WIDTH;

public abstract class BaseActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        ButterKnife.bind(this);

        updateScreenWidthHeight();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        setupListener();
        populateData();
    }

    private void updateScreenWidthHeight() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        SCREEN_WIDTH = size.x;
        SCREEN_HEIGHT = size.y;
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected abstract void setupListener();

    protected abstract void populateData();

    /*public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }*/
}
