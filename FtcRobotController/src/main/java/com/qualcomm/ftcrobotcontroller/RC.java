package com.qualcomm.ftcrobotcontroller;

import android.app.Application;
import android.content.Context;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by doug on 11/14/2015.
 */
public class RC extends Application {

    public static Context c;
    public static OpMode m;


    public void onCreate(){
        super.onCreate();
        c = getApplicationContext();
    }
}
