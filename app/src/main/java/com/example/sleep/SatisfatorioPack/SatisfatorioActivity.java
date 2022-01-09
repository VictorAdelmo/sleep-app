package com.example.sleep.SatisfatorioPack;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sleep.Adapters.ModelSatisfatorio;
import com.example.sleep.Adapters.RecyclerViewSatisfatorio;
import com.example.sleep.Lista;
import com.example.sleep.R;

import java.util.ArrayList;

public class SatisfatorioActivity extends Fragment implements ContratoSatisfatorio.ViewSatistorio {

    private AnimationDrawable animationDrawable;
    private ScrollView constraintLayout;
    private RecyclerView recyclerView;
    private ArrayList<ModelSatisfatorio>arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_satisfatorio,container,false);
        constraintLayout = (ScrollView) view.findViewById(R.id.IdLayoutSatisfatorio);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerId);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        PresenterSatisfatorio presenterSatisfatorio = new PresenterSatisfatorio(this,getContext());
        presenterSatisfatorio.IniciarAnimacao();
        presenterSatisfatorio.RequisicaoJson();
    }

    @Override
    public void AnimacaoBackground() {
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

    @Override
    public void recyclerJson() {
        PresenterSatisfatorio presenterSatisfatorio = new PresenterSatisfatorio(this,getContext());
        boolean verficiarConexao = presenterSatisfatorio.VerificarConexao();

        if (verficiarConexao) {
            arrayList = new ArrayList<>();
            Lista lista = new Lista();
            ArrayList ListaCompleta = lista.ListaAdd(arrayList);
            RecyclerViewSatisfatorio myadapter = new RecyclerViewSatisfatorio(getContext(), ListaCompleta);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
            recyclerView.setAdapter(myadapter);
        }else{
            Toast.makeText(getContext(),"Conexão Necessária",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        PresenterSatisfatorio presenterSatisfatorio = new PresenterSatisfatorio(this,getContext());
        presenterSatisfatorio.IniciarAnimacao();
        presenterSatisfatorio.RequisicaoJson();
    }
}
