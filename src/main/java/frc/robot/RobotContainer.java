// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.DriveTo;
import frc.robot.commands.SubsystemCommand1;
import frc.robot.commands.TurnToPose;
//import frc.robot.Constants.OperatorConstants;
//import frc.robot.commands.Autos;
//import frc.robot.commands.ExampleCommand;
//import frc.robot.commands.myFirstSubsystemCommand;
//import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Subsystem;
import frc.robot.subsystems.SubsystemPID;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
//import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
   private final Subsystem mySubsystem = new Subsystem();
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    
    
    
    //return new SubsystemCommand1(mySubsystem, 0.5, 0.5, 5.0);
   
   
   
   //lesson 8
     return
      new TurnToPose(mySubsystem, 90.0).
      andThen(new DriveTo(mySubsystem, 1.0).
      alongWith(new TurnToPose(mySubsystem, 135))).
      andThen(new TurnToPose(mySubsystem, 0).
      alongWith(new DriveTo(mySubsystem, -1.0)));
    


    
    

  
      

    


    
    


    
  }

  
}
