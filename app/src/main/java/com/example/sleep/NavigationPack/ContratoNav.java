package com.example.sleep.NavigationPack;

import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public interface ContratoNav {
    interface ViewNav{
        void NavegarView(BottomNavigationView.OnNavigationItemSelectedListener navListener, TextView textView);
    }

    interface PresenterNav{
        void NavegarPresenter();
    }
}
