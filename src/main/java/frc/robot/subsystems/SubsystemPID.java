// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.motors.TalonFXMotor;

public class SubsystemPID extends SubsystemBase {
  /** Creates a new SubsystemPID. */
  TalonFXMotor motor;
  double targetVelocity;
  public SubsystemPID() {
    motor = new TalonFXMotor(Constants.CONFIG);
    SmartDashboard.putData("modola", this);
  }

  //@Override
  /*public void periodic() {
    setAngle(Math.toRadians(SmartDashboard.getNumber("input motor angle", 0)));
    setVelocity(SmartDashboard.getNumber("input motor velocity", 0));
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("motor angle", getAngle());
    SmartDashboard.putNumber("motor velocity", getVelocity());

  }*/
  @Override
  public void periodic(){
    if(targetVelocity!=0){
      setVelocity(targetVelocity);
    }
    
  }

  @Override
  public void initSendable(SendableBuilder builder) {
    // TODO Auto-generated method stub
    super.initSendable(builder);
    builder.addDoubleProperty("motor angle ", ()->getAngle(),(angle)->setAngle(angle));
    builder.addDoubleProperty("target velocity", ()->getTargetVelocity(), (velocity)->setTargetVelocity(velocity));
    builder.addDoubleProperty("current velocity",()-> getVelocity(), null);
    builder.addDoubleProperty("motor voltage", ()->getVoltage(), (voltage)->setVoltage(voltage));
  } 

  public void setAngle(double angle){
    motor.setPositionVoltage(angle);
  }
  public double getAngle(){
    return motor.getPosition().getValueAsDouble();
  }
  public void setPower(double power){
    motor.setVoltage(power);
  }
  public void setVelocity(double velocity){
    motor.setVelocity(velocity);
  }
  public double getVelocity(){
    return motor.getVelocity().getValueAsDouble();
  }
  public void setTargetVelocity(double targetVelocity){
    this.targetVelocity=targetVelocity;
  }
  public double getTargetVelocity(){
    return this.targetVelocity;
  }
  public void setVoltage(double voltage){
    motor.setVoltage(voltage); 
  }
  public double getVoltage(){
    return motor.getCurrentVoltage();
  }
  


}
