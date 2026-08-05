package frc.robot.subsystems;
import edu.wpi.first.math.system.plant.DCMotor;
import java.lang.management.MemoryType;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.sim.SparkMaxSim;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Subsystem extends SubsystemBase 
{
    private final TalonFX motor;
    private final SparkMax motor1;
    private SparkMaxSim motor1Sim;
    public Subsystem(){
        super();
        motor=new TalonFX(Constants.MotorId, Constants.motorCANBUS);
        motor1=new SparkMax(Constants.MotorId1, MotorType.kBrushless);
        motor1Sim = new SparkMaxSim(motor1, DCMotor.getNEO(1));
    }
    @Override
    public void simulationPeriodic() {
        motor1Sim.iterate(motor1.get() * 12.0, 12.0, 0.02);
    }
    public void setPower(double power){
        motor.set(power);
    }
    public void setPower1(double power1){
        motor1.set(power1);
    }
    public void stopMotor(){
        motor.set(0);
    }
    public void stopMotor1(){
        motor1.set(0);
    }
    public void stopAllMotors(){
        stopMotor();
        stopMotor1();
    }
}
