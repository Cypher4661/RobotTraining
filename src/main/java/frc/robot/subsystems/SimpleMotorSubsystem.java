package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SimpleMotorSubsystem extends SubsystemBase implements Sendable {
    private final TalonFX motor1;

    public SimpleMotorSubsystem() {
        super();
        motor1 = new TalonFX(Constants.SimpleMotorSubsystemConstants.Msteer_ID,
                Constants.SimpleMotorSubsystemConstants.MotorCANbus1);
    }

    public void setPower(double power) {
        motor1.set(power);
    }

    public double getPower() {
        return motor1.get();
    }
    public String getName() {
        return "motor1";
    }

    public void stop() {
        motor1.set(0);
    }

    public double getAngle() {
        return motor1.getPosition().getValueAsDouble() * Constants.SimpleMotorSubsystemConstants.wholeDegrees;
    }

    public double getVelocity() {
        return motor1.getVelocity().getValueAsDouble() * Constants.SimpleMotorSubsystemConstants.WheelP;
    }


     @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("Velocity", this::getVelocity, null);
        builder.addDoubleProperty("position", this::getAngle, null); // method reference to getAngle and setAngle
        builder.addDoubleProperty("power", ()->getPower(), null); // lambda function to return a local variable
        SmartDashboard.putData("SimpleMotorSubsystem", this);
    }
    
    //@Override
    //public void periodic() {
    //    SmartDashboard.putNumber("position", getAngle());
    //    SmartDashboard.getNumber("Target_Angle", 0.0);
    //}
}
