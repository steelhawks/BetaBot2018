package org.usfirst.frc.team2601.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class Constants {
    private static Constants instance = null;
	
	public static Constants getInstance(){
		if (instance == null){
			instance = new Constants();
		}
		return instance;
	}

	public static boolean alpha = false;
	public static boolean operatorJS = true;//if using joystick for operating
	//Joysticks
	public final static int dJSPort = 0;
	public final static int oJSPort = 1;
	public final static int randP = 5;
	
	public static Joystick dJS;
	public static Joystick oJS;
	public Joystick randJS;
	
	//Driver Buttons
	public final static int shiftB = 1;
	public final static int reverseB = 3;
	
	//Operator Buttons
		public static int gearB;// = 10;
		public static int pushGearB;/// = 4;
		public static int gearPanelB; //= 6;
		public static int climbB; //= 5;
	
	//drivetrain motors
	public final static int frontLeftM = 0;
	public final static int middleLeftM = 1;
	public final static int backLeftM = 2;
	public final static int frontRightM = 3;
	public final static int middleRightM = 4;
	public final static int backRightM = 5;
	
	//climber motors
	public final static int climbM = 7;

	//Shifting Solenoids
	public final static int driveSolOn = 0;
	public final static int driveSolOff = 1;
	public final static int shootShieldSolOn = 4;//2
	public final static int shootShieldSolOff = 5;//3
	public final static int gearSolOn = 6;//4
	public final static int gearSolOff = 7;//5
	public final static int pushGearOn = 2;//6
	public final static int pushGearOff = 3;//7
	
	/*public final static int hopperOn = 0;
	public final static int hopperOff = 1;
	
	public static boolean shieldUp;*/
	
	//Sensors
	//Gyros
	public boolean gyroTurnRight;
	public boolean gyroTurnLeft;
	
public Constants(){
	//Operator Buttons
		if(operatorJS == false){
			gearB = 10;
			pushGearB = 4;
			gearPanelB = 6;
			climbB = 5;
		}else{
			gearB = 11;//OPEN AND CLOSES HOCKEY STICKS
			pushGearB = 12;//CONTROLS PUSHER
			gearPanelB = 9;//CONTROLS PANEL
			climbB = 1;//controls climber
		}	
	}
}