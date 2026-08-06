// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Subsystem1;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class Command1 extends Command {
  private final Subsystem1 MotorSubsystem;
  private final double Power;
  private final double Time;
  private double startTime;
  private Timer timer = new Timer();


  public Command1(Subsystem1 MotorSubsystem, double Power, double Time) {
    this.MotorSubsystem = MotorSubsystem;
    this.Power = Power;
    this.Time = Time;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(MotorSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = timer.getFPGATimestamp();
    timer.restart();
    System.out.println("SimpleMotorCommand initialized with power: " + Power + ", duration: " + Time);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    MotorSubsystem.setPower(Power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    MotorSubsystem.stop();
    System.out.println("Command ended.");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
        return timer.hasElapsed(Time);

  }
}
