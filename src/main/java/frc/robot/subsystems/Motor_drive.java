package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.util.Units;
import frc.demacia.utils.motors.TalonFXMotor;
import frc.robot.Constants;

public class Motor_drive extends SubsystemBase implements Sendable {

    private final TalonFXMotor motorDrive;

    public Motor_drive() {
        super();
        motorDrive = new TalonFXMotor(Constants.Motor_driveConstants.CONFIG);
        SmartDashboard.putData("Motor_drive", this);
        // new TalonFX(Constants.MotorConstants.Mdrive_ID,Constants.Motor_driveConstants.MotorCANbus2);
    }

    public double getDistance() {
        return motorDrive.getPosition().getValueAsDouble() * Constants.Motor_driveConstants.WheelP;

    }

    public void setPower(double power) {
        motorDrive.set(power);
    }

    public double getPower() {
        return motorDrive.get();
    }

    public void stop() {
        motorDrive.set(0);
    }

    public double getAngle() {
        return motorDrive.getCurrentAngle();
    }

    public void setAngle(double angle) {
        motorDrive.setPositionVoltage(angle);
    }

    public double getVelocity() {
        return motorDrive.getVelocity().getValueAsDouble() * Constants.Motor_driveConstants.WheelP;
    }

    public void setVelocity(double velocity) {
        motorDrive.setVelocity(velocity);
    }

     public double getKP() {
        return Constants.Motor_driveConstants.KP;
    }

    public double getKS() {
        return Constants.Motor_driveConstants.KS;
    }

    public double getKV() {
        return Constants.Motor_driveConstants.KV;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        // builder.addDoubleProperty("position", this::getAngle, null); // method reference to getAngle and setAngle
        // builder.addDoubleProperty("power", ()->getPower(), this::setPower); // lambda function to return a local variable
        builder.addDoubleProperty("Velocity", this::getVelocity, this::setVelocity); // method reference to getVelocity and set Velocity                                                                                   

        builder.addDoubleProperty("power", this::getPower, this::setPower);

        builder.addDoubleProperty("STEER_KP", this::getKP, null);
        builder.addDoubleProperty("STEER_KS", this::getKS, null);
        builder.addDoubleProperty("STEER_KV", this::getKV, null);

}

}
