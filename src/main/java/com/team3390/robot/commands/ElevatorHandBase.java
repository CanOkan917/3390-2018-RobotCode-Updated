package com.team3390.robot.commands;

import com.team3390.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj2.command.Command;

public class ElevatorHandBase extends Command {
  
  private final ElevatorSubsystem m_elevatorSubsystem;

  private final double axis;

  public ElevatorHandBase(ElevatorSubsystem subsystem, double axis) {
    m_elevatorSubsystem = subsystem;
    this.axis = axis;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_elevatorSubsystem.baseMotor(axis);
  }

  @Override
  public void end(boolean interrupted) {
    m_elevatorSubsystem.stop();
  }
}
