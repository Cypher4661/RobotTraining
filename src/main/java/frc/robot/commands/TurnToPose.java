// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Subsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class TurnToPose extends Command {
  private final Subsystem subsystem;
  private double targetAngle;
  private double currentAngle;
  /** Creates a new TurnToPose. */
  public TurnToPose(Subsystem subsystem, double targetAngle) {
    this.subsystem = subsystem;
    this.targetAngle = targetAngle;
    addRequirements(subsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    currentAngle=subsystem.getAngle();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentAngle=subsystem.getAngle();
    if (currentAngle>targetAngle) {
      subsystem.setPower(-0.3); // Turn left
    } else if (currentAngle<targetAngle) {
      subsystem.setPower(0.3); // Turn right
      
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    subsystem.stopMotor();
    SmartDashboard.putNumber("END-steer motor angle", subsystem.getAngle());
    SmartDashboard.putNumber("END-steer motor velocity(rps)",subsystem.getSteerVelocity()); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(currentAngle - targetAngle) < 2.0; // Finish when within 2 degrees of target
  }
}
