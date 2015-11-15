package com.minions.utils;

import android.widget.Toast;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.robocol.Telemetry;


public class GamepadHelper
        implements Gamepad.GamepadCallback {

    Button a = null;
    Button b = null;
    Button x = null;
    Button y = null;
    Button right_bumper = null;
    Button left_bumper = null;

    Telemetry telemetry;
    public GamepadHelper(Telemetry telemetry){
        //Toast t = new Toast();



        this.telemetry = telemetry;
//        b = new Button();
//        x = new Button();
//        y = new Button();
//        right_bumper = new Button();
//        left_bumper = new Button();
    }

    public void setButtonA(Button button){
        this.a = button;
    }
    public void setButtonB(Button button){
        this.b = button;
    }
    public void setButtonX(Button button){
        this.x = button;
    }
    public void setButtonY(Button button){
        this.y = button;
    }
    public void setRightBumper(Button button){
        this.right_bumper = button;
    }
    public void setLeftBumper(Button button){
        this.left_bumper = button;
    }



    public void gamepadChanged(Gamepad gamepad) {

        telemetry.addData("GamepadHelper", "gamepadChanged");

        if(a != null) {
            a.handleButton(gamepad.a);
        }
        if(b != null) {
            b.handleButton(gamepad.b);
        }
        if(x != null ) {
            x.handleButton(gamepad.x);
        }
        if(y!=null) {
            y.handleButton(gamepad.y);
        }
        if(right_bumper != null) {
            right_bumper.handleButton(gamepad.right_bumper);
        }
        if(left_bumper != null) {
            left_bumper.handleButton(gamepad.left_bumper);
        }
    }

    public Gamepad createGamepad(){
        return new Gamepad(this);
    }
}


