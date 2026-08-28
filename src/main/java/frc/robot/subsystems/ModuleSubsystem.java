package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Velocity;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.demacia.utils.motors.TalonFXConfig;
import frc.demacia.utils.motors.TalonFXMotor;
import frc.robot.Constants;

public class ModuleSubsystem extends SubsystemBase implements Sendable {
    private Motor_steer motorSteer;

    private Motor_drive motorDrive;

    private double velocitySetpoint;

    public ModuleSubsystem(Motor_steer motorSteer, Motor_drive motorDrive) {
        super();
        this.motorSteer = motorSteer;
        this.motorDrive = motorDrive;
        this.velocitySetpoint = 0.0;
        SmartDashboard.putData("ModuleSubsystem", this);
    }

    public void stopModula(){
        this.motorDrive.setPower(0.0);
        this.motorSteer.setPower(0.0);
    }

    public void setDriveVelocity(double velocity) {
        this.motorDrive.setVelocity(velocity);
    }

    public double getDriveVelocity() {
        return this.motorDrive.getVelocityMpS();
    }

    public void setSteerAngle(double angle) {
        this.motorSteer.setAngle(angle);
    }

    public double getSteerAngle() {
        return this.motorSteer.getAngle();
    }

    public double getSteerPower() {
        return this.motorSteer.getPower();
    }

    public void SetSteerPower(double power) {
        this.motorSteer.setPower(power);
    }

    public double getDrivePower() {
        return this.motorDrive.getPower();
    }

    public void SetDrivePower(double power) {
        this.motorDrive.setPower(power);
    }

    public double getVelocitySetpoint(){
        return this.velocitySetpoint;
    }

    public void setVelocitySetpoint(double targetVelocity){
        this.velocitySetpoint = targetVelocity;
    }

    @Override
    public void initSendable(SendableBuilder builder) {

        builder.addDoubleProperty("position", this::getSteerAngle, this::setSteerAngle);

        builder.addDoubleProperty("Velocity_Drive", this::getDriveVelocity, this::setDriveVelocity);

        builder.addDoubleProperty("power_Steer", this::getSteerPower, this::SetSteerPower);

        builder.addDoubleProperty("power_Drive", this::getDrivePower, this::SetDrivePower);

        builder.addDoubleProperty("SetPoint", this::getVelocitySetpoint, this::setVelocitySetpoint);
    }
}
