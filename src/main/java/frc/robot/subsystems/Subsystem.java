package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Subsystem extends SubsystemBase 
{
    private final TalonFX motor;
    public Subsystem(){
        super();
        motor=new TalonFX(Constants.MotorId, Constants.motorCANBUS);
    }
    public void setPower(double power){
        motor.set(power);
    }
    public void stopMotor(){
        motor.set(0);
    }


}
