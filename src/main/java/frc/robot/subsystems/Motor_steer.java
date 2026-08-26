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
        return motorSteer.getPosition().getValueAsDouble() * Constants.Motor_steerConstants.wholeDegrees;
    }

    //public double getVelocity() {
    //    return motor1.getVelocity().getValueAsDouble() * Constants.Motor_steerConstants.WheelP;
    //}


     @Override
    public void initSendable(SendableBuilder builder) {
    //    builder.addDoubleProperty("Velocity", this::getVelocity, null);
    //    builder.addDoubleProperty("position", this::getAngle, null); // method reference to getAngle and setAngle
        builder.addDoubleProperty("power", ()->getPower(), null); // lambda function to return a local variable
        SmartDashboard.putData("Motor_steer", this);
    }
    
    //@Override
    //public void periodic() {
    //    SmartDashboard.putNumber("position", getAngle());
    //    SmartDashboard.getNumber("Target_Angle", 0.0);
    //}
}
