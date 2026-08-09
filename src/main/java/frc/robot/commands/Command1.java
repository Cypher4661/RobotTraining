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
  private Timer timer = new Timer();
  private final double Power2;

  public Command1(Subsystem1 MotorSubsystem, double Power, double Time, double Power2) {
    this.MotorSubsystem = MotorSubsystem;
    this.Power = Power;
    this.Time = Time;
    this.Power2=Power2;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(MotorSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.restart();
    System.out.println("kraken initialized with power: " + Power + ", duration: " + Time + "Neo initialized with power:"+ Power2 + ", duration:"+ Time);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    MotorSubsystem.setPower1(Power, Power2);
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
