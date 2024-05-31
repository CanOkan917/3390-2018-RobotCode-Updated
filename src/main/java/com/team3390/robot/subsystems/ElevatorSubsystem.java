package com.team3390.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.team3390.robot.Constants;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.MathUtil;

public class ElevatorSubsystem extends SubsystemBase {
  
  private final WPI_VictorSPX elevatorMotor1 = new WPI_VictorSPX(Constants.MotorConstants.kElevator1);
  private final WPI_VictorSPX elevatorMotor2 = new WPI_VictorSPX(Constants.MotorConstants.kElevator2);

  private final WPI_VictorSPX handMotor1 = new WPI_VictorSPX(Constants.MotorConstants.kHandMotor1);

  private final WPI_VictorSPX baseMotor1 = new WPI_VictorSPX(Constants.MotorConstants.kBaseMotor1);
  private final WPI_VictorSPX baseMotor2 = new WPI_VictorSPX(Constants.MotorConstants.kBaseMotor2);

  private final Solenoid baseSolenoid = new Solenoid(Constants.PCM.moduleType, Constants.PCM.kBaseSolenoid);

  public ElevatorSubsystem() {
    elevatorMotor1.setInverted(true);

    elevatorMotor1.setNeutralMode(NeutralMode.Coast);
    elevatorMotor2.setNeutralMode(NeutralMode.Coast);
    handMotor1.setNeutralMode(NeutralMode.Coast);

    baseMotor2.follow(baseMotor1);
    elevatorMotor2.follow(elevatorMotor1);
  }

  public void elevator(DoubleSupplier axis) {
    if (Math.abs(axis.getAsDouble()) != 0.05) {
      double output = MathUtil.clamp(axis.getAsDouble(), -0.8, 0.8);
      elevatorMotor1.set(output);
    } else {
      elevatorMotor1.setNeutralMode(NeutralMode.Brake);
      elevatorMotor2.setNeutralMode(NeutralMode.Brake);
    }
  }
  public void hand(DoubleSupplier axis) {
    if (Math.abs(axis.getAsDouble()) != 0.15) {
      handMotor1.set(axis.getAsDouble() * -(0.8));
    } else {
      handMotor1.setNeutralMode(NeutralMode.Brake);
    }
  }
  public void baseMotor(double axis) {
    if (Math.abs(axis) == 1) {
      baseMotor1.set(1 * axis);
    }
  }
  public void baseSolenoid(boolean state) {
    baseSolenoid.set(state);
  }

  public void setElevatorNeutralMode(NeutralMode mode) {
    elevatorMotor1.setNeutralMode(mode);
    elevatorMotor2.setNeutralMode(mode);
  }

  public void setHandNeutralMode(NeutralMode mode) {
    handMotor1.setNeutralMode(mode);
  }

  public void stop() {
    elevatorMotor1.setNeutralMode(NeutralMode.Brake);
    elevatorMotor2.setNeutralMode(NeutralMode.Brake);
    handMotor1.setNeutralMode(NeutralMode.Brake);
    baseMotor1.set(0);
  }

}
