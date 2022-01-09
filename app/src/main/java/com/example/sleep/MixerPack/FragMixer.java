package com.example.sleep.MixerPack;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sleep.Metodos;
import com.example.sleep.R;
import com.example.sleep.ReprodutorActivity.ReprodutorActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class FragMixer extends Fragment implements ContratoMixer.MixerView {

    private ImageView riacho,fogueira,caverna,chuvaTelhado,passaros,praia,trem,floresta,aviao,chuvaFraca;
    private AnimationDrawable animationDrawable;
    private ScrollView scrollView;
    private TextView riachoText,fogueiraText,cavarnaText,chuvaTelhadoText,passarosText,praiaText
            ,tremText,florestaText,aviaoText,chuvaFracaText;
    private InterstitialAd mInterstitialAd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mixer,container,false);

        riacho = (ImageView)view.findViewById(R.id.riacho);
        fogueira = (ImageView)view.findViewById(R.id.fogueira);
        caverna = (ImageView)view.findViewById(R.id.caverna);
        chuvaTelhado = (ImageView)view.findViewById(R.id.chuvaTelhado);
        passaros = (ImageView)view.findViewById(R.id.passarinho);
        praia = (ImageView)view.findViewById(R.id.praia);
        trem = (ImageView)view.findViewById(R.id.trem);
        floresta = (ImageView)view.findViewById(R.id.Floresta);
        aviao = (ImageView)view.findViewById(R.id.Aviao);
        chuvaFraca = (ImageView)view.findViewById(R.id.ChuvaFraca);

        riachoText = (TextView) view.findViewById(R.id.riachoText);
        fogueiraText = (TextView) view.findViewById(R.id.fogueiraText);
        cavarnaText = (TextView) view.findViewById(R.id.textCaverna);
        chuvaTelhadoText = (TextView) view.findViewById(R.id.textChuvaTelhado);
        passarosText = (TextView) view.findViewById(R.id.textPassarinho);
        praiaText = (TextView) view.findViewById(R.id.textPraia);
        tremText = (TextView) view.findViewById(R.id.textTrem);
        florestaText = (TextView) view.findViewById(R.id.textFloresta);
        aviaoText = (TextView) view.findViewById(R.id.textAviao);
        chuvaFracaText = (TextView)view.findViewById(R.id.textChuvaFraca);

        scrollView = (ScrollView)view.findViewById(R.id.idScrollBack);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final PresenterMixer presenterMixer = new PresenterMixer(this,getContext());

        presenterMixer.IniciarAnimacao();

        riacho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterMixer.SetarRiacho();
            }
        });

        fogueira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterMixer.SetarFogueira();
            }
        });

        passaros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterMixer.SetarPassaros();
            }
        });

        chuvaTelhado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterMixer.SetarChuvaTelhado();
            }
        });

        praia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterMixer.SetarPraia();
            }
        });

        caverna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterMixer.SetarCaverna();
            }
        });

        trem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterMixer.SetarTrem();
            }
        });


        floresta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterMixer.SetarFloresta();
            }
        });

        aviao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterMixer.SetarAviao();
            }
        });

        chuvaFraca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterMixer.SetarChuvaFraca();
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
    public void Riacho() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.riacho_repro);
        intent.putExtra("imgNotifi",R.mipmap.riacho);

        intent.putExtra("NomeSom", riachoText.getText().toString());
        intent.putExtra("Som",R.raw.cachoeira_normal);
        startActivity(intent);
    }

    @Override
    public void Fogueira(){
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.fogueira_repro);
        intent.putExtra("imgNotifi",R.mipmap.fogueira);

        intent.putExtra("NomeSom", fogueiraText.getText().toString());
        intent.putExtra("Som",R.raw.fogueira);
        startActivity(intent);
    }

    @Override
    public void Caverna() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.caverna_repro);
        intent.putExtra("imgNotifi",R.mipmap.caverna);

        intent.putExtra("NomeSom", cavarnaText.getText().toString());
        intent.putExtra("Som",R.raw.caverna);
        startActivity(intent);
    }

    @Override
    public void ChuvaTelhado() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.chuva_repro);
        intent.putExtra("imgNotifi",R.mipmap.chuva_no_telhado);

        intent.putExtra("NomeSom", chuvaTelhadoText.getText().toString());
        intent.putExtra("Som",R.raw.chuva_telhado);
        startActivity(intent);
    }

    @Override
    public void Passaros() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.passaros_repro);
        intent.putExtra("imgNotifi",R.mipmap.passarinho);

        intent.putExtra("NomeSom", passarosText.getText().toString());
        intent.putExtra("Som",R.raw.passarinho);
        startActivity(intent);
    }

    @Override
    public void Praia() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.praia_repro);
        intent.putExtra("imgNotifi",R.mipmap.praia);

        intent.putExtra("NomeSom", praiaText.getText().toString());
        intent.putExtra("Som",R.raw.praia);
        startActivity(intent);
    }

    @Override
    public void Trem() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.trem_repro);
        intent.putExtra("imgNotifi",R.mipmap.trem);

        intent.putExtra("NomeSom", tremText.getText().toString());
        intent.putExtra("Som",R.raw.trem);
        startActivity(intent);
    }

    @Override
    public void Floresta() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.riacho_repro);
        intent.putExtra("imgNotifi",R.mipmap.floresta);

        intent.putExtra("NomeSom", florestaText.getText().toString());
        intent.putExtra("Som",R.raw.floresta);
        startActivity(intent);
    }

    @Override
    public void Universo() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.universo_repro);
        intent.putExtra("imgNotifi",R.mipmap.universo);

        intent.putExtra("Som",1);
        startActivity(intent);
    }

    @Override
    public void Aviao() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.aviao_repro);
        intent.putExtra("imgNotifi",R.mipmap.aviao);

        intent.putExtra("NomeSom", aviaoText.getText().toString());
        intent.putExtra("Som",R.raw.aviao);
        startActivity(intent);
    }

    @Override
    public void ChuvaFraca() {
        Intent intent = new Intent(getContext(), ReprodutorActivity.class);
        intent.putExtra("imgBack",R.mipmap.chuva_repro);
        intent.putExtra("imgNotifi",R.mipmap.chuva_fraca);

        intent.putExtra("NomeSom", chuvaFracaText.getText().toString());
        intent.putExtra("Som",R.raw.chuva_leve);
        startActivity(intent);
    }

    @Override
    public void AnimacaoBackground() {
        animationDrawable = (AnimationDrawable) scrollView.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }
}
