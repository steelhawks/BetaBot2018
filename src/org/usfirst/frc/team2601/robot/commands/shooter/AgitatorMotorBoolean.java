package org.usfirst.frc.team2601.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AgitatorMotorBoolean extends Command {

    public AgitatorMotorBoolean() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.shooter.agitatorMotor.set(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    //	Robot.shooter.agitator =! Robot.shooter.agitator;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
