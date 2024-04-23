package com.example.pianoapp.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.SparseArray;
import android.util.SparseIntArray;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class SoundManager {
    private SoundPool mSoundPool;
    private SparseIntArray mSoundPoolMap;
    private boolean mMute =false;
    private Context mContext ;



    private static final int MAX_STREAM =10;
    private static final int STOP_DELAY_MILL = 10000;
    private Handler mHandler;




    private static SoundManager instance= null;


    public SoundManager(){
        mSoundPool = new SoundPool(MAX_STREAM,
                AudioManager.STREAM_MUSIC,
                0);

        mSoundPoolMap = new SparseIntArray();
        mHandler = new Handler() {

        };

    }
}
