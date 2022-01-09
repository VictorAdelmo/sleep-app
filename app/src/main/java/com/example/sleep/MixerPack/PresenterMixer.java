package com.example.sleep.MixerPack;

import android.content.Context;
import android.widget.ImageView;

public class PresenterMixer implements ContratoMixer.MixerPresenter {
    private Context context;
    private ContratoMixer.MixerView view;

    public PresenterMixer(ContratoMixer.MixerView view,Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void SetarRiacho() {
        view.Riacho();
    }

    @Override
    public void SetarFogueira() {
        view.Fogueira();
    }

    @Override
    public void SetarCaverna() {
        view.Caverna();
    }

    @Override
    public void SetarChuvaTelhado() {
        view.ChuvaTelhado();
    }

    @Override
    public void SetarPassaros() {
        view.Passaros();
    }

    @Override
    public void SetarPraia() {
        view.Praia();
    }

    @Override
    public void SetarFloresta() {
        view.Floresta();
    }

    @Override
    public void SetarTrem() {
        view.Trem();
    }

    @Override
    public void SetarUniverso() {
        view.Universo();
    }

    @Override
    public void SetarAviao() {
        view.Aviao();
    }

    @Override
    public void SetarChuvaFraca() {
        view.ChuvaFraca();
    }

    @Override
    public void IniciarAnimacao() {
        view.AnimacaoBackground();
    }
}
