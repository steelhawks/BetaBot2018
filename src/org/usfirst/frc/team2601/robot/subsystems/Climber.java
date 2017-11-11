package org.usfirst.frc.team2601.robot.subsystems;

import org.usfirst.frc.team2601.robot.Constants;
import org.usfirst.frc.team2601.robot.Robot;
import org.usfirst.frc.team2601.robot.commands.climber.Climb;
import org.usfirst.frc.team2601.robot.commands.climber.ClimbButton;

import com.ctre.phoenix.MotorControl.CAN.TalonSRX;
import com.ctre.phoenix.MotorControl.SmartMotorController.TalonControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Constants constants = Constants.getInstance();
	TalonSRX climberM = new TalonSRX(constants.climbM);
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new ClimbButton());
    }
    
    
    //Method to start climb motor
    public void climb(Joystick stick){
    	double speed = Math.abs(stick.getY());
    	
    	climberM.set(-speed);
   		//climberM.set(speed);//easy change between directions
    }
    //Code for climb button
    public void climbButton(){
    	if(climberM.get() == 0){
    		Robot.compressor.stop();//power management
    		climberM.set(1);
    	}else{
    		Robot.compressor.start();//power management
    		climberM.set(0);
    	}
    }
    public void climbButtonStop(){
		Robot.compressor.start();//power management
    	climberM.set(0);
    }
}


