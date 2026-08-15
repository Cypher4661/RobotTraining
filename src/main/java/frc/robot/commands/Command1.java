// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.SubsystemDrive;
import frc.robot.subsystems.SubsystemSteer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class Command1 extends Command {
  private final SubsystemSteer neoSubsystem;
  private final double Power2;
  private final double TargetAngle;
  public Command1(SubsystemSteer neoSubsystem, double Power2, double TargetAngle) {

    this.Power2=Power2;
    this.neoSubsystem = neoSubsystem;
    this.TargetAngle = TargetAngle;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(neoSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    neoSubsystem.setangle(0);
    System.out.println("Steer "+TargetAngle+" degrees");
  }
  @Override
  public void execute(){
    neoSubsystem.setPower2(Power2);
  }
  @Override
  public void end(boolean interrupted) {
    neoSubsystem.stop();
    System.out.println("Neo at "+TargetAngle+" degrees");
  }

  @Override
  public boolean isFinished() {
        return neoSubsystem.getangle()>=TargetAngle;
  }

}
