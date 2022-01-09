package com.example.sleep.MixerPack;

import android.widget.ImageView;

public interface ContratoMixer {
    interface MixerView{
        void Riacho();
        void Fogueira();
        void Caverna();
        void ChuvaTelhado();
        void Passaros();
        void Praia();
        void Trem();
        void Floresta();
        void Universo();
        void Aviao();
        void ChuvaFraca();
        void AnimacaoBackground();
    }
    interface MixerPresenter{
        void SetarRiacho();
        void SetarFogueira();
        void SetarCaverna();
        void SetarChuvaTelhado();
        void SetarPassaros();
        void SetarPraia();
        void SetarFloresta();
        void SetarTrem();
        void SetarUniverso();
        void SetarAviao();
        void SetarChuvaFraca();
        void IniciarAnimacao();
    }
}
