package org.usfirst.frc.team2141.robot.subsystems;

import org.usfirst.frc.team2141.robot.Robot;
import org.usfirst.frc.team2141.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {
	private CANTalon winchMotor;
	private DoubleSolenoid winchBrake;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public Winch() {
		winchMotor = new CANTalon(RobotMap.WINCH_MOTOR);
		winchMotor.changeControlMode(TalonControlMode.Voltage);
		winchBrake = new DoubleSolenoid(RobotMap.WINCH_STOPPER_CHANNEL_A, RobotMap.WINCH_STOPPER_CHANNEL_B);
		
	}

	/**
	 * Sets the the winchMotor to speed
	 * 
	 * @param speed the speed the motor is set to
	 */
	public void setWinchSpeed(double speed) {
		this.winchMotor.set(speed * 12);
	}

	/**
	 * Turns off the brake for the winch
	 */
	public void putBrakeOff() {
		this.winchBrake.set(DoubleSolenoid.Value.kForward);
	}

	/**
	 * Stops the winch from moving
	 */
	public void putBrakeOn() {
		this.winchBrake.set(DoubleSolenoid.Value.kReverse);
	}

	/**
	 * Reads how much current is going into the winchMotor
	 * 
	 * @return the amount of current used for the winchMotor
	 */
	public double getCurrent() {
		return Robot.PDP.getCurrent(RobotMap.WINCH_PDP_CHANNEL);
	}

}
