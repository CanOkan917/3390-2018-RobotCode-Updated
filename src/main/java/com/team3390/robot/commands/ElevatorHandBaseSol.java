package com.team3390.robot.commands;

import com.team3390.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj2.command.Command;

public class ElevatorHandBaseSol extends Command {
  
  private final ElevatorSubsystem m_elevatorSubsystem;
  private final boolean state;

  public ElevatorHandBaseSol(ElevatorSubsystem subsystem, boolean state) {
    m_elevatorSubsystem = subsystem;
    this.state = state;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_elevatorSubsystem.baseSolenoid(state);
  }

  @Override
  public void end(boolean interrupted) {}
}
