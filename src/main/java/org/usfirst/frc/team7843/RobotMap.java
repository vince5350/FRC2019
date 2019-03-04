package org.usfirst.frc.team7843;

import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Servo;


public class RobotMap{
    // Left Drive
    public static WPI_VictorSPX motor_FrontLeft;
    public static WPI_VictorSPX motor_BackLeft;
    public static SpeedControllerGroup m_left;

    // Right Drive
    public static WPI_VictorSPX motor_FrontRight;
    public static WPI_VictorSPX motor_BackRight;
    public static SpeedControllerGroup m_right;

    public static DifferentialDrive driveDifferentialDrive;

    // Arm
    public static WPI_TalonSRX armMotor;
    public static Servo armServo;



    public static void init(){
        /*
        *  Drive initalization
        */ 
        motor_FrontLeft = new WPI_VictorSPX(0);
        motor_BackLeft = new WPI_VictorSPX(1);
        
        motor_FrontRight = new WPI_VictorSPX(2);
        motor_BackRight = new WPI_VictorSPX(3);
        
        // Set the motors to a speed controller group
        m_left = new SpeedControllerGroup(motor_FrontLeft, motor_BackLeft);
        m_right = new SpeedControllerGroup(motor_FrontRight, motor_BackRight);

        // Inverts the left motors
        m_left.setInverted(true);


        // "driveDifferentialDrive" is for variables relating to the drive
        // "m_left" & "m_right" are variables controlled for speed
        driveDifferentialDrive = new DifferentialDrive(m_left, m_right);
        
        // Enable safety for the motors
        driveDifferentialDrive.setSafetyEnabled(true);

        // Set maximum output speed for motors, generally cannot be more than 1.
        driveDifferentialDrive.setMaxOutput(1.0);


        /* 
         * Arm initalization 
        */

        // Arm speed controller
        armMotor = new WPI_TalonSRX(4);
        armServo = new Servo(5);
    }
}