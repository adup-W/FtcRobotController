package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class GamePadPractice extends OpMode {

    @Override
    public void init() {

    }

    //we write main code for gamepad in loop so we constantly get the info about position of buttons
    @Override
    public void loop() {
        double speedForward = -gamepad1.left_stick_y; // so our speed wont be negative when we push L3 forward
        double triggerSum = gamepad1.right_trigger + gamepad1.left_trigger;


        telemetry.addData("x", gamepad1.left_stick_x);
        telemetry.addData("y", speedForward);
        telemetry.addData("A button", gamepad1.a);
        telemetry.addData("rs_x", gamepad1.right_stick_x);
        telemetry.addData("rs_y", gamepad1.right_stick_y);
        telemetry.addData("b button", gamepad1.b);
        telemetry.addData("difference", gamepad1.right_stick_x - gamepad1.left_stick_x);
        telemetry.addData("triggerSum", triggerSum);
    }
}
