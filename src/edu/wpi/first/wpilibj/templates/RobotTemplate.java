/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    DoubleSolenoid[] DS;
    Joystick stick;

    public void robotInit() {
        DS = new DoubleSolenoid[4];
        for (int i = 0; i < 4; i++) {
            DS[i] = new DoubleSolenoid(2, i + 1, i + 5);
        }
        stick = new Joystick(1);
    }

    public void autonomous() {
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {

        while (this.isEnabled() && this.isOperatorControl()) {
            System.out.println("yo");
            if (stick.getTrigger()) {
                for (int i = 0; i < 4; i++) {
                    DS[i].set(DoubleSolenoid.Value.kForward);;
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    DS[i].set(DoubleSolenoid.Value.kReverse);;
                }
            }
        }

    }

    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    }
}
