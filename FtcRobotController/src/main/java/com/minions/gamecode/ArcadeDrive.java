package com.minions.gamecode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by doug on 11/15/2015.
 */

public class ArcadeDrive extends BaseRobotDrive {

    public ArcadeDrive(DcMotor motorLeft, DcMotor motorRight){
        super(motorLeft, motorRight);
    }

    @Override
    public void increaseMaxSpeed() {

    }

    @Override
    public void reduceMaxSpeed() {

    }

    @Override
    public float getSpeed() {
        return 0;
    }

    @Override
    public void setSpeed(float speed) {

    }

    @Override
    public void switchDirection() {

    }
}