package com.example.labmaj;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundManager {
    private MediaPlayer mediaPlayer;

    public SoundManager(Context context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.bounce);
    }

    public void playBounceSound() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void release() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}