package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SimpleMotor2Subsystem;

public class SimpleMotor2SubsystemCommands extends Command {
    private SimpleMotor2Subsystem subsystem;
    private double startTime;
    private double power;
    private double duration;
    private final Timer timer = new Timer();

    public SimpleMotor2SubsystemCommands(SimpleMotor2Subsystem subsystem, double power, double duration) {
        this.subsystem = subsystem;
        this.power = power;
        this.duration = duration;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        startTime = Timer.getFPGATimestamp();
        timer.restart();
        System.out.println("started At: " + startTime + " and operated for: " + duration + " the power is: " + power);
    }

    @Override
    public void execute() {
        subsystem.setPower(power);
    }

    @Override
    public boolean isFinished(){
        return (Timer.getFPGATimestamp() >= startTime + duration);
    }

    @Override
    public void end (boolean ineteruption){
        subsystem.stop();
        System.out.println("Finished");
        System.out.println("Ended at: " + Timer.getFPGATimestamp());
    }
}
