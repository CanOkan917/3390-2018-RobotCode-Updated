package com.team3390.robot.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.team3390.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj2.command.Command;

public class SetElevatorNeutralMode extends Command {
  
  private final ElevatorSubsystem sub;
  private final NeutralMode mode;

  public SetElevatorNeutralMode(ElevatorSubsystem sub, NeutralMode mode) {
    this.sub = sub;
    this.mode = mode;
    addRequirements(sub);
  }

  @Override
  public void initialize() {
    sub.setElevatorNeutralMode(mode);
    System.out.println("New neutral mode value for elevator : " + mode.name());
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
