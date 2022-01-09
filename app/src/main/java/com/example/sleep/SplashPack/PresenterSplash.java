package com.example.sleep.SplashPack;

import android.content.Context;
import android.content.Intent;

import com.example.sleep.NavigationPack.BottomNavActivity;

import java.util.logging.Handler;

public class PresenterSplash implements ContractSplash.Presenter {

    private ContractSplash.view view;
    Intent intent;
    Context context;

    public PresenterSplash(ContractSplash.view view,Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void PassarTela() {
        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                intent = new Intent(context, BottomNavActivity.class);
                context.startActivity(intent);
                view.MvpView(intent);
            }
        },5000);
    }
}
