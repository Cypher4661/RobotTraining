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

    public SimpleMotor2SubsystemCommands (SimpleMotor2Subsystem subsystem, double power, double duration){
        this.subsystem = subsystem;
        this.power = power;
        this.duration = duration;
        addRequirements(subsystem);
    }
}
