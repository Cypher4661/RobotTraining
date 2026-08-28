// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.print.DocFlavor.STRING;

import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.controls.MotionMagicVelocityDutyCycle;

import frc.demacia.utils.motors.TalonFXConfig;
import frc.demacia.utils.motors.BaseMotorConfig.Canbus;
import pabeles.concurrency.IntOperatorTask.Max;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  
public static final class Motor_steerConstants {
  public static final int Msteer_ID = 2;
  //  public static final String MotorCANbus1 = "rio";
  public static final Canbus MotorCANbus1 = Canbus.Rio;

  public static final double KP = 0.1, KI = 0.0, KD = 0.0, KS = 0.098, KV = 0.36656, KA = 0.0, KG = 0.0;
  public static final TalonFXConfig CONFIG = new TalonFXConfig(Msteer_ID, MotorCANbus1, "MotorSteer")
  .withPID(KP, KI, KD, KS, KV, KA, KG)
  .withMotionParam(50.0, 100.0, 1000.0)
  .withBrake(true).withInvert(false)
  .withRadiansMotor(150/7);
  //public static final TalonFXConfig CONFIG = new TalonFXConfig(Msteer_ID, MotorCANbus1, "motor1").withPID(KP = 0.1, KI = 0, KD = 0, KS = 0, KV = 0, KA = 0, KG = 0).withMotionParam(double Motion_Magic_Velocity, Motion_Magic_Acceleration, Motion_Magic_Jerk).withBrake(boolean Is_Brake).withInvert(boolean Is_Inverted).withRadiansMotor(double Gear_Ratio).withRampTime(double Ramp_Time).withVolts(double Max_Volts).withCurrent(double Max_Current);
  public static final double wholeDegrees = 360.0;
  public static final double ninetyDegrees = 90.0;
  public static final double InchesToMeters = 0.0254;
  public static final double WheelP = 4*InchesToMeters;
  
}

public static final class Motor_driveConstants {
  public static final int Mdrive_ID = 1;
  //  public static final String MotorCANbus2 = "rio";
  public static final Canbus MotorCANbus2 = Canbus.Rio;
  public static final double Max_Drive_Speed = 5;
  public static final double KP = 0.1, KI = 0.0, KD = 0.0, KS = 2.13196, KV = 0.05826, KA = 0.0, KG = 0.0;
  public static final TalonFXConfig CONFIG = new TalonFXConfig(Mdrive_ID, MotorCANbus2, "MotorDrive").withPID(KP, KI, KD, KS, KV, KA, KG)
  .withMotionParam(50.0, 100.0, 1000.0)
  .withBrake(true)
  .withInvert(false)
  .withRadiansMotor(150/7);
  //public static final TalonFXConfig CONFIG = new TalonFXConfig(Msteer_ID, MotorCANbus1, "motor1").withPID(KP = 0.1, KI = 0, KD = 0, KS = 0, KV = 0, KA = 0, KG = 0).withMotionParam(double Motion_Magic_Velocity, Motion_Magic_Acceleration, Motion_Magic_Jerk).withBrake(boolean Is_Brake).withInvert(boolean Is_Inverted).withRadiansMotor(double Gear_Ratio).withRampTime(double Ramp_Time).withVolts(double Max_Volts).withCurrent(double Max_Current);
  public static final double OneMeter = 1.0;
  public static final double wholeDegrees = 360.0;
  public static final double InchesToMeters = 0.0254;
  public static final double WheelP = 4*InchesToMeters;
}

public static final class DriverConstants {
public static final int DriverControllerPort = 0;
public static final int OperatorControllerPort = 1;
public static final int DRIVER_ID = 1;
public static final double Deadband = 0.01;
public static final double JoystickCenter = 0.0;
}

}
