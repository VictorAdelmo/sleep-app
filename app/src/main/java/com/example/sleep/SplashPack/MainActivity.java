package com.example.sleep.SplashPack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.sleep.NavigationPack.BottomNavActivity;
import com.example.sleep.R;

public class MainActivity extends AppCompatActivity implements ContractSplash.view {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            PresenterSplash presenterSplash = new PresenterSplash(this,this);
            presenterSplash.PassarTela();
    }

    @Override
    public void MvpView(Intent intent) {
        finish();
    }
}
