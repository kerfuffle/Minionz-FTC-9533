package com.minions.gamecode;

import com.minions.utils.Button;
import com.minions.utils.Direction;
import com.minions.utils.GamepadHelper;
import com.minions.utils.IButtonChanged;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by doug on 11/8/2015.
 */
@Name("Minion Tele-Op")
public class MinionOp extends OpMode {

    GamepadHelper gamepadHelper1;
    Timer t = new Timer();
    TankDrive tankDrive;

    @Override
    public void init() {
        tankDrive = new TankDrive(
                hardwareMap.dcMotor.get("leftMotor"),
                hardwareMap.dcMotor.get("rightMotor")
        );

        this.tankDrive.setDirection(Direction.FORWARD);
        configureGamepad1();
        t.GetETime();
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
        gamepadHelper1.setButtonA(a);


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
        gamepadHelper1.setButtonY(y);

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
        gamepadHelper1.setButtonX(x);

        gamepadHelper1.setLeftBumper(new Button(true, new IButtonChanged() {
            @Override
            public void buttonPressed() {

            }

            @Override
            public void buttonReleased() {

            }
        }));



        this.gamepad1 = new Gamepad(gamepadHelper1);


    }


    @Override
    public void loop() {
        float etime = t.GetETime();
    }
}
