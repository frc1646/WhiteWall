package org.usfirst.frc.team1646.robot.subsystems;

import org.usfirst.frc.team1646.robot.RobotMap;
import org.usfirst.frc.team1646.robot.commands.DriveWithJoy;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private ADXRS450_Gyro gyro;
	private DriveSide leftSide, rightSide;
	private static DriveTrain instance;
	
	private DriveTrain() {
		gyro = new ADXRS450_Gyro();
		leftSide = new DriveSide(RobotMap.FRONT_LEFT, RobotMap.BACK_LEFT, RobotMap.INV_1, RobotMap.INV_2);
		rightSide = new DriveSide(RobotMap.FRONT_RIGHT, RobotMap.BACK_RIGHT, RobotMap.INV_3, RobotMap.INV_4);
	}
	
	public void setPower(double leftPower, double rightPower) {
		leftSide.setPower(leftPower);
		rightSide.setPower(rightPower);
	}

	public double getAngle() {
		return gyro.getAngle();
	}
	
	public void resetGyro() {
		gyro.reset();
	}
	
	public void calibrateGyro() {
		gyro.calibrate();
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoy());
    }
    
    public static DriveTrain getInstance() {
    	if (instance == null) {
    		instance = new DriveTrain();
    	}
    	return instance;
    }
    
    private class DriveSide {
    	private VictorSP master, slave;
    	//private Encoder encoder;
    	
    	
    	public DriveSide(int port1, int port2, boolean inv1, boolean inv2) {
    		master = new VictorSP(port1);
    		slave = new VictorSP(port2);
    		
    		master.setInverted(inv1);
    		slave.setInverted(inv2);
    	}
    	
    	public void setPower(double power) {
    		master.set(power);
    		slave.set(power);
    	}
    	
    	
    }
}

