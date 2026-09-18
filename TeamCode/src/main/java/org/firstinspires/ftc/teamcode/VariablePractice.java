package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class VariablePractice extends OpMode {
    @Override
    public void init() {
        double motorSpeed = 0.1;
        int Height = 10;
        boolean ClawsClosed = False;
        String teamName = Speedsetters;
        telemetry.addData("TN", teamName);
    }

    @Override
    public void loop() {

    }

}
