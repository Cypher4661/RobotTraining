package frc.robot.subsystems.Inteke;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.motors.MotorInterface;
import frc.demacia.utils.motors.SparkMaxMotor;
import frc.demacia.utils.motors.TalonFXMotor;
import frc.robot.Constants;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;

import com.ctre.phoenix6.hardware.CANcoder;

public class IntekeSubsystem extends SubsystemBase {

  private final MotorInterface left;
  private final MotorInterface right;
  private final MotorInterface roler;
  
  private boolean isCalibrated = false;
  private final DutyCycleEncoder Encoder;

  
  private final DigitalInput lim;

  public IntekeSubsystem() {
    left = new TalonFXMotor(IntekeConstants.leftConfig);
    right = new TalonFXMotor(IntekeConstants.rightConfig);
    ((TalonFX) right).setControl(new Follower(IntekeConstants.leftConfig.id, MotorAlignmentValue.Opposed));
    roler = new SparkMaxMotor(IntekeConstants.rolerConfig);
    Encoder = new DutyCycleEncoder(IntekeConstants.encID);

   
    this.lim = new DigitalInput(IntekeConstants.limID);
  }

  public void setLeftPower(double power) {
    left.setDuty(power);
  }

  public void setLeftPosition(double position) {
    left.setPositionVoltage(position);
  }

  public double getLeftPosition() {
    return left.getCurrentPosition();
  }

  public void setLeftEncoderPosition(double position) {
    left.setEncoderPosition(position);
  }

  public void setRolerPower(double power) {
    roler.setDuty(power);
  }
  public double getAbsoluteEncoderAngle(){
    return 70;//(Encoder.get() * 360.0)/2  ; // Convert to degrees
  }
  public void calibrateFromEncoder(){
    if (!isCalibrated) {
      double angle = getAbsoluteEncoderAngle(); // Convert to degrees
      left.setEncoderPosition(Math.toRadians(angle - 30));
      isCalibrated = true;

    }
  }



  public boolean getLim() {
    return lim.get();
  }

  @Override
  public void periodic() {
    calibrateFromEncoder();
    // This method will be called once per scheduler run
  }
}
