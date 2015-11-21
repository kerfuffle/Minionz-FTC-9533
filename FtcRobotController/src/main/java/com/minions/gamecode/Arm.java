package com.minions.gamecode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robocol.Telemetry;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by FTC9533 on 11/20/2015.
 */
public class Arm {

    Servo servo;
    double min;
    double max;
    boolean useLeft;
    Telemetry telemetry;
    public Arm(Servo servo, double min, double max, boolean useLeft, Telemetry telemetry)
    {
        this.telemetry = telemetry;
        this.servo = servo;
        this.min = min;
        this.max = max;
        this.useLeft = useLeft;

        this.servo.scaleRange(min, max);
    }

    public void setPosition(Gamepad gamepad) {

        double stick = this.useLeft ? gamepad.left_stick_x + 1 : gamepad.right_stick_x;
        double x = (stick);


        // -1 == 0, 0 == 1
        //double x = Math.abs(stick);

        x = Range.clip(x, 0.0f, 1.0f);
        telemetry.addData(useLeft? "Left" : "Right" + "Arm", x);
        this.servo.setPosition(x);
    }

//    public void move()
//    {
//        servo.setPosition(0.8);
//    }
//
//    public void lower()
//    {
//
//    }
//    public void raise()
//    {
//
//    }

}
