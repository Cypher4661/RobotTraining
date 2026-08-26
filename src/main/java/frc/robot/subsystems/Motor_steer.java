package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.motors.TalonFXConfig;
import frc.demacia.utils.motors.TalonFXMotor;
import frc.robot.Constants;

public class Motor_steer extends SubsystemBase implements Sendable {
    private final TalonFXMotor motorSteer;

    public Motor_steer() {
        super();
        motorSteer = new TalonFXMotor(Constants.Motor_steerConstants.CONFIG);
        SmartDashboard.putData("Motor_steer", this);
    }

    public void setPower(double power) {
        motorSteer.set(power);
    }

    public double getPower() {
        return motorSteer.get();
    }

    public String getName() {
        return "motorSteer";
    }

    public void stop() {
        motorSteer.set(0);
    }

    public double getAngle() {
        return motorSteer.getCurrentAngle();
    }

    public void setAngle(double angle) {
        motorSteer.setPositionVoltage(angle);
    }

    public double getKP() {
        return Constants.Motor_steerConstants.KP;
    }

    public double getKS() {
        return Constants.Motor_steerConstants.KS;
    }

    public double getKV() {
        return Constants.Motor_steerConstants.KV;
    }

    // public double getVelocity() {
    // return motor1.getVelocity().getValueAsDouble() *
    // Constants.Motor_steerConstants.WheelP;
    // }

    @Override
    public void initSendable(SendableBuilder builder) {
        // builder.addDoubleProperty("Velocity", this::getVelocity, null);
        // builder.addDoubleProperty("power", ()->getPower(), null); // lambda function
        // to return a local variable
        builder.addDoubleProperty("position", this::getAngle, this::setAngle); // method reference to getAngle and setAngle
                                                                              
        builder.addDoubleProperty("power", this::getPower, this::setPower);

        builder.addDoubleProperty("STEER_KP", this::getKP, null);
        builder.addDoubleProperty("STEER_KS", this::getKS, null);
        builder.addDoubleProperty("STEER_KV", this::getKV, null);
    }

    // @Override
    // public void periodic() {
    // SmartDashboard.putNumber("position", getAngle());
    // SmartDashboard.getNumber("Target_Angle", 0.0);
    // }
}
