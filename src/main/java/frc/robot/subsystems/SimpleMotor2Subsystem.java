package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.util.Units;
import frc.robot.Constants;

public class SimpleMotor2Subsystem extends SubsystemBase implements Sendable {

    private final TalonFX motor2;

    public SimpleMotor2Subsystem() {
        super();
        motor2 = new TalonFX(Constants.SimpleMotor2SubsystemConstants.Mdrive_ID,
                Constants.SimpleMotor2SubsystemConstants.MotorCANbus2);
    }

    public double getDistance() {
         return motor2.getPosition().getValueAsDouble() * Constants.SimpleMotor2SubsystemConstants.WheelP;
        
    }

    public void setPower(double power) {
        motor2.set(power);
    }

    public double getPower() {
        return motor2.get();
    }

    public void stop() {
        motor2.set(0);
    }

    @Override
    public void periodic() {
        double power = SmartDashboard.getNumber("SimpleMotor Power", 0);
        SmartDashboard.putNumber(getName(), power);
    }

    public double getAngle() {
        return motor2.getPosition().getValueAsDouble() * Constants.SimpleMotor2SubsystemConstants.wholeDegrees;
    }

    public double getVelocity() {
        return motor2.getVelocity().getValueAsDouble() * Constants.SimpleMotor2SubsystemConstants.WheelP;
    }


    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("Velocity", this::getVelocity, null);
        builder.addDoubleProperty("position", this::getAngle, null); // method reference to getAngle and setAngle
        builder.addDoubleProperty("power", ()->getPower(), null); // lambda function to return a local variable
        SmartDashboard.putData("SimpleMotor2Subsystem", this);
    }
    
}
