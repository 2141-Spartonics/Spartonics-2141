package org.usfirst.frc.team2141.robot.commands.chassis;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

import org.usfirst.frc.team2141.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PathAuto extends CommandGroup {

    public PathAuto() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new GenerateProfile(
    			 new Waypoint[] {
    				new Waypoint(0, 0, 0),
    				new Waypoint(98.35, -24.46, Pathfinder.d2r(45)),
    				//new Waypoint(104.5, 16.35, Pathfinder.d2r(60))
    				}, 
    			new Trajectory.Config(
    				Trajectory.FitMethod.HERMITE_CUBIC,
    				Trajectory.Config.SAMPLES_HIGH, RobotMap.PROFILE_DT, 30, 20, 240.0)));
    	
    }
}
