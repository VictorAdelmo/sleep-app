package com.example.sleep;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Metodos {
    private InterstitialAd mInterstitialAd;

    public void CarregarIntersticial(Context context){
        MobileAds.initialize(context,
                "ca-app-pub-4802777834168389~6359997823");
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void ExibirInterticial(){
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                mInterstitialAd.show();
            }
        });
    }
}
