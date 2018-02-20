package org.usfirst.frc.team2141.robot;

import org.usfirst.frc.team2141.robot.commands.ExtraValve_Open;
import org.usfirst.frc.team2141.robot.commands.Extra_Close;
import org.usfirst.frc.team2141.robot.commands.Intake_Close;
import org.usfirst.frc.team2141.robot.commands.Intake_Open;
import org.usfirst.frc.team2141.robot.commands.Elevator_Lower;
import org.usfirst.frc.team2141.robot.commands.Elevator_Raise;
import org.usfirst.frc.team2141.robot.commands.CurrentLimiting_Disable;
import org.usfirst.frc.team2141.robot.commands.Compressor_Enable;
import org.usfirst.frc.team2141.robot.commands.CurrentLimiting_Enable;
import org.usfirst.frc.team2141.robot.commands.Elevator_ShiftUp;
import org.usfirst.frc.team2141.robot.commands.Elevator_ShiftDown;
import org.usfirst.frc.team2141.robot.commands.Chassis_TestLeft;
import org.usfirst.frc.team2141.robot.commands.Chassis_TestRight;
import org.usfirst.frc.team2141.robot.commands.Elevator_Stop;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private Joystick driveStick;
	private JoystickButton[] driveButtons;
	private Joystick auxiliaryStick;
	private JoystickButton[] auxiliaryButtons;
	
	public OI() {

		driveStick = new Joystick(RobotMap.DRIVE_STICK_NUMBER);
		driveButtons = new JoystickButton[13];

		auxiliaryStick = new Joystick(RobotMap.AUXILLIARY_STICK_NUMBER);
		auxiliaryButtons = new JoystickButton[13];
		
		for(int i = 1; i <= driveButtons.length - 1; i++) {
			driveButtons[i] = new JoystickButton(driveStick, i);
		}
		
		for(int i=1; i <= auxiliaryButtons.length - 1; i++){
			auxiliaryButtons[i] = new JoystickButton(auxiliaryStick, i);
		}

		//this.getButton(RobotMap.SHOOTER_CONTROL_BUTTON).whileHeld(new ShooterControl());
		
		
		//this.getButton(10, true).whenPressed(new DriveStraight(4 * Math.PI));
		//this.getButton(11, true).whileHeld(new DriveAtVelocity(0.25));
		this.getButton(8, true).whenPressed(new Chassis_TestLeft());
		this.getButton(9, true).whenPressed(new Chassis_TestRight());
		//this.getButton(3).whenPressed(new DriveAtSpeed());
		
		this.getButton(5).whileHeld(new Elevator_Raise());
		this.getButton(6).whileHeld(new Elevator_Lower());
		this.getButton(1).whenPressed(new Elevator_Stop());
		this.getButton(9).whenPressed(new CurrentLimiting_Enable());
		this.getButton(10).whenPressed(new CurrentLimiting_Disable());
		
		this.getButton(3, true).whenPressed(new Elevator_ShiftUp());
		this.getButton(2, true).whenPressed(new Elevator_ShiftDown());
		this.getButton(5, true).whenPressed(new Intake_Open());
		this.getButton(4, true).whenPressed(new Intake_Close());
		//this.getButton(10, true).whenPressed(new Extra_Close());
		//this.getButton(11, true).whenPressed(new ExtraValve_Open());
		
		this.getButton(1, true).whileHeld(new Compressor_Enable());
		
		//this.getButton(RobotMap.SHOOTER_CONTROL_BUTTON).whileHeld(new ShooterControl());
	}
	
	public Joystick getDriveStick() {
		return driveStick;
	}

	public double getLeftX(){
		return driveStick.getRawAxis(0);
	}
	
	
	public double getLeftY(){
		return driveStick.getRawAxis(1);
	}
	
	public double getRightX(){
		return driveStick.getRawAxis(4);
	}
	
	public double getRightY(){
		return driveStick.getRawAxis(5);
	}
	
	public boolean getButtonValue(int buttonNum) {
		return this.driveButtons[buttonNum].get();
	}

	public boolean getButtonValue(int buttonNum, boolean auxiliary) {
		if(auxiliary){
			return this.auxiliaryButtons[buttonNum].get();
		}else{		
			return this.driveButtons[buttonNum].get();
		}
	}
	public JoystickButton getButton(int buttonNum) {
		return this.driveButtons[buttonNum];
	}
	
	public JoystickButton getButton(int buttonNum, boolean auxiliary) {
		if(auxiliary){
			return this.auxiliaryButtons[buttonNum];
		}else{
			return this.driveButtons[buttonNum];
		}
	}
	
	public void rumbleLeftJoystick(int rumbleValue) {
		this.driveStick.setRumble(RumbleType.kLeftRumble, rumbleValue);
	}
	
	public void rumbleRightJoystick(int rumbeValue) {
		this.driveStick.setRumble(RumbleType.kRightRumble, rumbeValue);
	}
}