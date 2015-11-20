package com.minions.gamecode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by FTC9533 on 11/20/2015.
 */
public class Arm {

    Servo servo;
    Gamepad gamepad;

    public Arm(Servo servo, Gamepad gamepad)
    {
        this.servo = servo;
        this.gamepad = gamepad;
    }

    public void move()
    {
        servo.setPosition(0.8);
    }

    public void lower()
    {

    }
    public void raise()
    {

    }

}
