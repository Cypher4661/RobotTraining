package frc.robot.subsystems.Inteke;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.motors.MotorInterface;
import frc.demacia.utils.motors.SparkMaxMotor;
import frc.demacia.utils.motors.TalonFXMotor;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix6.hardware.CANcoder;

public class IntekeSubsystem extends SubsystemBase {

  private final MotorInterface left;
  private final MotorInterface right;
  private final MotorInterface roler;

  
  private final DigitalInput lim;

  public IntekeSubsystem() {
    left = new TalonFXMotor(IntekeConstants.leftConfig);
    right = new TalonFXMotor(IntekeConstants.rightConfig);
    ((TalonFX) right).setControl(new Follower(IntekeConstants.leftConfig.id, MotorAlignmentValue.Opposed));
    roler = new SparkMaxMotor(IntekeConstants.rolerConfig);

   
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



  public boolean getLim() {
    return lim.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
