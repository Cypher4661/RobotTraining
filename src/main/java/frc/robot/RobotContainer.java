// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.Constants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.master_yuda;
import frc.robot.commands.Command1;
import frc.robot.commands.commandDrive;
import frc.robot.subsystems.SubsystemDrive;
import frc.robot.subsystems.SubsystemSteer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final SubsystemDrive subsystem = new SubsystemDrive();
  private final SubsystemSteer subsystem2 = new SubsystemSteer();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    Command steer = new Command1(subsystem2, Constants.master_yuda.steerPower,Constants.master_yuda.TargetAngle1,true);
    Command parallel1 = new ParallelCommandGroup(
      new commandDrive(subsystem,master_yuda.isForwar1),
      new Command1(subsystem2,Constants.master_yuda.steerPower,Constants.master_yuda.TargetAngle2,true));
    Command parallel2 = new ParallelCommandGroup(
      new commandDrive(subsystem,master_yuda.isForwar2),
      new Command1(subsystem2,Constants.master_yuda.steerPower,Constants.master_yuda.TargetAngle3,false));
    return new SequentialCommandGroup( steer, parallel1, parallel2);
  
  }
}
