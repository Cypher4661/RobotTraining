// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Motor_DriveSimpleCommand;
import frc.robot.commands.Motor_SteerSimpleCommand;
import frc.robot.commands.Move1MeterCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Motor_drive;
import frc.robot.subsystems.Motor_steer;
import frc.robot.subsystems.ModuleSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.util.Units;


/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private Motor_steer subsystemSTEER;
  private Motor_drive subsystemDRIVE;
  private ModuleSubsystem subsystemMODULE;
  private CommandXboxController controller;
  public RobotContainer() {
    subsystemSTEER = new Motor_steer();
    subsystemDRIVE = new Motor_drive();
    subsystemMODULE = new ModuleSubsystem(subsystemSTEER, subsystemDRIVE);
    controller = new CommandXboxController(Constants.DriverConstants.DRIVER_ID);
    // deadband = 0/01 or 0.1
    configureBindings();
  }

    private void configureBindings() {
    //button A;
    //controller.a().onTrue(getCMD_A());
    }

  private void configureDefaultCommands() {
    // subsystemSTEER.setDefaultCommand(
    //     new RunCommand(() -> subsystemSTEER.setVoltage(-(controller.getLeftY()) * 0.5), subsystemSTEER)
    //   );
    //   subsystemDRIVE.setDefaultCommand(
    //     new RunCommand(() -> subsystemDRIVE.setVoltage(-(controller.getLeftY()) * 0.5), subsystemDRIVE)
    // );
    subsystemMODULE.setDefaultCommand(
      new RunCommand( () -> {
        double filteredInput = MathUtil.applyDeadband(-(controller.getLeftY()), 0.05);
        double targetVelocity = filteredInput * Constants.Motor_driveConstants.Max_Drive_Speed;
        subsystemMODULE.setDriveVelocity(targetVelocity);}));
    //subsystemSTEER.setDefaultCommand(new Motor_SteerSimpleCommand(subsystemSTEER, 0, 0));
    //subsystemDRIVE.setDefaultCommand(new Motor_DriveSimpleCommand(subsystemDRIVE, 0, 0));
  }


   public Command getAutonomousCommand() {

  //   return new SequentialCommandGroup(
  //     new MoveToAngleCommand(subsystemSTEER, 90.0).
  //     andThen(new Move1MeterCommand(subsystemDRIVE, 1.0)
  //     .alongWith(new MoveToAngleCommand(subsystemSTEER, 135.0)))
  //     .andThen(new MoveToAngleCommand(subsystemSTEER, 0.0)
  //     .alongWith(new Move1MeterCommand(subsystemDRIVE, -1.0))));
  //   An example command will be run in autonomous
     return Commands.parallel(new Motor_SteerSimpleCommand(subsystemSTEER, 0.7, 7),
        new Motor_DriveSimpleCommand(subsystemDRIVE, -0.5, 7));
   }

public Command getCMD_A(){
  return Commands.parallel(new Motor_SteerSimpleCommand(subsystemSTEER, 0.7, 7),
        new Motor_DriveSimpleCommand(subsystemDRIVE, -0.5, 7));
      }
}

/**
 * // The robot's subsystems and commands are defined here...
 * private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
 * 
 * The container for the robot. Contains subsystems, OI devices, and commands.
 * public RobotContainer() {
 * // Configure the trigger bindings
 * configureBindings();
 * }
 * 
 * Use this method to define your trigger->command mappings. Triggers can be
 * created via the
 * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
 * an arbitrary
 * predicate, or via the named factories in {@link
 * private void configureBindings() {
 * // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
 * new Trigger(m_exampleSubsystem::exampleCondition)
 * .onTrue(new ExampleCommand(m_exampleSubsystem));
 * }
 * 
 * Use this to pass the autonomous command to the main {@link Robot} class.
 * 
 * @return the command to run in autonomous
 * 
 * public Command getAutonomousCommand() {
 * // An example command will be run in autonomous
 * return Autos.exampleAuto(m_exampleSubsystem);
 * }
 * 
 * private void configureBindings() {
 * 
 * //buttons
 * controller.a().onTrue(///);
 * controller.b().onFlase(/ command /);
 * controller.rightBumper().onChange(/ command /);
 * controller.x().onFlase(/ command /).onTrue(/ command /);
 * 
 * //joysticks
 * double leftY = controller.getLeftY(); // -1 forward!!! -1 to 1
 * double rightX = controller.getRightX();
 * 
 * //triggers of controller
 * double leftTrigger = controller.getLeftTriggerAxis(); // 0 to 1
 * double rightTrigger = controller.getRightTriggerAxis();
 * }
 */