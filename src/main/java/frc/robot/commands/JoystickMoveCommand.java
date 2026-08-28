package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.subsystems.ModuleSubsystem;






public class JoystickMoveCommand extends Command {
    private ModuleSubsystem Module;
    private CommandXboxController controller;
    private double leftY;
    private double LeftX;
    private double filteredX;
    private double filteredY;
    
    public JoystickMoveCommand(ModuleSubsystem Module, CommandXboxController controller) {
        this.Module = Module;
        this.controller = controller;
        addRequirements(Module);
    }

    @Override
    public void execute(){
        LeftX = this.controller.getLeftX();
        leftY = -(this.controller.getLeftY());
        filteredX = MathUtil.applyDeadband(LeftX, Constants.DriverConstants.Deadband);
        filteredY = MathUtil.applyDeadband(leftY, Constants.DriverConstants.Deadband);
        if (filteredX != Constants.DriverConstants.JoystickCenter || filteredY != Constants.DriverConstants.JoystickCenter){
          Rotation2d direction = new Rotation2d(LeftX, leftY);
          double targetAngle = direction.getDegrees();
          Module.setSteerAngle(targetAngle);}
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end (boolean ineteruption){
        this.Module.stopModula();
        System.out.println("Modula stopped");
    }

}
