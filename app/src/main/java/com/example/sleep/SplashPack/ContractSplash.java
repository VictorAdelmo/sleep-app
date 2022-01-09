package com.example.sleep.SplashPack;

import android.content.Intent;

public interface ContractSplash {
   interface view{
       void MvpView(Intent intent);
   }

    interface Presenter{
        void PassarTela();
    }
}
