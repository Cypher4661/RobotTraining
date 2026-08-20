// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.controller.CommandController;
import frc.demacia.utils.motors.TalonFXMotor;
import frc.demacia.utils.sensors.Cancoder;
import frc.robot.Constants;

public class ModuleSubsystem extends SubsystemBase {
  private TalonFXMotor steerMotor;
  private TalonFXMotor driveMotor;
  private Cancoder cancoder;
  private CommandController controller;
  /** Creates a new ModuleSubsystem. */
  public ModuleSubsystem(CommandController controller) {
    steerMotor = new TalonFXMotor(Constants.CONFIG_STEER);
    driveMotor=new TalonFXMotor(Constants.CONFIG_DRIVE);
    cancoder=new Cancoder(Constants.CANCODER_CONFIG);
    SmartDashboard.putData("modola", this);
    this.controller=controller;

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if(Math.abs(controller.getLeftX())>0.01){
      setDriveVelocity(controller.getLeftX()*5);
    }
  }
  @Override
  public void initSendable(SendableBuilder builder){
    super.initSendable(builder);
    builder.addDoubleProperty("steer position (deg)",()->getSteerPositionDegrees(),null);
    builder.addDoubleProperty("steer power", ()->getSteerPower(), null);
    builder.addDoubleProperty("steer velocity", ()->getSteerVelocity(), null);

    builder.addDoubleProperty("drive position (meter)", ()->getDrivePositionMeter(), null);
    builder.addDoubleProperty("drive power", ()->getDrivePower(), null);
    builder.addDoubleProperty("drive velocity", ()-> getDriveVelocity(), null);

    builder.addDoubleProperty("absolute angle",()-> getAbsoluteAngleDegrees(), null);
    builder.addDoubleProperty("set power steer", ()->getSteerPower(), (power)->setSteerPower(power));
    builder.addDoubleProperty("set power drive", ()-> getDrivePower(), (power)->setDrivePower(power));
    builder.addDoubleProperty("set drive velocity",()->getDriveVelocity() , (velocity)->setDriveVelocity(velocity));
    builder.addDoubleProperty("set steer velocity",  null,(velocity)-> setSteerVelocity(velocity));

  }


  public double getAbsoluteAngleDegrees(){
    return cancoder.getCurrentAbsPosition();
  }
  public double getDrivePositionMeter(){
    return driveMotor.getPosition().getValueAsDouble();
  }
  public double getDriveVelocity(){
    return driveMotor.getVelocity().getValueAsDouble();
  }
  public double getDrivePower(){
    return driveMotor.getCurrentVoltage();
  }


  public double getSteerPositionDegrees(){
    return steerMotor.getPosition().getValueAsDouble();
  }
  public double getSteerVelocity(){
    return steerMotor.getVelocity().getValueAsDouble();
  }
  public double getSteerPower(){
    return steerMotor.getCurrentVoltage();
  }


  public void setDrivePower(double power){
    driveMotor.setVoltage(power);
  }
  public void setDriveVelocity(double velocity){
    driveMotor.setVelocity(velocity);
  }

  public void setSteerPower(double power){
    steerMotor.setVoltage(power);
  }
  public void setSteerVelocity(double velocity){
    steerMotor.setVelocity(velocity);
  }
}
