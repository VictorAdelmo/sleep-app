package com.example.sleep.MediaVideoPack;

public class PresenterMediaVideo implements ContratoMediaVideo.PresenterMediaVideo {

    ContratoMediaVideo.ViewMediaVideo viewMediaVideo;

    public PresenterMediaVideo(ContratoMediaVideo.ViewMediaVideo viewMediaVideo) {
        this.viewMediaVideo = viewMediaVideo;
    }

    @Override
    public void PegarVideo() {
        viewMediaVideo.IniciarVideo();
    }
}
