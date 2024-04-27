package com.example.pianoapp.utils;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.example.pianoapp.R;
import java.util.ArrayList;
import java.util.logging.LogRecord;

public class SoundManager {
    private SoundPool mSoundPool;
    private SparseIntArray mSoundPoolMap;
    private boolean mMute = false;
    private Context context;

    private static final int MAX_STREAMS = 10;
    private static final int STOP_DELAY_MILLIS = 10000;
    private Handler mHandler;

    private static SoundManager instance;
    public ArrayList<Integer> soundListWhiteKey = new ArrayList<Integer>();
    public ArrayList<Integer> soundListBlackKey = new ArrayList<Integer>();

    public static SoundManager getInstance() {
        if (instance == null) {
            instance = new SoundManager();
        }
        return instance;
    }

    public SoundManager() {
        mSoundPool = new SoundPool(MAX_STREAMS, android.media.AudioManager.STREAM_MUSIC, 0);
        mSoundPoolMap = new SparseIntArray();
        mHandler = new Handler();
    }

    public void initStreamTypeMedia(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    public void addSound(int soundID) {
        mSoundPoolMap.put(soundID, mSoundPool.load(context, soundID, 1));
    }

    public void playSound(int soundID) {
        if (!mMute) {
            mSoundPool.play(mSoundPoolMap.get(soundID), 1, 1, 1, 0, 1f);
            mHandler.postDelayed(() -> stopSound(soundID), STOP_DELAY_MILLIS);
        }
    }

    private void stopSound(int soundID) {
        mSoundPool.stop(mSoundPoolMap.get(soundID));
    }

    public void init(Context context) {
        this.context = context;
        instance.initStreamTypeMedia((Activity) context);

        soundListWhiteKey.add(R.raw.c3);
        soundListWhiteKey.add(R.raw.d3);
        soundListWhiteKey.add(R.raw.e3);
        soundListWhiteKey.add(R.raw.f3);
        soundListWhiteKey.add(R.raw.g3);
        soundListWhiteKey.add(R.raw.a3);
        soundListWhiteKey.add(R.raw.b3);
        soundListWhiteKey.add(R.raw.c4);
        soundListWhiteKey.add(R.raw.d4);
        soundListWhiteKey.add(R.raw.e4);
        soundListWhiteKey.add(R.raw.f4);
        soundListWhiteKey.add(R.raw.g4);
        soundListWhiteKey.add(R.raw.a4);
        soundListWhiteKey.add(R.raw.b4);

        soundListBlackKey.add(R.raw.db3);
        soundListBlackKey.add(R.raw.eb3);
        soundListBlackKey.add(R.raw.gb3);
        soundListBlackKey.add(R.raw.ab3);
        soundListBlackKey.add(R.raw.bb3);
        soundListBlackKey.add(R.raw.db4);
        soundListBlackKey.add(R.raw.eb4);
        soundListBlackKey.add(R.raw.gb4);
        soundListBlackKey.add(R.raw.ab4);
        soundListBlackKey.add(R.raw.bb4);

        for (int i = 0; i < soundListWhiteKey.size(); i++) {
            addSound(soundListWhiteKey.get(i));
        }

        for (int i = 0; i < soundListBlackKey.size(); i++) {
            addSound(soundListBlackKey.get(i));
        }
    }
}
