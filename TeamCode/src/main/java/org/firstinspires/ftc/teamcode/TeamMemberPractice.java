package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
public class TeamMemberPractice extends OpMode {
RobotLocationPractice robotLocationPractice = new RobotLocationPractice(0);

    @Override
    public void init() {
        robotLocationPractice.setX(0);// we are calling the method from other class , like we have properties of that method but value we are setting is our own.
        robotLocationPractice.setY(0);
    }

    @Override
    public void loop() {
        if (gamepad1.dpad_left) {
            robotLocationPractice.changeX(0.1);
        }
        else if (gamepad1.dpad_right) {
            robotLocationPractice.changeX(-0.1);
        }

        if (gamepad1.dpad_up) {
            robotLocationPractice.changeY(-0.1);
        }
        else if(gamepad1.dpad_down) {
            robotLocationPractice.changeY(0.1);
        }






        telemetry.addData("Current x value", robotLocationPractice.xGet());
        telemetry.addData("Change y value", robotLocationPractice.getY());
    }
    }

