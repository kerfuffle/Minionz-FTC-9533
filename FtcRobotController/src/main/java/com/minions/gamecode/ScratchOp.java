package com.minions.gamecode;

import com.minions.utils.Timer;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import java.util.Random;

/**
 * Created by FTC9533 on 11/20/2015.
 */
public class ScratchOp extends OpMode {

    //Arm arm;
    Timer t = new Timer();
    Servo serv;

    public void init()
    {
        serv = hardwareMap.servo.get("arm");
        t.GetETime();
        ///arm = new Arm(hardwareMap.servo.get("arm"), gamepad2);
    }
    public void loop()
    {
        float etime = t.GetETime();
        //serv.scaleRange(-1, 1);
        double x = (gamepad2.left_stick_x + 1) / 2;

        x = Range.clip(x, 0, .75);
        serv.setPosition(x);
        telemetry.addData("Servo", Double.toString(serv.getPosition()));
        //arm.move();
        telemetry.addData("ETime", Float.toString(etime));
    }

}
