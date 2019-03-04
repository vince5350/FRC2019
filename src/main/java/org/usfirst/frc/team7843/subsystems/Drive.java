package org.usfirst.frc.team7843.subsystems;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import org.usfirst.frc.team7843.OI;
import org.usfirst.frc.team7843.RobotMap;
public class Drive extends Subsystem {
    
    OI oi = new OI();
    Arm arm = new Arm();

    private final DifferentialDrive drive = RobotMap.driveDifferentialDrive;

    @Override
    public void initDefaultCommand() {}

    public void periodic(){
        // Put code here to run for every loop
        //Instantiate OI

        //Motor Output Maximums
        drive.setMaxOutput(0.7);
        RobotMap.armMotor.setNeutralMode(NeutralMode.Brake);


        /*
        *  Drive command
        */

        drive.tankDrive(oi.getJoyYLeft(), oi.getJoyYRight());


        /* 
        *  Arm commands
        */

        if(oi.getBumperLeft()){
            arm.setServo(0);
        }
        else if(oi.getBumperRight()){
            arm.setServo(1);
        }
    }


    public void stop(){
        drive.tankDrive(0,0);
    }
}

