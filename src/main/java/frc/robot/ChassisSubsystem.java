// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.SwerveConstants.*;

public class ChassisSubsystem extends SubsystemBase {

    // 1. רכיבי חומרה
    private final SwerveModule[] modules;
    private final Pigeon2 gyro;

    // 2. חישובי תנועה ומיקום במגרש
    private final SwerveDriveKinematics kinematics;
    private final SwerveDrivePoseEstimator poseEstimator;
    private final Field2d field = new Field2d();

    public ChassisSubsystem() {
        // אתחול 4 המודולות בעזרת ה-Configs מ-Constants
        modules = new SwerveModule[] {
            new SwerveModule(FRONT_LEFT),
            new SwerveModule(FRONT_RIGHT),
            new SwerveModule(BACK_LEFT),
            new SwerveModule(BACK_RIGHT)
        };

        // אתחול הג'יירו
        gyro = new Pigeon2(GYRO_ID, CANBUS_NAME);

        // אתחול הקינמטיקה עם המיקומים הפיזיים של הגלגלים
        kinematics = new SwerveDriveKinematics(
            FRONT_LEFT.position,
            FRONT_RIGHT.position,
            BACK_LEFT.position,
            BACK_RIGHT.position
        );

        // אתחול מעקב המיקום (Pose Estimator)
        poseEstimator = new SwerveDrivePoseEstimator(
            kinematics,
            getHeading(),
            getModulePositions(),
            new Pose2d()
        );

        // הצגת תצוגת המגרש בדשבורד
        SmartDashboard.putData("Field", field);
    }

    // ==================== פונקציות נסיעה ====================

    /**
     * מקבלת מהירות מבוקשת עבור הרובוט ומפעילה את המודולות בהתאם
     */
    public void drive(ChassisSpeeds speeds) {
        // המרת מהירות הרובוט (vx, vy, omega) למצבים של 4 המודולות (מהירות וזווית לכל גלגל)
        SwerveModuleState[] states = kinematics.toSwerveModuleStates(speeds);

        // לוודא שאף גלגל לא נדרש לעבור את המהירות המקסימלית של המנוע
        SwerveDriveKinematics.desaturateWheelSpeeds(states,MAX_SPEED_METERS_PER_SECOND);

        // העברת הפקודה לכל אחת מ-4 המודולות
        for (int i = 0; i < modules.length; i++) {
            modules[i].setState(states[i]);
        }
    }

    // ==================== חיישנים ואודומטריה ====================

    /**
     * מחזירה את זווית הרובוט הנוכחית מהג'יירו
     */
    public Rotation2d getHeading() {
        return gyro.getRotation2d();
    }

    /**
     * מאפסת את זווית הג'יירו (למשל בתחילת משחק או בלחיצת כפתור של הנהג)
     */
    public void zeroHeading() {
        gyro.setYaw(0);
    }

    /**
     * אוספת את המרחק והזווית מכל 4 המודולות עבור חישובי המיקום
     */
    public SwerveModulePosition[] getModulePositions() {
        SwerveModulePosition[] positions = new SwerveModulePosition[modules.length];
        for (int i = 0; i < modules.length; i++) {
            positions[i] = modules[i].getPosition();
        }
        return positions;
    }

    /**
     * מחזירה את המיקום המשוער של הרובוט במגרש (X, Y, Rotation)
     */
    public Pose2d getPose() {
        return poseEstimator.getEstimatedPosition();
    }

    // ==================== עדכון מחזורי (Periodic) ====================

    @Override
    public void periodic() {
        // עדכון המיקום במגרש בכל מחזור של הרובוט (20 מילי-שניות)
        poseEstimator.update(getHeading(), getModulePositions());

        // עדכון האייקון של הרובוט על גבי המגרש בדשבורד
        field.setRobotPose(getPose());
    }
}


