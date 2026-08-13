// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.demacia.utils.motors.TalonFXConfig;
import frc.demacia.utils.motors.BaseMotorConfig.Canbus;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final int MotorId=1;
  public static final String motorCANBUS="rio";
  public static final int MotorId1=2;
  public static final double gearRatio=6.75;//סתם הצבת מספר...
  public static final double wheelDiameter=0.2; // in meters, סתם הצבת מספר...
  public static final int ID = 1;
  public static final Canbus CAN_BUS = Canbus.Rio;
  public static final String NAME = "Motor";
  public static final double KP = 0.0;
  public static final double KI = 0.0;
  public static final double KD = 0.0;
  public static final double KS = 0.0;
  public static final double KV = 0.0;
  public static final double KA = 0.0;
  public static final double KG = 0.0;
  public static final double GEAR_RATIO = 6.75;

  public static final TalonFXConfig CONFIG = new TalonFXConfig(ID, CAN_BUS, NAME)
  .withPID(KP, KI, KD, KS, KV, KA, KG)
  .withRadiansMotor(GEAR_RATIO);
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
