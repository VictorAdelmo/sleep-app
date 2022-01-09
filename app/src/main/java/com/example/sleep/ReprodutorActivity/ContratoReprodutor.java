package com.example.sleep.ReprodutorActivity;

import android.media.MediaPlayer;

public interface ContratoReprodutor {
    interface ViewReprodutor{
        void Iniciar(int Imagem);
    }

    interface PresenterRepro{
        void VerficarValores();
        void CriarNotificacao();
        void PausarPresenter(MediaPlayer mediaPlayer, int Pausar);
    }

    interface Player{
        void PlaySom();
        void PauseSom();
    }
}
