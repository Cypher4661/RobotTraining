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
  TalonFXMotor motot;
  public SubsystemPID() {
    motot = new TalonFXMotor(Constants.CONFIG);
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
  public void initSendable(SendableBuilder builder) {
    // TODO Auto-generated method stub
    super.initSendable(builder);
    builder.addDoubleProperty("motor angle ", ()->getAngle(),(angle)->setAngle(angle));
    builder.addDoubleProperty("motor velocity", this:: getAngle, this:: setAngle);
  } 

  public void setAngle(double angle){
    motot.setPositionVoltage(angle);
  }
  public double getAngle(){
    return motot.getPosition().getValueAsDouble();
  }
  public void setPower(double power){
    motot.setVoltage(power);
  }
  public void setVelocity(double velocity){
    motot.setVelocity(velocity);
  }
  public double getVelocity(){
    return motot.getVelocity().getValueAsDouble();
  }
  

}
