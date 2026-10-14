package org.firstinspires.ftc.teamcode.mechanisms;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class TestBench {
    private DcMotor motor;

    public void inIt(HardwareMap hwMap) {

        //DcMotor
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    //Allows values from -1.0 to 1.0
    public void setMotorSpeed(double speed) {
        motor.setPower(speed);


    }
}
