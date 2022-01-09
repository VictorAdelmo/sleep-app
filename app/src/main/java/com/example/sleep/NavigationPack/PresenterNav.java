package com.example.sleep.NavigationPack;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.sleep.AsmrPack.FragAsmr;
import com.example.sleep.MixerPack.FragMixer;
import com.example.sleep.SatisfatorioPack.SatisfatorioActivity;
import com.example.sleep.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PresenterNav implements ContratoNav.PresenterNav {
    ContratoNav.ViewNav viewNav;
    Context context;
    TextView msg;


    public PresenterNav(ContratoNav.ViewNav viewNav, Context context,TextView string) {
        this.viewNav = viewNav;
        this.msg = string;
        this.context = context;
    }

    @Override
    public void NavegarPresenter() {
        BottomNavigationView.OnNavigationItemSelectedListener navListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        Fragment selectedFragment = null;

                        switch (menuItem.getItemId()) {
                            case R.id.Mixer:
                                msg.setText("Sleep - Durma e Relaxe");
                                selectedFragment = new FragMixer();
                                break;

                            case R.id.Ajustes:
                                msg.setText("Sleep - Sons Relaxantes com Objetos");
                                selectedFragment = new FragAsmr();
                                break;

                            case R.id.Satisfatorios:
                                msg.setText("Sleep - Veja Vídeos Satisfatórios");
                                selectedFragment = new SatisfatorioActivity();
                                break;

                        }
                        ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();
                        return true;

                    }
                };
        viewNav.NavegarView(navListener,msg);
    }
}
