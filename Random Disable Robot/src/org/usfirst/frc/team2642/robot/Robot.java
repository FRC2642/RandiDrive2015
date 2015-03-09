package org.usfirst.frc.team2642.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Joystick stick;
	int autoLoopCounter;
	RobotDrive myRobot;
	Gyro gyro;
	double randBreak;
	int randFix;
	
	
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	myRobot = new RobotDrive(0, 2, 1, 3);
    	stick = new Joystick(0);
    	myRobot.setInvertedMotor(MotorType.kFrontLeft, true);
    	myRobot.setInvertedMotor(MotorType.kRearLeft, true);
    	gyro = new Gyro(0);
    	randFix = 0;

    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    	autoLoopCounter = 0;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
		{
			
		}
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    	randBreak = 0;
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	if(stick.getRawButton(10)){
    		randBreak = (int) (Math.random() * 100);
    	}else if(stick.getRawButton(11)){
    		randBreak = 0;
    	}
    		if(randBreak <= 5 && randBreak > 0){	//Invert X
    			if (stick.getRawButton(1)){
        			myRobot.mecanumDrive_Cartesian(stick.getX(), stick.getY(), -stick.getTwist(), gyro.getAngle());
        			
        		}else{
        			myRobot.mecanumDrive_Cartesian(stick.getX()/2, stick.getY()/2, -stick.getTwist()/2, gyro.getAngle());}
    			
    		}else if(5 < randBreak && randBreak <= 10){	//Invert Y
    			if (stick.getRawButton(1)){
        			myRobot.mecanumDrive_Cartesian(-stick.getX(), -stick.getY(), -stick.getTwist(), gyro.getAngle());
        		}else{
        			myRobot.mecanumDrive_Cartesian(-stick.getX()/2, -stick.getY()/2, -stick.getTwist()/2, gyro.getAngle());
        			}
        	}else if(10 < randBreak && randBreak <= 15){	//Invert Twist
        		if (stick.getRawButton(1)){
        			myRobot.mecanumDrive_Cartesian(-stick.getX(), stick.getY(), stick.getTwist(), gyro.getAngle());
        		}else{
        			myRobot.mecanumDrive_Cartesian(-stick.getX()/2, stick.getY()/2, stick.getTwist()/2, gyro.getAngle());
        			}
        	}else if(15 < randBreak && randBreak <= 20){										//Remove Field Oriented
        		if (stick.getRawButton(1)){
        			myRobot.mecanumDrive_Cartesian(-stick.getX(), stick.getY(), -stick.getTwist(), 0);
        		}else{
        			myRobot.mecanumDrive_Cartesian(-stick.getX()/2, stick.getY()/2, -stick.getTwist()/2, 0);
        			}
        	}else if(20 < randBreak && randBreak <= 25){										//Only half speed
        			myRobot.mecanumDrive_Cartesian(-stick.getX()/2, stick.getY()/2, -stick.getTwist()/2, gyro.getAngle());
        	}else if(25 < randBreak && randBreak <= 30){										//Only full speed
        			myRobot.mecanumDrive_Cartesian(-stick.getX(), stick.getY(), -stick.getTwist(), gyro.getAngle());
        	}else if(35 < randBreak && randBreak <= 40){										//X and Y switch
        		if (stick.getRawButton(1)){
        			myRobot.mecanumDrive_Cartesian(stick.getY(), -stick.getX(), -stick.getTwist(), gyro.getAngle());
        		}else{
        			myRobot.mecanumDrive_Cartesian(stick.getY()/2, -stick.getX()/2, -stick.getTwist()/2, gyro.getAngle());
        			}
        	}else if(45 < randBreak && randBreak <= 50){										//Reverses Field Oriented
        		if (stick.getRawButton(1)){
        			myRobot.mecanumDrive_Cartesian(-stick.getX(), stick.getY(), -stick.getTwist(), -gyro.getAngle());
        		}else{
        			myRobot.mecanumDrive_Cartesian(-stick.getX()/2, stick.getY()/2, -stick.getTwist()/2, -gyro.getAngle());
        			}
        	}else if(55 < randBreak && randBreak <= 60){										//Reverses speed controller
        		if (stick.getRawButton(1)){
        			myRobot.mecanumDrive_Cartesian(-stick.getX()/2, stick.getY()/2, -stick.getTwist()/2, gyro.getAngle());
        		}else{
        			myRobot.mecanumDrive_Cartesian(-stick.getX(), stick.getY(), -stick.getTwist(), gyro.getAngle());
        			}
        	}else if(65 < randBreak && randBreak <= 70){										//Reverses crab and turn
        		if (stick.getRawButton(1)){
        			myRobot.mecanumDrive_Cartesian(-stick.getTwist(), stick.getY(), -stick.getX(), gyro.getAngle());
        		}else{
        			myRobot.mecanumDrive_Cartesian(-stick.getTwist()/2, stick.getY()/2, -stick.getX()/2, gyro.getAngle());
        			}
        	}else if(75 < randBreak && randBreak <= 80){										//No crabbing
        		if (stick.getRawButton(1)){
        			myRobot.mecanumDrive_Cartesian(0, stick.getY(), -stick.getTwist(), gyro.getAngle());
        		}else{
        			myRobot.mecanumDrive_Cartesian(0, stick.getY()/2, -stick.getTwist()/2, gyro.getAngle());
        			}
        	}else if(80 < randBreak && randBreak <= 85){										//Inverts control scheme
        		if (stick.getRawButton(1)){
        			myRobot.mecanumDrive_Cartesian(stick.getX(), -stick.getY(), stick.getTwist(), gyro.getAngle());
        		}else{
        			myRobot.mecanumDrive_Cartesian(stick.getX()/2, -stick.getY()/2, stick.getTwist()/2, gyro.getAngle());
        			}
        	}
        	else if(85 < randBreak && randBreak <= 90){
        		if (stick.getRawButton(1)){														//Disables Y movement
        			myRobot.mecanumDrive_Cartesian(-stick.getX(), 0, -stick.getTwist(), gyro.getAngle());
        		}else{
        			myRobot.mecanumDrive_Cartesian(-stick.getX()/2, 0, -stick.getTwist()/2, gyro.getAngle());
        		}
        	}else{																				//Standard drive
        		if (stick.getRawButton(1)){
        			myRobot.mecanumDrive_Cartesian(-stick.getX(), stick.getY(), -stick.getTwist(), gyro.getAngle());
        		}else{
        			myRobot.mecanumDrive_Cartesian(-stick.getX()/2, stick.getY()/2, -stick.getTwist()/2, gyro.getAngle());
        		}
        	}
    }
    
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
}