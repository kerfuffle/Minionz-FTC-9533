package com.minions.utils;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by doug on 11/8/2015.
 */
public class MinionOp extends OpMode {

    GamepadHelper gamepadHelper1;

    TankDrive tankDrive;

    @Override
    public void init() {
        tankDrive = new TankDrive(
                hardwareMap.dcMotor.get("leftMotor"),
                hardwareMap.dcMotor.get("rightMotor")
        );

        this.tankDrive.setDirection(TankDrive.Direction.FORWARD);
        configureGamepad1();
    }


    private void configureGamepad1(){
        gamepadHelper1 = new GamepadHelper();

        Button a = new Button(true, new IButtonChanged() {
                @Override
                public void buttonPressed() {

                }

                @Override
                public void buttonReleased() {
                    tankDrive.switchDirection();
                }
            }
        );

        //set tank to full speed
        Button y = new Button(true, new IButtonChanged() {
            @Override
            public void buttonPressed() {

            }

            @Override
            public void buttonReleased() {
                tankDrive.setSpeed(10/10);
            }
        });

        //set tank to slow speed
        Button x = new Button(true, new IButtonChanged() {
            @Override
            public void buttonPressed() {

            }

            @Override
            public void buttonReleased() {
                tankDrive.setSpeed(1/10);
            }
        });





        this.gamepad1 = new Gamepad(gamepadHelper1);


    }


    @Override
    public void loop() {

    }
}
