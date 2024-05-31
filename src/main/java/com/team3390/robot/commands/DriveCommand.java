package com.team3390.robot.commands;

import com.team3390.robot.subsystems.DriveSubsystem;
import com.team3390.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

public class DriveCommand extends Command {
  
  private final DriveSubsystem m_driveSubsystem;
  private final ElevatorSubsystem m_elevatorSubsystem;
  private final Joystick m_leftJoystick;
  private final Joystick m_rightJoystick;
  private final Joystick gamepad;

  public DriveCommand(DriveSubsystem ds, ElevatorSubsystem es, Joystick left, Joystick right, Joystick g) {
    m_driveSubsystem = ds;
    m_elevatorSubsystem = es;
    m_leftJoystick = left;
    m_rightJoystick = right;
    gamepad = g;
    addRequirements(ds);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_driveSubsystem.tankDrive(
      () -> m_leftJoystick.getY(), // Değişkenin tipini "DoubleSupplier" olarak tanımladığımız için
      () -> m_rightJoystick.getY() // "() ->" argümanını koyup değeri vermemiz gerekiyor.
    );
    m_elevatorSubsystem.elevator( // Değişkenin tipini "DoubleSupplier" olarak tanımladığımız için
      () -> gamepad.getRawAxis(1) // "() ->" argümanını koyup değeri vermemiz gerekiyor.
    );
    m_elevatorSubsystem.hand(
      () -> gamepad.getRawAxis(3)
    );
  }

  @Override
  public void end(boolean interrupted) {
    m_driveSubsystem.stop();
    m_elevatorSubsystem.stop();
  }
}
