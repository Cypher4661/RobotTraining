package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SimpleMotorSubsystem extends SubsystemBase {
    private final TalonFX motor1;

    public SimpleMotorSubsystem() {
        super();
        motor1 = new TalonFX(Constants.SimpleMotorSubsystemConstants.MOTOR1_ID,
                Constants.SimpleMotorSubsystemConstants.MotorCANbus1);
    }

    public void setPower(double power) {
        motor1.set(power);
    }

    public void stop() {
        motor1.set(0);
    }

}
