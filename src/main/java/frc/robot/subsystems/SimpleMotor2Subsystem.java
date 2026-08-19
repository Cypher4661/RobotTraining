package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SimpleMotor2Subsystem extends SubsystemBase {

    private final TalonFX motor2;

    public SimpleMotor2Subsystem() {
        super();
        motor2 = new TalonFX(Constants.SimpleMotor2SubsystemConstants.Mdrive_ID,
                Constants.SimpleMotor2SubsystemConstants.MotorCANbus2);
    }

    public void setPower(double power) {
        motor2.set(power);
    }

    public void stop() {
        motor2.set(0);
    }

    @Override
    public void periodic() {
        double power = SmartDashboard.getNumber("SimpleMotor Power", 0);
        SmartDashboard.putNumber(getName(), power);
    }
}
