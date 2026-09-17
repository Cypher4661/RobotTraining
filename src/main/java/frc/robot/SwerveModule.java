package frc.robot;

import java.io.ObjectInputFilter.Config;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.demacia.utils.motors.TalonFXConfig;
import frc.demacia.utils.motors.TalonFXMotor;
import frc.demacia.utils.sensors.Cancoder;
import frc.demacia.utils.sensors.CancoderConfig;

public class SwerveModule {
    private TalonFXMotor steerMotor;
    private TalonFXMotor driveMotor;
    private Cancoder cancoder;
    private String name;

    public SwerveModule(SwerveModuleConfigs configs){
        steerMotor = new TalonFXMotor(configs.steerMotorConfig);
        driveMotor=new TalonFXMotor(configs.driveMotorConfig);
        cancoder=new Cancoder(configs.cancoderConfig);
        this.name=configs.name;

        steerMotor.setPosition(getAbsoluteAngleRadians()-Constants.offSet);
    }

    public double getAbsoluteAngleRadians(){
        return cancoder.getCurrentAbsPosition();
    }


    public void setSteerPower(double power){
        steerMotor.set(power);
    }
    public void setDrivePower(double power){
        driveMotor.set(power);
    }

    public void setSteerVelocity(double velocityRPS){
        steerMotor.setVelocity(velocityRPS);
    }
    public void setDriveVelocity(double velocityRPS){
        driveMotor.setVelocity(velocityRPS);
    }

    public void setSteerPosition(double positionInRadians){
        steerMotor.setPositionVoltage(positionInRadians);
    }
    public double getSteerAngle(){
        return steerMotor.getCurrentPosition();
    }

    public Rotation2d getSteerRotation(){
        return new Rotation2d(getSteerAngle());
    }

    public double getSteerVelocity(){
        return steerMotor.getCurrentVelocity();
    }
    public double getDriveVelocity(){
        return driveMotor.getCurrentVelocity();
    }

    public double getDrivePositionMeters(){
        return driveMotor.getPosition().getValueAsDouble();
    }

    
    public SwerveModulePosition getPosition() {
    return new SwerveModulePosition(
        getDrivePositionMeters(), // המרחק שהמנוע עבר במטרים (driveMotorPosition * conversionFactor)
        getSteerRotation()           // הזווית הנוכחית של הגלגל כ-Rotation2d
    );
}


    public void setState(SwerveModuleState state) {
        double wantedAngle = state.angle.getRadians();
        double diff = wantedAngle - steerMotor.getCurrentPosition();
        double vel = state.speedMetersPerSecond;
        diff = MathUtil.angleModulus(diff);
        if(diff > 0.5 * Math.PI) {
            vel = -vel;
            diff = diff-Math.PI;
        } else if(diff < -0.5 * Math.PI) {
            vel = -vel;
            diff = diff + Math.PI;
        }
        setSteerPosition(steerMotor.getCurrentPosition() + diff);
        setDriveVelocity(vel);
    }


public SwerveModulePosition getModulePosition() {
  return new SwerveModulePosition(driveMotor.getCurrentPosition(),Rotation2d.fromRadians(steerMotor.getCurrentPosition()));
}

public SwerveModuleState getState() {
  return new SwerveModuleState(getDriveVelocity(), getSteerRotation());
}

public void stop() {
  steerMotor.stopMotor();
  driveMotor.stopMotor();
}


}
