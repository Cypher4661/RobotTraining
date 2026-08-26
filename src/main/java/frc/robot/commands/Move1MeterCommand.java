package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Motor_drive;


public class Move1MeterCommand extends Command{
    
    private Motor_drive subsystem;
    private double targetDistance;
    public double startPosition;
    private boolean isFinished;
    private double power;

    public Move1MeterCommand(Motor_drive subsystem, double distance) {
        this.subsystem = subsystem;
        this.targetDistance = subsystem.getDistance() + distance; // HW Target distance in meters
        startPosition = subsystem.getDistance();
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        isFinished = false;
        System.out.println("Moving to distance: " + targetDistance + " meters");
    }

    @Override
    public void execute() {
        
        if (targetDistance < subsystem.getDistance()) {
            power = 0.2;
        }
        else {
            power = (-0.2);
        }
        power = Math.max(-1.0, Math.min(1.0, power));
        subsystem.setPower(power);
        double currentDistance = Math.abs(subsystem.getDistance() - startPosition);
        double error = Math.abs(targetDistance - currentDistance);
        if (Math.abs(error) < 0.05) {
            isFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.stop();
        System.out.println("Reached target distance: " + targetDistance + " meters");
    }

}
