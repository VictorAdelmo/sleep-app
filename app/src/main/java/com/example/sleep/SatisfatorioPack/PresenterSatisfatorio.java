package com.example.sleep.SatisfatorioPack;

import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;


import com.example.sleep.Adapters.ModelSatisfatorio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PresenterSatisfatorio implements ContratoSatisfatorio.SatisfatorioPresenterInterface {

    private ContratoSatisfatorio.ViewSatistorio viewSatistorio;
    ArrayList<ModelSatisfatorio> ListSatisf;
    private Context context;
    private String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";

    public PresenterSatisfatorio(ContratoSatisfatorio.ViewSatistorio viewSatistorio,Context context) {
        this.viewSatistorio = viewSatistorio;
        this.context = context;
    }

    @Override
    public void IniciarAnimacao() {
        viewSatistorio.AnimacaoBackground();
    }

    @Override
    public boolean VerificarConexao() {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    @Override
    public void RequisicaoJson() {
        viewSatistorio.recyclerJson();
    }
}
