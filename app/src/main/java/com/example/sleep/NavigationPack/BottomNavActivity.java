package com.example.sleep.NavigationPack;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sleep.MixerPack.FragMixer;
import com.example.sleep.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavActivity extends AppCompatActivity implements ContratoNav.ViewNav {

    BottomNavigationView bottomNavigationView;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        textView = (TextView)findViewById(R.id.textView4);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);

        PresenterNav presenterNav = new PresenterNav(this,this,textView);
        presenterNav.NavegarPresenter();
    }

    @Override
    public void NavegarView(BottomNavigationView.OnNavigationItemSelectedListener navListener,TextView textView) {
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        textView.setText(textView.getText());
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new FragMixer()).commit();
    }
}
