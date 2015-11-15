package com.minions.gamecode;

import com.minions.gamecode.BaseRobotDrive;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by doug on 11/8/2015.
 */
@DoNotRegister
public class TankDrive extends BaseRobotDrive {



    public TankDrive(DcMotor motorLeft, DcMotor motorRight){
        super(motorLeft, motorRight);
    }

    @Override
    public void drive(Gamepad gamepad) {
        float left = -gamepad.left_stick_y;
        float right = -gamepad.right_stick_y;

        left = Range.clip(left, this.maxSpeed*-1, this.maxSpeed);
        right = Range.clip(right, this.maxSpeed*-1, this.maxSpeed);

        this.motorRight.setPower(right);
        this.motorLeft.setPower(left);


    }
}





