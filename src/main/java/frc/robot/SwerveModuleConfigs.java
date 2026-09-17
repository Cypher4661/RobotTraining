package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import frc.demacia.utils.motors.BaseMotorConfig;
import frc.demacia.utils.motors.TalonFXConfig;
import frc.demacia.utils.sensors.CancoderConfig;

public class SwerveModuleConfigs {

    public final String name;
    public final Translation2d position;

    public final TalonFXConfig driveMotorConfig;
    public final TalonFXConfig steerMotorConfig;
    public final CancoderConfig cancoderConfig;

    public final double steerOffset;
    public SwerveModuleConfigs(String name,Translation2d position, TalonFXConfig driveMotorConfig,
            TalonFXConfig steerMotorConfig, CancoderConfig cancoderConfig,double steerOffset ){
        this.name=name;
        this.position=position;
        this.cancoderConfig=cancoderConfig;
        this.driveMotorConfig=driveMotorConfig;
        this.steerMotorConfig=steerMotorConfig;
        this.steerOffset=steerOffset;
    }

}


