package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class IfPravtice extends OpMode {

    @Override
    public void init() {

    }
//a basic code to see if L3 is not moving and how its value is changing after its movement
    @Override
    public void loop() {
       double motorSpeed = gamepad1.left_stick_y;
       if (!gamepad1.a) {
           motorSpeed = motorSpeed * 0.5;
       }
    }

