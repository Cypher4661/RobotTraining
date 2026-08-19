package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Radians;

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

    @Override
    public void periodic() {
        SmartDashboard.putNumber("position", getAngle());
        SmartDashboard.getNumber("Target_Angle", 0.0);
    }
}
