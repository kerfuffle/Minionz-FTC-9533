package com.minions.gamecode;

import com.minions.gamecode.DoNotRegister;
import com.minions.utils.Direction;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by doug on 11/14/2015.
 */
@DoNotRegister
public abstract class BaseRobotDrive {
    protected boolean reverse;
    protected DcMotor motorLeft, motorRight;
    protected float maxSpeed;
    protected Direction direction;

    public BaseRobotDrive(DcMotor motorLeft, DcMotor motorRight){
        this.motorLeft = motorLeft;
        this.motorRight = motorRight;

        this.motorLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    public void increaseMaxSpeed(){
        this.setSpeed(this.getSpeed() + 0.1f);
    }
    public void reduceMaxSpeed(){
        this.setSpeed(this.getSpeed() - 0.1f);
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
    public float getSpeed() {
        return  this.maxSpeed;
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

    public abstract void drive(Gamepad gamepad);
}
