package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
// gear ratio: mk4i gear ratio
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SimpleMotorSubsystem;

public class SimpleMotorSubsystemCommand extends Command {
    private SimpleMotorSubsystem subsystem;
    private double power;
    private double duration;
    private double startTime;
    private final Timer timer = new Timer();

    public SimpleMotorSubsystemCommand(SimpleMotorSubsystem subsystem, double power, double duration) {
        this.subsystem = subsystem;
        this.power = power;
        this.duration = duration;
        addRequirements(subsystem);
    }

    @Override
    public void initialize (){
        startTime = Timer.getFPGATimestamp();
        timer.restart();
        System.out.println("started At: " + startTime + " and operated for: " + duration + " the power is: " + power);
    }

    @Override
    public void execute(){
        subsystem.setPower(power);
    }

    @Override
    public boolean isFinished(){
        return (Timer.getFPGATimestamp() >= startTime + duration);
    }

    @Override
    public void end (boolean interrupted){
        subsystem.stop();
        System.out.println("Finished");
        System.out.println("Ended at: " + Timer.getFPGATimestamp());
    }
}
