package org.firstinspires.ftc.teamcode;

public class RobotLocationPractice {

    double y;
    double x;

    //constructure method

    //for the x value
    public void changeX(double changeValueX) {
        x = x + changeValueX;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getX() {
        return this.x;
    }

    //for the y value
    public void changeY(double changeValueY) {
        y += changeValueY;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY(double y) {
        return this.y;
    }
}
