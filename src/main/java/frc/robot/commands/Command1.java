// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.SubsystemDrive;
import frc.robot.subsystems.SubsystemSteer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class Command1 extends Command {
  private final SubsystemSteer neoSubsystem;
  private final double Power2;
  private final double target;
  private final boolean isForward;
  
  public Command1(SubsystemSteer neoSubsystem, double Power2, double target, boolean isForward) {

    this.Power2=Power2;
    this.target=target;
    this.neoSubsystem = neoSubsystem;
    this.isForward = isForward;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(neoSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    neoSubsystem.setangle(Constants.master_yuda.startigNeoPosition);
    System.out.println("Steer "+target+" degrees");
  }
  @Override
  public void execute(){
    if (isForward) {
      neoSubsystem.setPower2(Power2);
    }
    else{
      neoSubsystem.setPower2(-Power2);
    }
  }
  @Override
  public void end(boolean interrupted) {
    neoSubsystem.stop();
    System.out.println("Neo at "+target+" degrees");
  }

  @Override
  public boolean isFinished() {
        return neoSubsystem.getangle()>=target;
  }

}
