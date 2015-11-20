package com.minions.gamecode;

import com.minions.utils.Button;
import com.minions.utils.Direction;
import com.minions.utils.GamepadHelper;
import com.minions.utils.IButtonChanged;
import com.minions.utils.Timer;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by doug on 11/8/2015.
 */
@Name("Minion Tele-Op")
public class MinionOp extends OpMode {

     //private final String HARDWARE_PlatformMotor = "platformMotor";
    private final String HARDWARE_LeftMotor = "leftMotor";
    private final String HARDWARE_RightMotor = "rightMotor";
    private final String HARDWARE_LeftArm = "leftArmServo";
    private final String HARDWARE_RightArm = "rightArmServo";

    GamepadHelper gamepadHelper1;
    GamepadHelper gamepadHelper2;

    Timer t = new Timer();
    TankDrive tankDrive;
    Platform platform;
    Arm leftArm, rightArm;

    @Override
    public void init() {
        tankDrive = new TankDrive(
                hardwareMap.dcMotor.get(HARDWARE_LeftMotor),
                hardwareMap.dcMotor.get(HARDWARE_RightMotor)
        );



        //platform = new Platform(hardwareMap.dcMotor.get(HARDWARE_PlatformMotor));

        this.tankDrive.setDirection(Direction.FORWARD);
        this.tankDrive.setSpeed(0.5f);

        configureGamepad1();
        //configureGamepad2();

        t.GetETime();
    }


    private void configureGamepad1(){
        gamepadHelper1 = new GamepadHelper(telemetry);


        gamepadHelper1.setButtonA(new Button(true, new IButtonChanged() {
            @Override
            public void buttonPressed() {
                telemetry.addData("ButtonHelper", "Button A pressed");
            }

            @Override
            public void buttonReleased() {
                telemetry.addData("ButtonHelper", "Button A released");
                tankDrive.switchDirection();
            }
        }
        ));


        //set tank to full speed
        Button y = new Button(true, new IButtonChanged() {
            @Override
            public void buttonPressed() {
                telemetry.addData("ButtonHelper", "Button Y pressed");
            }

            @Override
            public void buttonReleased() {
                tankDrive.setSpeed(10/10);
            }
        });
        gamepadHelper1.setButtonY(y);

        //set tank to slow speed
        Button x = new Button(true, new IButtonChanged() {
            @Override
            public void buttonPressed() {

            }

            @Override
            public void buttonReleased() {
                tankDrive.setSpeed(5/10);
            }
        });
        gamepadHelper1.setButtonX(x);

        gamepadHelper1.setLeftBumper(new Button(true, new IButtonChanged() {
            @Override
            public void buttonPressed() {

            }

            @Override
            public void buttonReleased() {
                tankDrive.reduceMaxSpeed();
            }
        }));

        gamepadHelper1.setRightBumper(new Button(true, new IButtonChanged() {
            @Override
            public void buttonPressed() {

            }

            @Override
            public void buttonReleased() {
                tankDrive.increaseMaxSpeed();
            }
        }));



        this.gamepad1 = gamepadHelper1.createGamepad();


    }

    private void configureGamepad2(){
        gamepadHelper2 = new GamepadHelper(telemetry);
        gamepadHelper2.setLeftBumper(new Button(true, new IButtonChanged() {
            @Override
            public void buttonPressed() {
                telemetry.addData("Platform", "Platform Raising...");
                platform.lower(0.8f);
            }

            @Override
            public void buttonReleased() {

            }
        }));
        gamepadHelper2.setRightBumper(new Button(true, new IButtonChanged() {
            @Override
            public void buttonPressed() {
                telemetry.addData("Platform", "Platform Lowering...");
                platform.raise(0.8f);
            }

            @Override
            public void buttonReleased() {

            }
        }));

        this.gamepad2 = gamepadHelper2.createGamepad();
    }

    @Override
    public void loop() {
        float etime = t.GetETime();

        this.gamepadHelper1.gamepadChanged(gamepad1);
        //this.gamepadHelper2.gamepadChanged(gamepad2);


        telemetry.addData("Text", "*** Robot Data***");
        this.tankDrive.drive(gamepad1);
        telemetry.addData("ETime", Float.toString(etime));


    }
}
