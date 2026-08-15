// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.CANBus;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class master_yuda{
    public static final int Motor_ID=6;
    public static final CANBus Motor_CANbus = CANBus.roboRIO();
    public static final int Neo_ID = 8;
    public static final double TargetAngle1 = 90;
    public static final double TargetAngle2 = 135;
    public static final double TargetAngle3 = 0;
    public static final boolean isForwar1 = true;
    public static final boolean isForwar2 = false;
    public static final double steerPower = 0.3;
  }
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}