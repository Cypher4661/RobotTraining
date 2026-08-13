package frc.robot.subsystems;
//import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import java.lang.management.MemoryType;
import com.ctre.phoenix6.hardware.TalonFX;




import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Subsystem extends SubsystemBase 
{
    private final TalonFX motor;
    private final TalonFX motor1;
    
    public Subsystem(){
        super();
        motor=new TalonFX(Constants.MotorId, Constants.motorCANBUS);
        motor1=new TalonFX(Constants.MotorId1, Constants.motorCANBUS);
        
        SmartDashboard.putData("modola", this);
    }

    

    @Override
    public void periodic() {
        
        SmartDashboard.putNumber("rio motor angle", getAngle());
        SmartDashboard.getNumber("wanted angle", -1);
        SmartDashboard.putNumber("drive motor distance", getDistance());
        SmartDashboard.putNumber("steer motor angle", getAngle());
        SmartDashboard.putNumber("STEER motor velocity(rps)",getSteerVelocity()); 
        SmartDashboard.putNumber("Drive motor velocity(rps)", getDriveVelocity());
    }

    @Override
    public void initSendable(SendableBuilder builder) {
         builder.addDoubleProperty("angle", this::getAngle, this::setAngle);
    }
    public double getAngle(){
        double deg=motor.getRotorPosition().getValueAsDouble() * 360;
        if(deg>360){
            return deg%360;
        }
        else if(deg<0){
            return 360+deg%360;
        }
        else{
            return deg;
        }
    }
    public void setAngle(double angle){
        motor.setPosition(angle);
    }
    
    public double getDistance(){
        return (motor1.getRotorPosition().getValueAsDouble()/Constants.gearRatio)*Math.PI*Constants.wheelDiameter;
    }
    public void setDistance(double distance){
        motor1.setPosition((distance/(Math.PI*Constants.wheelDiameter))*Constants.gearRatio);
    }

    public void setPower(double power){
        motor.set(power);
    }
    public double getSteerVelocity(){
        return motor.getRotorVelocity().getValueAsDouble();
    }

    public double getDriveVelocity(){
        return motor1.getRotorVelocity().getValueAsDouble();
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
