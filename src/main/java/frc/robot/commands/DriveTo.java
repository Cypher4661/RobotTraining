// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Subsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveTo extends Command {
  private final Subsystem subsystem;
  private double wantedDistance;
  private double currentDistance;
  /** Creates a new DriveTo. */
  public DriveTo(Subsystem subsystem,double wantedDistance) {
    this.wantedDistance=wantedDistance;
    this.subsystem = subsystem;
    addRequirements(subsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    subsystem.setDistance(0);
    currentDistance=subsystem.getDistance();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(wantedDistance>currentDistance){
      subsystem.setPower1(0.3);
    }else if(wantedDistance<currentDistance){
      subsystem.setPower1(-0.3);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    subsystem.stopMotor1();
    SmartDashboard.putNumber("END-Drive motor distance", subsystem.getDistance());
    SmartDashboard.putNumber("END-Drive motor velocity(rps)", subsystem.getDriveVelocity());
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    currentDistance=subsystem.getDistance();
    return Math.abs(currentDistance-wantedDistance)<0.05;
  }
}
