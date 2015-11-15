package com.minions.utils;

import android.os.SystemClock;

import com.minions.gamecode.DoNotRegister;


/**
 * Created by doug on 11/14/2015.
 */
@DoNotRegister
public class Timer {

    private long lastTime = SystemClock.uptimeMillis();
    private float etime;

    public float GetETime(){
        etime = (SystemClock.uptimeMillis() - lastTime) / 1000.0f;
        lastTime = SystemClock.uptimeMillis();
        return  etime;
    }
}
