package com.minions.gamecode;

import android.hardware.SensorManager;

import com.qualcomm.hardware.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;

import java.util.ArrayList;

/**
 * Created by FTC9533 on 11/15/2015.
 */
public class Autonomous extends OpMode {


    GyroSensor gyro;
    final int STANDARDPOS = 616;
    final int RANGE = 2;

    public void init()
    {
        gyro = hardwareMap.gyroSensor.get("gyro");
    }


    String move = "notmoved";
    public void loop()
    {


        if (gyro.getRotation() < STANDARDPOS-RANGE)
        {
            move = "left";
            //moving left
        }
        if (gyro.getRotation() > STANDARDPOS+RANGE)
        {
            move = "right";
            //moving right
        }


        telemetry.addData("move", move);


    }

}
