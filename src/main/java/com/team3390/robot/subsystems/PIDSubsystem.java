package com.team3390.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.MathUtil;

public class PIDSubsystem extends SubsystemBase {
  private final PIDController PID;

  private double maxOutput;
  private double minOutput;

  public PIDSubsystem(double kP, double kI, double kD, double tolerance, double maxOutput, double minOutput) {
    this.maxOutput = maxOutput;
    this.minOutput = minOutput;

    PID = new PIDController(kP, kI, kD);
    PID.setTolerance(tolerance);
  }

  public double calculate(double input, double target) {
    return PID.calculate(input, target);
  }

  public double output(double error) {
    return MathUtil.clamp(error, this.minOutput, this.maxOutput);
  }

  public boolean atSetpoint() {
    return PID.atSetpoint();
  }

  public void enableContinuousInput() {
    PID.enableContinuousInput(-180.0, 180.0);
  }

  public void disableContinuousInput() {
    PID.disableContinuousInput();
  }

  public void reset() {
    PID.reset();
  }
}
