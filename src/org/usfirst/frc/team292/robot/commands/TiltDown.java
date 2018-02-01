package org.usfirst.frc.team292.robot.commands;

import org.usfirst.frc.team292.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class TiltDown extends InstantCommand {

    public TiltDown() {
        requires(Robot.tilt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.tilt.tiltSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

}
