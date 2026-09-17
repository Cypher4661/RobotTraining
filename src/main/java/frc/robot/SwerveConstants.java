package frc.robot;
import frc.demacia.utils.motors.TalonFXConfig;
import edu.wpi.first.math.geometry.Translation2d;
import frc.demacia.utils.motors.BaseMotorConfig.Canbus;
import frc.demacia.utils.sensors.Cancoder;
import frc.demacia.utils.sensors.CancoderConfig;

public class SwerveConstants {
    public static final int GYRO_ID=0;
    public static final String CANBUS_NAME = "rio";
   
    public static final Canbus CANCODER_CANBUS=Canbus.Rio;
    public static final String CANCODER_NAME="cancoder";


    public static final double MAX_SPEED_METERS_PER_SECOND = 5.0;

    public static final double KP_STEER = 3;
    public static final double KI_STEER = 0.0;
    public static final double KD_STEER = 0.0;
    public static final double KS_STEER = 0.1;
    public static final double KV_STEER = 0.33;
    public static final double KA_STEER = 0.0;
    public static final double KG_STEER = 0.0;
    public static final double GEAR_RATIO = 8.14;
    


  public static final double KP_DRIVE = 0.0;
  public static final double KI_DRIVE = 0.0;
  public static final double KD_DRIVE = 0.0;
  public static final double KS_DRIVE = 0.52377;
  public static final double KV_DRIVE = 0.47702;
  public static final double KA_DRIVE = 0.0;
  public static final double KG_DRIVE = 0.0;

  public static final Canbus CAN_BUS = Canbus.Rio;
  public static final String NAME = "Motor";
  //NEED TO ENTER NUMBERS
  

  public static final SwerveModuleConfigs FRONT_LEFT = new SwerveModuleConfigs(
        "Front Left",
        new Translation2d(0, 0), // מיקום ברביע הראשון ביחס למרכז הרובוט
        new TalonFXConfig(1, CAN_BUS,NAME)
        .withPID(KP_DRIVE, KI_DRIVE, KD_DRIVE, KS_DRIVE, KV_DRIVE, KA_DRIVE, KG_DRIVE)
        .withMeterMotor(8.14, 4*0.0254), // Drive Moto 
        new TalonFXConfig(2, CAN_BUS, NAME)
        .withPID(KP_STEER, KI_STEER, KD_STEER, KS_STEER, KV_STEER, KA_STEER, KG_STEER)
        .withRadiansMotor(GEAR_RATIO), // Steer Motor 
        new CancoderConfig(9,CANCODER_CANBUS,CANCODER_NAME),// Cancoder
        0.0                           // Steer Offset
    );

    public static final SwerveModuleConfigs FRONT_RIGHT = new SwerveModuleConfigs(
        "Front Right",
        new Translation2d(0, 0), // מיקום ברביע הראשון ביחס למרכז הרובוט
        new TalonFXConfig(3, CAN_BUS,NAME)
        .withPID(KP_DRIVE, KI_DRIVE, KD_DRIVE, KS_DRIVE, KV_DRIVE, KA_DRIVE, KG_DRIVE)
        .withMeterMotor(8.14, 4*0.0254), // Drive Moto 
        new TalonFXConfig(4, CAN_BUS, NAME)
        .withPID(KP_STEER, KI_STEER, KD_STEER, KS_STEER, KV_STEER, KA_STEER, KG_STEER)
        .withRadiansMotor(GEAR_RATIO), // Steer Motor 
        new CancoderConfig(10,CANCODER_CANBUS,CANCODER_NAME),// Cancoder
        0.0                           // Steer Offset
    );

    public static final SwerveModuleConfigs BACK_LEFT = new SwerveModuleConfigs(
        "Back Left",
        new Translation2d(0, 0), // מיקום ברביע הראשון ביחס למרכז הרובוט
        new TalonFXConfig(5, CAN_BUS,NAME)
        .withPID(KP_DRIVE, KI_DRIVE, KD_DRIVE, KS_DRIVE, KV_DRIVE, KA_DRIVE, KG_DRIVE)
        .withMeterMotor(8.14, 4*0.0254), // Drive Moto 
        new TalonFXConfig(6, CAN_BUS, NAME)
        .withPID(KP_STEER, KI_STEER, KD_STEER, KS_STEER, KV_STEER, KA_STEER, KG_STEER)
        .withRadiansMotor(GEAR_RATIO), // Steer Motor 
        new CancoderConfig(11,CANCODER_CANBUS,CANCODER_NAME),// Cancoder
        0.0                           // Steer Offset
    );

    public static final SwerveModuleConfigs BACK_RIGHT = new SwerveModuleConfigs(
        "Back Right",
        new Translation2d(0, 0), // מיקום ברביע הראשון ביחס למרכז הרובוט
        new TalonFXConfig(7, CAN_BUS,NAME)
        .withPID(KP_DRIVE, KI_DRIVE, KD_DRIVE, KS_DRIVE, KV_DRIVE, KA_DRIVE, KG_DRIVE)
        .withMeterMotor(8.14, 4*0.0254), // Drive Moto 
        new TalonFXConfig(8, CAN_BUS, NAME)
        .withPID(KP_STEER, KI_STEER, KD_STEER, KS_STEER, KV_STEER, KA_STEER, KG_STEER)
        .withRadiansMotor(GEAR_RATIO), // Steer Motor 
        new CancoderConfig(12,CANCODER_CANBUS,CANCODER_NAME),// Cancoder
        0.0                           // Steer Offset
    );
    
}
