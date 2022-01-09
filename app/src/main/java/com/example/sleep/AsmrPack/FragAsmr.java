package com.example.sleep.AsmrPack;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sleep.Metodos;
import com.example.sleep.R;
import com.example.sleep.ReprodutorActivity.ReprodutorActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class FragAsmr extends Fragment implements ContratoAsmr.AsmrView {

    private ImageView tesoura,slime,pintando,poteDoce,maquiagem,spray,frasco,crocante,esponja,cortando;
    private TextView textTesoura,textSlime,textPintando,textPoteDoce,textMaquiagem,textSpray
            ,textFrasco,textCrocante,textEsponja,textCortando;

    private InterstitialAd mInterstitialAd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_asmr,container,false);
        tesoura = (ImageView)view.findViewById(R.id.tesoura);
        slime = (ImageView) view.findViewById(R.id.slime);
        pintando = (ImageView)view.findViewById(R.id.pintura);
        poteDoce = (ImageView)view.findViewById(R.id.poteDoce);
        maquiagem = (ImageView)view.findViewById(R.id.maquiagem);
        spray = (ImageView)view.findViewById(R.id.spray);
        frasco = (ImageView)view.findViewById(R.id.frascoAgua);
        crocante = (ImageView)view.findViewById(R.id.crocante);
        esponja = (ImageView)view.findViewById(R.id.esponja);
        cortando = (ImageView)view.findViewById(R.id.facaCortando);

        textSpray = (TextView)view.findViewById(R.id.textSpray);
        textTesoura = (TextView)view.findViewById(R.id.textTesoura);
        textSlime = (TextView)view.findViewById(R.id.textSlime);
        textPintando = (TextView)view.findViewById(R.id.textPintura);
        textPoteDoce = (TextView)view.findViewById(R.id.textPoteDoce);
        textMaquiagem = (TextView)view.findViewById(R.id.textMaquiagem);
        textFrasco = (TextView)view.findViewById(R.id.textFrascoAgua);
        textCrocante = (TextView)view.findViewById(R.id.textCrocante);
        textEsponja = (TextView)view.findViewById(R.id.textEsponja);
        textCortando = (TextView)view.findViewById(R.id.textFacaCortando);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final PresenterAsmr presenterAsmr = new PresenterAsmr(this);

        tesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterAsmr.SetarTesoura();
            }
        });

        slime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterAsmr.SetarSlime();
            }
        });

        pintando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterAsmr.SetarPintura();
            }
        });

        poteDoce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterAsmr.SetarPoteDoce();
            }
        });

        maquiagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterAsmr.SetarMaquiagem();
            }
        });

        spray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterAsmr.SetarSpray();
            }
        });

        frasco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterAsmr.SetarFrasco();
            }
        });

        crocante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterAsmr.SetarCrocante();
            }
        });

        esponja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterAsmr.SetarEsponja();
            }
        });

        cortando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterAsmr.SetarFacaCortando();
            }
        });
    }

    private void MostrarAds(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }

    @Override
    public void Tesoura() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.cabeleireiro_repro);
        intent.putExtra("imgNotifi",R.mipmap.tesoura);

        intent.putExtra("NomeSom", textTesoura.getText().toString());
        intent.putExtra("Som",1);
        startActivity(intent);
    }

    @Override
    public void Maquiagem() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.maquiagem_repro);
        intent.putExtra("imgNotifi",R.mipmap.maquiagem);

        intent.putExtra("NomeSom", textMaquiagem.getText().toString());
        intent.putExtra("Som",1);
        startActivity(intent);
    }

    @Override
    public void Slime() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.slime_repro);
        intent.putExtra("imgNotifi",R.mipmap.slime);

        intent.putExtra("NomeSom", textSlime.getText().toString());
        intent.putExtra("Som",1);
        startActivity(intent);
    }

    @Override
    public void PoteDoce() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.doces_repro);
        intent.putExtra("imgNotifi",R.mipmap.pote);

        intent.putExtra("NomeSom", textPoteDoce.getText().toString());
        intent.putExtra("Som",1);
        startActivity(intent);
    }

    @Override
    public void Pintura() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.pintura_repro);
        intent.putExtra("imgNotifi",R.mipmap.pintura);

        intent.putExtra("NomeSom", textPintando.getText().toString());
        intent.putExtra("Som",1);
        startActivity(intent);
    }

    @Override
    public void Spray() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.spray_repro);
        intent.putExtra("imgNotifi",R.mipmap.spray);

        intent.putExtra("NomeSom", textSpray.getText().toString());
        intent.putExtra("Som",1);
        startActivity(intent);
    }

    @Override
    public void Frasco() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.frasco_repro);
        intent.putExtra("imgNotifi",R.mipmap.frasco_de_agua);

        intent.putExtra("NomeSom", textFrasco.getText().toString());
        intent.putExtra("Som",1);
        startActivity(intent);
    }

    @Override
    public void Crocante() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.crocante_repro);
        intent.putExtra("imgNotifi",R.mipmap.crocante);

        intent.putExtra("NomeSom", textCrocante.getText().toString());
        intent.putExtra("Som",1);
        startActivity(intent);
    }

    @Override
    public void Esponja() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.esponja_repro);
        intent.putExtra("imgNotifi",R.mipmap.esponja);

        intent.putExtra("NomeSom", textEsponja.getText().toString());
        intent.putExtra("Som",1);
        startActivity(intent);
    }

    @Override
    public void FacaCortando() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.cortando_repro);
        intent.putExtra("imgNotifi",R.mipmap.faca_cortando);

        intent.putExtra("NomeSom", textCortando.getText().toString());
        intent.putExtra("Som",1);
        startActivity(intent);
    }
}
