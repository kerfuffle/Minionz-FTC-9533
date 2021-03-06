/* Copyright (c) 2014, 2015 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.minions.gamecode.Autonomous;
import com.minions.gamecode.DoNotRegister;
import com.minions.gamecode.MinionOp;
import com.minions.gamecode.Name;
import com.minions.gamecode.ScratchOp;
import com.qualcomm.ftcrobotcontroller.RC;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;
import com.qualcomm.robotcore.eventloop.opmode.OpModeRegister;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import dalvik.system.DexFile;

/**
 * Register Op Modes
 */
@DoNotRegister
public class FtcOpModeRegister implements OpModeRegister {

  /**
   * The Op Mode Manager will call this method when it wants a list of all
   * available op modes. Add your op mode to the list to enable it.
   *
   * @param manager op mode manager
   */
  public void register(OpModeManager manager) {

    /*
     * register your op modes here.
     * The first parameter is the name of the op mode
     * The second parameter is the op mode class property
     *
     * If two or more op modes are registered with the same name, the app will display an error.
     */

    manager.register("NullOp", NullOp.class);

    //manager.register("MatrixK9TeleOp", MatrixK9TeleOp.class);
//    manager.register("K9TeleOp", K9TeleOp.class);
//    manager.register("K9Line", K9Line.class);
//    manager.register ("PushBotAuto", PushBotAuto.class);
//    manager.register ("PushBotManual", PushBotManual.class);

    //registerOpModes("gamecode", manager);
    manager.register("Minions", MinionOp.class);
    manager.register("Autonomous", Autonomous.class);
    manager.register("Scratch", ScratchOp.class);

    /*
     * Uncomment any of the following lines if you want to register an op mode.
     */
    //manager.register("MR Gyro Test", MRGyroTest.class);

    //manager.register("AdafruitRGBExample", AdafruitRGBExample.class);
    //manager.register("ColorSensorDriver", ColorSensorDriver.class);

    //manager.register("IrSeekerOp", IrSeekerOp.class);
    //manager.register("CompassCalibration", CompassCalibration.class);
    //manager.register("I2cAddressChangeExample", LinearI2cAddressChange.class);


    //manager.register("NxtTeleOp", NxtTeleOp.class);

    //manager.register("LinearK9TeleOp", LinearK9TeleOp.class);
    //manager.register("LinearIrExample", LinearIrExample.class);


    //manager.register ("PushBotManual1", PushBotManual1.class);
    //manager.register ("PushBotAutoSensors", PushBotAutoSensors.class);
    //manager.register ("PushBotIrEvent", PushBotIrEvent.class);

    //manager.register ("PushBotManualSensors", PushBotManualSensors.class);
    //manager.register ("PushBotOdsDetectEvent", PushBotOdsDetectEvent.class);
    //manager.register ("PushBotOdsFollowEvent", PushBotOdsFollowEvent.class);
    //manager.register ("PushBotTouchEvent", PushBotTouchEvent.class);

    //manager.register("PushBotDriveTouch", PushBotDriveTouch.java);
    //manager.register("PushBotIrSeek", PushBotIrSeek.java);
    //manager.register("PushBotSquare", PushBotSquare.java);
  }

  public void registerOpModes(String packageName, OpModeManager manager) {
    int counter = 0;

    try{
      String packageCodePath = RC.c.getPackageCodePath();
      DexFile df = new DexFile(packageCodePath);

      for(Enumeration<String> iter = df.entries();iter.hasMoreElements() && counter < 15;){
        String className = iter.nextElement();

        if(className.contains(packageName) && !className.contains("$") && !Class.forName(className).isAnnotationPresent(DoNotRegister.class)) {
          Class opMode = Class.forName(className);

          if(opMode.isAssignableFrom(OpMode.class)) {

            if (opMode.isAnnotationPresent(Name.class)) {
              manager.register(((Name) opMode.getAnnotation(Name.class)).value(), Class.forName(className));
              counter++;
            } else {
              counter++;
              //Log.i("Class Name", className);
              manager.register(className.substring(className.lastIndexOf('.') + 1), Class.forName(className));

            }
          }
        }

      }

    }catch(IOException e){

    }catch (ClassNotFoundException e){

    }


  }
}
