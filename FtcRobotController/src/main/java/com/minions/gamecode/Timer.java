package com.minions.gamecode;

import android.os.SystemClock;


/**
 * Created by doug on 11/14/2015.
 */
public class Timer {

    private long lastTime = SystemClock.uptimeMillis();
    private float etime;

    public float GetETime(){
        etime = (SystemClock.uptimeMillis() - lastTime) / 1000.0f;
        lastTime = SystemClock.uptimeMillis();
        return  etime;
    }
}
