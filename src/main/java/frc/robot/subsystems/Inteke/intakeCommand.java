// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Inteke;

import edu.wpi.first.wpilibj2.command.Command;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class intakeCommand extends Command {
  /** Creates a new intakeCommand. */
  private final boolean toOpen;
  private final IntekeSubsystem intakeSubsystem;
  public intakeCommand(boolean toOpen, IntekeSubsystem intakeSubsystem) {
    this.toOpen = toOpen;
    this.intakeSubsystem = intakeSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (toOpen) {
      intakeSubsystem.setLeftPosition(Math.toRadians(90));
      intakeSubsystem.setRolerPower(0.5);

   
    } else {
      intakeSubsystem.setLeftPosition(0.0);
      intakeSubsystem.setRolerPower(0.0);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
