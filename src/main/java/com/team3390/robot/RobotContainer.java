package com.team3390.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.team3390.robot.commands.DriveCommand;
import com.team3390.robot.commands.ElevatorHandBase;
import com.team3390.robot.commands.ElevatorHandBaseSol;
import com.team3390.robot.commands.SetElevatorNeutralMode;
import com.team3390.robot.commands.SetHandNeutralMode;
import com.team3390.robot.subsystems.DriveSubsystem;
import com.team3390.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  
  public final Compressor compressor = new Compressor(Constants.PCM.moduleType);

  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final ElevatorSubsystem m_elevatorSubsystem = new ElevatorSubsystem();

  public final Joystick m_leftJoystick = new Joystick(Constants.OIConstants.kLeftJoystickPort);
  public final Joystick m_rightJoystick = new Joystick(Constants.OIConstants.kRightJoystickPort);
  public final Joystick m_atari1 = new Joystick(Constants.OIConstants.kAtari1Port);
  public final Joystick m_atari2 = new Joystick(Constants.OIConstants.kAtari2Port);
  public final Joystick m_gamepad = new Joystick(Constants.OIConstants.kGamepadPort);
  
  public RobotContainer() {
    // Drive Command'ın default(varsayılan) olarak belirliyoruz
    m_driveSubsystem.setDefaultCommand(new DriveCommand(m_driveSubsystem, m_elevatorSubsystem, m_leftJoystick, m_rightJoystick, m_gamepad));

    new Trigger(() -> m_gamepad.getRawButton(6)).whileTrue(new ElevatorHandBase(m_elevatorSubsystem, 1));
    new Trigger(() -> m_gamepad.getRawButton(5)).whileTrue(new ElevatorHandBase(m_elevatorSubsystem, -1));
    // Toggles elevator hand solenoid
    new Trigger(() -> m_gamepad.getRawButton(7)).onTrue(new ElevatorHandBaseSol(m_elevatorSubsystem, true));
    new Trigger(() -> m_gamepad.getRawButton(7)).onFalse(new ElevatorHandBaseSol(m_elevatorSubsystem, false));

    new Trigger(() -> m_gamepad.getRawButton(1)).onTrue(new SetElevatorNeutralMode(m_elevatorSubsystem, NeutralMode.Brake));
    new Trigger(() -> m_gamepad.getRawButton(2)).onTrue(new SetElevatorNeutralMode(m_elevatorSubsystem, NeutralMode.Coast));
    new Trigger(() -> m_gamepad.getRawButton(3)).onTrue(new SetHandNeutralMode(m_elevatorSubsystem, NeutralMode.Brake));
    new Trigger(() -> m_gamepad.getRawButton(4)).onTrue(new SetHandNeutralMode(m_elevatorSubsystem, NeutralMode.Coast));

    // SmartDashboard'a kompresörün çalışıp çalışmadığını "Compressor Start" adında yazdırıyoruz.
    // Boolean olarak yazdırdığımız için true ya da false yazıcak.
    SmartDashboard.putBoolean("Compressor Start", compressor.isEnabled());
    // SmartDashboard'a pressure switch değerinin ~120PSI olup olmadığını yazdırıyoruz.
    // Zaten daha fazla olunca kompresör duruyor. (inşallah)
    SmartDashboard.putBoolean("Pressure Switch", compressor.getPressureSwitchValue());
  }
  
  public Command getAutonomousCommand() {
    return null;
  }
}
