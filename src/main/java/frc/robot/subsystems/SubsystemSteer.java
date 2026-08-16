package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.units.measure.Power;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SubsystemSteer extends SubsystemBase {
      public SparkMax Neo;
    public SubsystemSteer() {
    super();
    Neo = new SparkMax(Constants.master_yuda.Neo_ID, MotorType.kBrushless);
  }
  public void setPower2( double power) {
    Neo.set(power);
  }

  public void stop() {
    Neo.set(0);
  }

  public double getangle(){
    return Neo.getEncoder().getPosition()*360;
  }
  
  public void setangle(double Position){
    Neo.getEncoder().setPosition(Position);
  }
  @Override
  public void periodic() {
      SmartDashboard.putNumber("neo angle", getangle());
  }}

