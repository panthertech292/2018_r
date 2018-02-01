package org.usfirst.frc.team292.robot.commands;

import org.usfirst.frc.team292.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurn extends Command {
private double targetAngle;
    public AutoTurn(double targetAngle) {
        requires(Robot.drivetrain);
        requires(Robot.navigation);
        this.targetAngle = targetAngle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetDistance();
    	Robot.navigation.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.navigation.gyro.getAngle();
    	if (targetAngle < 0) {
    		Robot.drivetrain.tankDrive.tankDrive(0.25,  -0.25);
    	}
    	if (targetAngle > 0) {
        	Robot.drivetrain.tankDrive.tankDrive(-0.25, 0.25);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.navigation.gyro.getAngle()) > Math.abs(targetAngle);
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.tankDrive.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
