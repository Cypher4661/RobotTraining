package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SubsystemDrive;

public class commandDrive extends Command{
    private final SubsystemDrive driver;
    private double power;
    private boolean isForward;
    public commandDrive( SubsystemDrive driver, boolean isForward){
        super();
        this.driver = driver;
        this.isForward=isForward;
        addRequirements(driver);
    }
    @Override
    public void initialize() {
        driver.setEncoder(0);
    }
    //
    @Override
    public void execute (){
        if (isForward){ 
            power = 0.5;}
        else{ 
            power= -0.5;}
        driver.setPower1(power);
    }
    //to move a meter when the wheel's diameter is 100 mm the wheel need to spin 100 times
    @Override
    public boolean isFinished(){
        return driver.getPosition() >= 100 || driver.getPosition() <= -100;
    }

    @Override
    public void end(boolean interrupted){
        driver.stop();
    }
}

