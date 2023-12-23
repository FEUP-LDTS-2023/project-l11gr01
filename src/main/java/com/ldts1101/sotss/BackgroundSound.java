package com.ldts1101.sotss;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BackgroundSound {
    private String soundFilePath;
    private AdvancedPlayer player;

    public BackgroundSound(String soundFilePath) {
        this.soundFilePath = soundFilePath;
    }

    public void play() {
        try {
            InputStream is = new FileInputStream(soundFilePath);
            player = new AdvancedPlayer(is);

            // Add a listener to loop the sound
            player.setPlayBackListener(new PlaybackListener() {
                @Override
                public void playbackFinished(PlaybackEvent evt) {
                    if (evt.getId() == PlaybackEvent.STOPPED) {
                        play();  // Restart the sound when playback is finished
                    }
                }
            });

            // Create a separate thread for playing the sound
            new Thread(() -> {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException | JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (player != null) {
            player.close();
        }
    }
}
