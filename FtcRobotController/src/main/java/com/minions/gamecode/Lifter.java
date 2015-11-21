package com.minions.gamecode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by FTC9533 on 11/20/2015.
 */
public class Lifter {

    DcMotor lifterMotor;
    DcMotor extenderMotor;

    public Lifter(DcMotor lifter, DcMotor extender) {
        this.lifterMotor = lifter;
        this.extenderMotor = extender;
    }

    public void RaiseArm(){
        this.SetLifterMotorPower(1.0f);
    }
    public void LowerArm() {
        this.SetLifterMotorPower(-1.0f);
    }
    public void StopLift(){
        this.SetLifterMotorPower(0.0f);
    }


    public void ExtendArm(){
        this.SetExtenderPower(1.0f);
    }
    public void RetractArm(){
        this.SetExtenderPower(-1.0f);
    }
    public void StopExtendRetract(){
        this.SetExtenderPower(0.0f);
    }

    private void SetExtenderPower(double power){
        power = Range.clip(power, 0.0f, 1.0f);
        this.extenderMotor.setPower(power);
    }

    private void SetLifterMotorPower(double power){
        power = Range.clip(power, 0.0f, 1.0f);
        this.lifterMotor.setPower(power);
    }
}
