package org.usfirst.frc.team2141.robot.subsystems;

import org.usfirst.frc.team2141.robot.Robot;
import org.usfirst.frc.team2141.robot.RobotMap;
import org.usfirst.frc.team2141.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {

	private Spark rightMotor;
	private Spark leftMotor;
	private RobotDrive drive;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Chassis() {
		rightMotor = new Spark(4);
		leftMotor = new Spark(RobotMap.LEFT_MOTOR);
		drive = new RobotDrive(rightMotor, leftMotor);
		
		this.drive.setInvertedMotor(MotorType.kFrontLeft, true);
		this.drive.setInvertedMotor(MotorType.kFrontRight, true);
		
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoystick());
    }

    public void driveWithJoystick(Joystick driveStick) {
    	this.drive.arcadeDrive(driveStick);
    }

    
    
    
}

