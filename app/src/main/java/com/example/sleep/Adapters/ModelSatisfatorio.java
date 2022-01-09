package com.example.sleep.Adapters;

import android.widget.ImageView;

public class ModelSatisfatorio {
    private int img;
    private String video;
    private String nome;

    public ModelSatisfatorio(int img, String video, String nome) {
        this.img = img;
        this.video = video;
        this.nome = nome;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
