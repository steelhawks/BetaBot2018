
package org.usfirst.frc.team2601.robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team2601.robot.autonCommands.BetaAuton;
import org.usfirst.frc.team2601.robot.subsystems.Climber;
import org.usfirst.frc.team2601.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2601.robot.subsystems.Gear;


import com.ctre.phoenix.MotorControl.CAN.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;	

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
//C:\Users\Steel Hawks 2\Desktop\lt
public class Robot extends IterativeRobot {
	
	//Instantiate Subsystems
	public static final Drivetrain drivetrain = new Drivetrain();
	public static OI oi;
	public static final Gear gear = new Gear();
	public static final Climber climber = new Climber();
	public static final Compressor compressor = new Compressor();

	//Declare Command based structure classes
    Command autonomousCommand;
    SendableChooser<CommandGroup> chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	oi = new OI();
        chooser = new SendableChooser();
        
        //Autonomous
        chooser.addObject("BetaAuton", new BetaAuton());
        SmartDashboard.putData("Auto mode", chooser);
        System.out.println("hi");
    }	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	autonomousCommand = new BetaAuton();
    	autonomousCommand.start();
   
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        Robot.drivetrain.gyro.reset();
        Robot.drivetrain.gyro.zeroYaw();
     }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
       
        SmartDashboard.putNumber("ir1", Robot.gear.ir1.getValue());
 	   	SmartDashboard.putNumber("ir2", Robot.gear.ir2.getValue());

    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
