// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.SimpleMotor2SubsystemCommands;
import frc.robot.commands.SimpleMotorSubsystemCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.SimpleMotor2Subsystem;
import frc.robot.subsystems.SimpleMotorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

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

  private final SimpleMotorSubsystem subsystem1 = new SimpleMotorSubsystem();
  private final SimpleMotor2Subsystem subsystem2 = new SimpleMotor2Subsystem();
  private CommandXboxController controller = new CommandXboxController(Constants.DriverConstants.DRIVER_ID);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    // button A
    // controller.a().onTrue(///);
  }

  private void configureDefaultCommands() {
    subsystem1.setDefaultCommand(new SimpleMotorSubsystemCommand(subsystem1, 0, 0));
    subsystem2.setDefaultCommand(new SimpleMotor2SubsystemCommands(subsystem2, 0, 0));
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Commands.parallel(new SimpleMotorSubsystemCommand(subsystem1, 0.7, 7),
        new SimpleMotor2SubsystemCommands(subsystem2, -0.5, 7));
  }
}

/**
 * 
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