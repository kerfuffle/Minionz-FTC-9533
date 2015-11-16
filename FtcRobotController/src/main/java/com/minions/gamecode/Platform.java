package com.minions.gamecode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by FTC9533 on 11/15/2015.
 */

@DoNotRegister
public class Platform
{
    private DcMotor motor;

    public Platform(DcMotor motor)
    {
        this.motor = motor;
    }

    /**
     * Raises the platform
     * @param speed     speed to raise platform
     */
    public void raise(float speed)
    {
        if (correctRange(speed))
        {
            motor.setPower(speed);
        }
    }
    /**
     * Lowers the Platform
     * @param speed     speed to lower platform
     */
    public void lower(float speed)
    {
        if (correctRange(speed))
        {
            motor.setPower(speed);
        }
    }


    /**
     * Checks if input speed is valid for DcMotor (between -1 and 1)
     * @param speed     input to check
     * @return
     */
    private boolean correctRange(float speed)
    {
        if (speed < -1 || speed > 1)
        {
            return false;
        }
        return true;
    }
}
