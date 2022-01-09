package com.example.sleep.ReprodutorActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.sleep.Metodos;
import com.example.sleep.NotificationMedia;
import com.example.sleep.R;
import com.example.sleep.ServiceNotifi;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class ReprodutorActivity extends AppCompatActivity implements ContratoReprodutor.ViewReprodutor, ContratoReprodutor.Player {

    private ConstraintLayout constraintLayout;
    private ImageButton iniciarButton;
    private MediaPlayer mediaPlayer  = new MediaPlayer();;

    boolean isPlaying = false;
    private NotificationManager notificationManager;
    private String nome;
    private TextView title;

    int imgIcon;
    int clicks = 0;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reprodutor);

        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

        final Metodos metodos = new Metodos();
        metodos.CarregarIntersticial(getApplicationContext());
        metodos.ExibirInterticial();

        constraintLayout = findViewById(R.id.IdBackReproduzir);
        iniciarButton = (ImageButton)findViewById(R.id.imageButton);
        title = (TextView)findViewById(R.id.tituloSom);

        nome = getIntent().getStringExtra("NomeSom");
        title.setText(nome);

        int Som = getIntent().getIntExtra("Som",0);

        mediaPlayer = MediaPlayer.create(this,Som);
        mediaPlayer.setLooping(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            criarCanal();
            registerReceiver(broadcastReceiver, new IntentFilter("SONS_SONS"));
            startService(new Intent(getBaseContext(), ServiceNotifi.class));
        }

        final PresenterReprodutor presenterReprodutor = new PresenterReprodutor(this,getIntent());
        presenterReprodutor.VerficarValores();


        iniciarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    PauseSom();
                } else {
                    PlaySom();
                }
            }
        });
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getExtras().getString("actioname");

            switch (action){
                case NotificationMedia.ACTION_PLAY:
                    if (isPlaying){
                        PauseSom();
                    }else {
                        PlaySom();
                    }
                    break;
            }
        }
    };

    @Override
    public void Iniciar(int Imagem) {
        constraintLayout.setBackgroundResource(Imagem);
    }

    @Override
    public void PlaySom() {
        mediaPlayer.start();

        imgIcon = getIntent().getIntExtra("imgNotifi",0);
        NotificationMedia.createNotification(getApplicationContext(),R.drawable.ic_baseline_pause_24,imgIcon,nome);
        iniciarButton.setImageResource(R.drawable.ic_baseline_pause_24);
        isPlaying = true;
    }

    @Override
    public void PauseSom() {
        mediaPlayer.pause();

        imgIcon = getIntent().getIntExtra("imgNotifi",0);
        NotificationMedia.createNotification(getApplicationContext(),R.drawable.ic_baseline_play_arrow_24,imgIcon,nome);
        iniciarButton.setImageResource(R.drawable.ic_baseline_play_arrow_24);
        isPlaying = false;
    }

    private void criarCanal(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(NotificationMedia.CHANNEL_NOTIFICATION_ID
                    ,"Sleep VA", NotificationManager.IMPORTANCE_LOW);

            notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null){
                notificationManager.createNotificationChannel(channel);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.cancelAll();
        }
    }
}
