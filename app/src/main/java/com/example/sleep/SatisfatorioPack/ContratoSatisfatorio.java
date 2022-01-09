package com.example.sleep.SatisfatorioPack;


import com.example.sleep.Adapters.ModelSatisfatorio;

import java.util.ArrayList;

public interface ContratoSatisfatorio {
    interface ViewSatistorio{
        void AnimacaoBackground();
        void recyclerJson();
    }
    interface SatisfatorioPresenterInterface{
        void IniciarAnimacao();
        boolean VerificarConexao();
        void RequisicaoJson();
    }
}
