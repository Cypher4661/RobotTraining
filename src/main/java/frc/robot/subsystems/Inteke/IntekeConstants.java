package frc.robot.subsystems.Inteke;

import frc.demacia.utils.motors.TalonFXConfig;
import frc.demacia.utils.motors.SparkMaxConfig;
import frc.demacia.utils.motors.BaseMotorConfig.Canbus;

public class IntekeConstants {

  public static final TalonFXConfig leftConfig = new TalonFXConfig(0, Canbus.Rio, "left")
        .withBrake(true)
        .withInvert(false)
        .withPID(0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
        .withMaxPositionError(5)
        .withCurrent(40)
        .withVolts(12);

  public static final TalonFXConfig rightConfig = new TalonFXConfig(0, Canbus.Rio, "right")
        .withBrake(true)
        .withInvert(false)
        
        .withCurrent(40)
        .withVolts(12);

  public static final SparkMaxConfig rolerConfig = new SparkMaxConfig(0, "roler")
        .withBrake(true)
        .withInvert(false)
        .withPID(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
        .withCurrent(40)
        .withVolts(12);

  public static final int encID = 0;

  public static final int limID = 0;

}
