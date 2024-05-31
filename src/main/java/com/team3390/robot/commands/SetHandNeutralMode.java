package com.team3390.robot.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.team3390.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj2.command.Command;

public class SetHandNeutralMode extends Command {
  
  private final ElevatorSubsystem sub;
  private final NeutralMode mode;

  public SetHandNeutralMode(ElevatorSubsystem sub, NeutralMode mode) {
    this.sub = sub;
    this.mode = mode;
    addRequirements(sub);
  }

  @Override
  public void initialize() {
    sub.setHandNeutralMode(mode);
    System.out.println("New neutral mode value for hand : " + mode.name());
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
