package com.minions.gamecode;

import com.minions.gamecode.BaseRobotDrive;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by doug on 11/8/2015.
 */
public class TankDrive extends BaseRobotDrive {



    public TankDrive(DcMotor motorLeft, DcMotor motorRight){
        super(motorLeft, motorRight);
    }



    public void DriveTank(Gamepad gamepad) {

        float left = -gamepad.left_stick_y;
        float right = -gamepad.right_stick_y;




    }









}





