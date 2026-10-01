package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.robocol.RobocolParsable;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class MecanumDrive {
    private DcMotor rightFrontMotor, leftFrontMotor, rightBackMotor, leftBackMotor;
    private IMU imu;

    public void init(HardwareMap hwMap) {
        rightFrontMotor = hwMap.get(DcMotor.class, "rightFront");
        leftFrontMotor = hwMap.get(DcMotor.class, "leftFront");
        rightBackMotor = hwMap.get(DcMotor.class, "rightBack");
        leftBackMotor = hwMap.get(DcMotor.class, "leftBack");

        leftFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        imu = hwMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot revHubOrientationOnRobot = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);
        imu.initialize(new IMU.Parameters(revHubOrientationOnRobot));
    }

    public void drive(double forward, double strafe, double rotate) {
        double frontLeftPower = forward + strafe + rotate;
        double backLeftPower = forward - strafe + rotate;
        double frontRightPower = forward - strafe - rotate;
        double backRightPower = forward + strafe - rotate;


        double maxSpeed = 0.3;

        double maxPower = Math.max(1.0, Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower)));
        maxPower = Math.max(maxPower, Math.max(Math.abs(backLeftPower), Math.abs(backRightPower)));

        rightFrontMotor.setPower(frontRightPower / maxPower);
        rightBackMotor.setPower(backRightPower / maxPower);
        leftFrontMotor.setPower(frontLeftPower / maxPower);
        leftBackMotor.setPower(backLeftPower / maxPower);
    }

    public void driveFieldRelative(double forward, double strafe, double rotate) {
        double theta = Math.atan2(forward, strafe);
        double r = Math.hypot(strafe, forward);

        theta = AngleUnit.normalizeRadians(theta -
                imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));

        double newForward = r * Math.sin(theta);
        double newStrafe = r * Math.cos(theta);

        this.drive(newForward, newStrafe, rotate);
    }
}
