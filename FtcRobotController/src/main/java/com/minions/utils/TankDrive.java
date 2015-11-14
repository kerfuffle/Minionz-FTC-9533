package com.minions.utils;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by doug on 11/8/2015.
 */
public class TankDrive {

    boolean reverse;
    float maxSpeed;
    DcMotor motorLeft, motorRight;
    Direction direction;

    public TankDrive(DcMotor motorLeft, DcMotor motorRight){
        this.motorLeft = motorLeft;
        this.motorRight = motorRight;

        this.motorLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    public void setDirection(Direction direction){
        this.direction = direction;

        switch (this.direction){
            case FORWARD:
                this.motorLeft.setDirection(DcMotor.Direction.REVERSE);
                this.motorRight.setDirection(DcMotor.Direction.FORWARD);
                break;
            case REVERSE:
                this.motorLeft.setDirection(DcMotor.Direction.FORWARD);
                this.motorRight.setDirection(DcMotor.Direction.REVERSE);
                break;
        }

    }

    public void DriveTank(Gamepad gamepad) {

        float left = -gamepad.left_stick_y;
        float right = -gamepad.right_stick_y;

    }

    public void setSpeed(float speed){
        this.maxSpeed = Range.clip(speed, 0, 1);
    }

    public void switchDirection(){
        if(this.direction == Direction.FORWARD) {
            setDirection(Direction.REVERSE);
        } else {
            setDirection(Direction.FORWARD);
        }
    }

    public static enum Direction {
        FORWARD,
        REVERSE;

        private Direction() {
        }
    }
}
