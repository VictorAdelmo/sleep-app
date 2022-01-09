package com.example.sleep.AsmrPack;

public class PresenterAsmr implements ContratoAsmr.PresenterAsmr {
    ContratoAsmr.AsmrView view;

    public PresenterAsmr(ContratoAsmr.AsmrView view) {
        this.view = view;
    }

    @Override
    public void SetarTesoura() {
        view.Tesoura();
    }

    @Override
    public void SetarMaquiagem() {
        view.Maquiagem();
    }

    @Override
    public void SetarSlime() {
        view.Slime();
    }

    @Override
    public void SetarPoteDoce() {
        view.PoteDoce();
    }

    @Override
    public void SetarPintura() {
        view.Pintura();
    }

    @Override
    public void SetarSpray() {
        view.Spray();
    }

    @Override
    public void SetarFrasco() {
        view.Frasco();
    }

    @Override
    public void SetarCrocante() {
        view.Crocante();
    }

    @Override
    public void SetarEsponja() {
        view.Esponja();
    }

    @Override
    public void SetarFacaCortando() {
        view.FacaCortando();
    }
}
