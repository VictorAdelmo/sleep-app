package com.example.sleep.ReprodutorActivity;

import android.content.Intent;
import android.media.MediaPlayer;

public class PresenterReprodutor implements ContratoReprodutor.PresenterRepro {
    private ContratoReprodutor.ViewReprodutor viewReprodutor;
    private Intent intent;

    public PresenterReprodutor(ContratoReprodutor.ViewReprodutor viewReprodutor,Intent intent) {
        this.viewReprodutor = viewReprodutor;
        this.intent = intent;
    }

    @Override
    public void VerficarValores() {
       int VerificarF = intent.getIntExtra("imgBack",0);
       int Som = intent.getIntExtra("Som",0);
       viewReprodutor.Iniciar(VerificarF);
    }

    @Override
    public void CriarNotificacao() {

    }

    @Override
    public void PausarPresenter(MediaPlayer mediaPlayer, int pausar) {
        if (pausar % 2 == 0){
            //Par
            mediaPlayer.release();
        }else {
            //Impar
            mediaPlayer.pause();
        }
    }
}

