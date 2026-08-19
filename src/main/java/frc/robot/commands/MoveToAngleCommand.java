package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SimpleMotorSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveToAngleCommand extends Command{
    private SimpleMotorSubsystem subsystem;
    private double targetAngle;
    private boolean isFinished;

    public MoveToAngleCommand(SimpleMotorSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
        SmartDashboard.putNumber("Target_Angle", 0.0);
    }

    @Override
    public void initialize() {
        isFinished = false;
        this.targetAngle = SmartDashboard.getNumber("Target_Angle", 0.0);
        System.out.println("Moving to angle: " + targetAngle);
    }

    @Override
    public void execute() {
        double currentAngle = subsystem.getAngle();
        double error = targetAngle - currentAngle;
        double power = error * 0.5;
        power = Math.max(-1.0, Math.min(1.0, power));
        subsystem.setPower(power);
        if (Math.abs(error) < 1.0) { // Considered close enough to target
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
        System.out.println("Reached target angle: " + targetAngle);
    }
}
