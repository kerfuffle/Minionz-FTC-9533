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
    private final String HARDWARE_LiftMotor = "liftMotor";
    private final String HARDWARE_ExtendMotor = "extendMotor";



    GamepadHelper gamepadHelper1;
    //GamepadHelper gamepadHelper2;

    Timer t = new Timer();
    TankDrive tankDrive;
//    Platform platform;
    Arm leftArm, rightArm;
    Lifter lifter;

    @Override
    public void init() {
        tankDrive = new TankDrive(
                hardwareMap.dcMotor.get(HARDWARE_LeftMotor),
                hardwareMap.dcMotor.get(HARDWARE_RightMotor)
        );

        //lifter = new Lifter(hardwareMap.dcMotor.get(HARDWARE_LiftMotor), hardwareMap.dcMotor.get(HARDWARE_ExtendMotor));


        leftArm = new Arm(hardwareMap.servo.get(HARDWARE_LeftArm), 0.1f, 0.85f, true, this.telemetry);
        rightArm = new Arm(hardwareMap.servo.get(HARDWARE_RightArm), 0.1f, 0.85f, false, this.telemetry);

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

//    private void configureGamepad2(){
//        gamepadHelper2 = new GamepadHelper(telemetry);
//        gamepadHelper2.setLeftBumper(new Button(true, new IButtonChanged() {
//            @Override
//            public void buttonPressed() {
//                telemetry.addData("Arm", "Arm retracting...");
//                //platform.lower(0.8f);
//                lifter.RetractArm();
//            }
//
//            @Override
//            public void buttonReleased() {
//                lifter.StopExtendRetract();
//            }
//        }));
//        gamepadHelper2.setRightBumper(new Button(true, new IButtonChanged() {
//            @Override
//            public void buttonPressed() {
//                telemetry.addData("Arm", "Arm extending...");
//                //platform.raise(0.8f);
//                lifter.ExtendArm();
//            }
//
//            @Override
//            public void buttonReleased() {
//                lifter.StopExtendRetract();
//            }
//        }));
//
//
//        gamepadHelper2.setDPadDown(new Button(true, new IButtonChanged() {
//            @Override
//            public void buttonPressed() {
//                //lower arm
//
//            }
//
//            @Override
//            public void buttonReleased() {
//                //stop lower arm
//            }
//        }));
//
//        gamepadHelper2.setDPadUp(new Button(true, new IButtonChanged() {
//            @Override
//            public void buttonPressed() {
//                //raise arm
//            }
//
//            @Override
//            public void buttonReleased() {
//                //stop raise arm
//            }
//        }));
//        this.gamepad2 = gamepadHelper2.createGamepad();
//    }

    @Override
    public void loop() {
        float etime = t.GetETime();

        this.gamepadHelper1.gamepadChanged(gamepad1);
        //this.gamepadHelper2.gamepadChanged(gamepad2);


        telemetry.addData("Text", "*** Robot Data***");
        this.tankDrive.drive(gamepad1);
        telemetry.addData("ETime", Float.toString(etime));


        this.leftArm.setPosition(gamepad2);
        this.rightArm.setPosition(gamepad2);


    }
}
