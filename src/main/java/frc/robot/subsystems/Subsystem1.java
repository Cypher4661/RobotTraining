// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Subsystem1 extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  TalonFX motor = new TalonFX(Constants.master_yuda.Motor_ID, Constants.master_yuda.Motor_CANbus);

  public Subsystem1() {
    super();
  }

  public void setPower(double power) {
    motor.set(power);
  }

  public void stop() {
    motor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
