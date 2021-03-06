package org.usfirst.frc.team2141.robot.commands;

import org.usfirst.frc.team2141.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Elevator_Raise extends Command {

	public Elevator_Raise() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.elevator);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.elevator.setPercentOutput(1.0);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Robot.elevator.getUppwerSwitch()) {
			return false;
		} else {
			return true;
		}

	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.elevator.setPercentOutput(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.elevator.setPercentOutput(0);
	}
}
