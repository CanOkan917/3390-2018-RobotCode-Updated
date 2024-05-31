package com.team3390.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.team3390.robot.Constants;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

  private final WPI_VictorSPX frontLeftMotor = new WPI_VictorSPX(Constants.MotorConstants.kDriveFrontLeft);
	private final WPI_VictorSPX rearLeftMotor = new WPI_VictorSPX(Constants.MotorConstants.kDriveRearLeft);
	private final WPI_VictorSPX frontRightMotor = new WPI_VictorSPX(Constants.MotorConstants.kDriveFrontRight);
	private final WPI_VictorSPX rearRightMotor = new WPI_VictorSPX(Constants.MotorConstants.kDriveRearRight);

  private final DifferentialDrive robotDrive;

  public DriveSubsystem() {
    rearLeftMotor.follow(frontLeftMotor);
    rearRightMotor.follow(frontRightMotor);
    robotDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
  }

  public void tankDrive(DoubleSupplier left, DoubleSupplier right) {
    robotDrive.tankDrive(left.getAsDouble(), right.getAsDouble());
  }

  public void arcadeDrive(double a, double b) {
    robotDrive.arcadeDrive(a, b);
  }

  public void rotate(double rotation) {
    robotDrive.arcadeDrive(0, rotation);
  }

  public void stop() {
    robotDrive.stopMotor();
  }
}
