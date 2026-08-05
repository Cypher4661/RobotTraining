package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
//import frc.robot.subsystems.Subsystem;

public class SubsystemCommand1 extends Command {
    private final Subsystem subsystem;
    private final double power;
    private final double power1;
    private final double duration;
    
    private double startTime=0;

    public SubsystemCommand1(Subsystem subsystem, double power, double power1, double duration) {
        this.subsystem = subsystem;
        this.power = power;
        this.power1 = power1;
        this.duration = duration;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        startTime=Timer.getFPGATimestamp();
        subsystem.setPower(power);
        subsystem.setPower1(power1);
        System.out.println("start time=" + startTime + " , start power=" + power + " , start power1=" + power1);
    }


    @Override
    public boolean isFinished(){
        return Timer.getFPGATimestamp()>=startTime+duration;
    }

    @Override
    public void execute() {
        subsystem.setPower(power);
        subsystem.setPower1(power1);
    }
    @Override
    public void end(boolean interrupted) {
        subsystem.stopAllMotors();
        System.out.println("ended because of interuption:" + interrupted + " , duration:" + duration);
    }


}
