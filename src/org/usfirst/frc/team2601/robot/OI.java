package org.usfirst.frc.team2601.robot;

import org.usfirst.frc.team2601.robot.commands.climber.ClimbButton;
import org.usfirst.frc.team2601.robot.commands.climber.ClimbButtonStop;
import org.usfirst.frc.team2601.robot.commands.drivetrain.ArcadeDrive;
import org.usfirst.frc.team2601.robot.commands.drivetrain.ReverseDirection;
import org.usfirst.frc.team2601.robot.commands.drivetrain.Shift;
import org.usfirst.frc.team2601.robot.commands.gear.GearPanel;
import org.usfirst.frc.team2601.robot.commands.gear.GearPiston;
import org.usfirst.frc.team2601.robot.commands.gear.PushGear;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	

	public OI(){
		//Get constants
		Constants constants = Constants.getInstance();
		
		//Instantiate Joysticks and Buttonboard
		constants.dJS = new Joystick(constants.dJSPort);
		constants.oJS = new Joystick(constants.oJSPort);
		constants.randJS = new Joystick(constants.randP);
		
		//Driver Controls
		Button shift = new JoystickButton(constants.dJS, constants.shiftB);
    	shift.whenPressed(new Shift());		

    	Button reverse = new JoystickButton(constants.dJS, constants.reverseB);
    	reverse.whenPressed(new ReverseDirection());
    	
    	//Operator Controls
    	Button gear = new JoystickButton(constants.oJS, constants.gearB);
    	gear.whenPressed(new GearPiston());
    	
    	Button pushGear = new JoystickButton(constants.oJS, constants.pushGearB);
    	pushGear.whenPressed(new PushGear());
    
    	Button gearPanel = new JoystickButton(constants.oJS, constants.gearPanelB);
    	gearPanel.whenPressed(new GearPanel());
    	
    	Button climb = new JoystickButton(constants.oJS, constants.climbB);
    	//climb.whenPressed(new ClimbButton());
    	//climb.whileHeld(new ClimbButton());
    	//climb.whileActive(new ClimbButton());
    	climb.whenActive(new ClimbButton());
    	climb.whenInactive(new ClimbButtonStop());
    	
    	}
	
}

