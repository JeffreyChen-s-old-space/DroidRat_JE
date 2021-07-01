package com.je_chen.droidrat_je.util.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class Singleton_MediaPlayer {

    private static final String TAG = Singleton_MediaPlayer.class.getName();

    private static Singleton_MediaPlayer instance;
    private MediaPlayer MediaPlayer;

    public static Singleton_MediaPlayer instance() {
        if (instance == null) instance = new Singleton_MediaPlayer();
        return instance;
    }

    protected void Start_Background_Music(Context context, int res) {
        if (MediaPlayer == null) {
            MediaPlayer = android.media.MediaPlayer.create(context, res);
            MediaPlayer.setLooping(true);
        }
        if (MediaPlayer != null && !MediaPlayer.isPlaying())
            Log.i(TAG, "started");
        assert MediaPlayer != null;
        MediaPlayer.start();
    }

    protected void Stop_Music() {
        if (MediaPlayer != null) {
            Log.i(TAG, "Stop");
            MediaPlayer.stop();
            MediaPlayer.reset();
            MediaPlayer.release();
            MediaPlayer = null;
        }
    }

    protected boolean Playing_Check() {
        if (MediaPlayer != null)
            return MediaPlayer.isPlaying();
        return false;
    }
}
