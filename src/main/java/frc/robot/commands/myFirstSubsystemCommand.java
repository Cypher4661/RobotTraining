package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Subsystem;

public class myFirstSubsystemCommand extends Command {
    private final Subsystem subsystem;
    private final double power;
    private final double duration;
    private double startTime=0;

    public myFirstSubsystemCommand(Subsystem subsystem, double power, double duration) {
        this.subsystem = subsystem;
        this.power = power;
        this.duration = duration;
        addRequirements(subsystem);
    }
    @Override
    public void initialize() {
        startTime=Timer.getFPGATimestamp();
        subsystem.setPower(power);
        System.out.println("start time=" + startTime + " , start power=" + power);
    }
    @Override
    public boolean isFinished(){
        return Timer.getFPGATimestamp()>=startTime+duration;
    }
    @Override
    public void execute() {
        subsystem.setPower(power);
    }
    @Override
    public void end(boolean interrupted) {
        subsystem.stopMotor();
        System.out.println("ended because of interuption:" + interrupted + " , duration:" + duration);
    }

}
