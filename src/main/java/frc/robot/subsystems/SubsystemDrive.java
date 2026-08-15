// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.units.Measure;
import edu.wpi.first.units.Unit;
import edu.wpi.first.units.VelocityUnit;

public class SubsystemDrive extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public TalonFX motor;
  public SparkMax Neo;
  public SubsystemDrive() {
    super();
    motor = new TalonFX(Constants.master_yuda.Motor_ID, Constants.master_yuda.Motor_CANbus);
  }
  public void setEncoder(double startingAngle){
    motor.setPosition(startingAngle);
  }
  public void setPower1(double power) {
    motor.set(power);
  }
  public void stop() {
    motor.set(0);
  }
  public double getPosition() {
    return motor.getPosition().getValueAsDouble();
  }
  @Override
  public void periodic() {
  }
}


