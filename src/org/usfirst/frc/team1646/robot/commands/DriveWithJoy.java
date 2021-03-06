package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.OI;
import org.usfirst.frc.team1646.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoy extends Command {
	
	private DriveTrain drive;
	private OI m_oi;
	
    public DriveWithJoy() {
    	m_oi = OI.getInstance();
    	requires(drive = DriveTrain.getInstance());
        
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
