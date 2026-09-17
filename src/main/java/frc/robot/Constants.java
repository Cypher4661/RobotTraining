// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.demacia.utils.motors.TalonFXConfig;
import frc.demacia.utils.motors.BaseMotorConfig.Canbus;
import frc.demacia.utils.sensors.Cancoder;
import frc.demacia.utils.sensors.CancoderConfig;

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
  public static final int ID = 2;
  public static final int ID_STEER=2;
  public static final int ID_DRIVE=1;
  public static final Canbus CAN_BUS = Canbus.Rio;
  public static final String NAME = "Motor";
  public static final double KP_DRIVE = 0.0;
  public static final double KI_DRIVE = 0.0;
  public static final double KD_DRIVE = 0.0;
  public static final double KS_DRIVE = 0.52377;
  public static final double KV_DRIVE = 0.47702;
  public static final double KA_DRIVE = 0.0;
  public static final double KG_DRIVE = 0.0;

  public static final double KP_STEER = 3;
  public static final double KI_STEER = 0.0;
  public static final double KD_STEER = 0.0;
  public static final double KS_STEER = 0.1;
  public static final double KV_STEER = 0.33;
  public static final double KA_STEER = 0.0;
  public static final double KG_STEER = 0.0;


  public static final double KP= 0.0;
  public static final double KI = 0.0;
  public static final double KD = 0.0;
  public static final double KS = 0.03158;
  public static final double KV = 0.11841;
  public static final double KA = 0.0;
  public static final double KG = 0.0;


  public static final double GEAR_RATIO = 8.14;
  public static final int CANCODER_ID=9;
  public static final Canbus CANCODER_CANBUS=Canbus.Rio;
  public static final String CANCODER_NAME="cancoder";
  public static final double radiansGearRatio=150/7;

  public static final CancoderConfig CANCODER_CONFIG=new CancoderConfig(CANCODER_ID,CANCODER_CANBUS,CANCODER_NAME);


  public static final double offSet=-1.0;

  public static final TalonFXConfig CONFIG= new TalonFXConfig(ID, CAN_BUS, NAME)
  .withPID(KP, KI, KD, KS, KV, KA, KG)
  .withRadiansMotor(radiansGearRatio);
  public static final TalonFXConfig CONFIG_STEER= new TalonFXConfig(ID_STEER, CAN_BUS, NAME)
  .withPID(KP_STEER, KI_STEER, KD_STEER, KS_STEER, KV_STEER, KA_STEER, KG_STEER)
  .withRadiansMotor(radiansGearRatio);
  public static final TalonFXConfig CONFIG_DRIVE= new TalonFXConfig(ID_DRIVE, CAN_BUS, NAME)
  .withPID(KP_DRIVE, KI_DRIVE, KD_DRIVE, KS_DRIVE, KV_DRIVE, KA_DRIVE, KG_DRIVE)
  .withMeterMotor(8.14, 4*0.0254);
  
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
