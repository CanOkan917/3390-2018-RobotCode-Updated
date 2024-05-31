package com.team3390.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

public final class Constants {

    public static final class MotorConstants {
        public static final int kDriveFrontLeft = 6;
        public static final int kDriveFrontRight = 2;
        public static final int kDriveRearLeft = 7;
        public static final int kDriveRearRight = 3;

        public static final int kElevator1 = 4;
        public static final int kElevator2 = 5;
        
        public static final int kHandMotor1 = 0;

        public static final int kBaseMotor1 = 8;
        public static final int kBaseMotor2 = 9;
    }

    public static final class OIConstants {
        public static final int kLeftJoystickPort = 0;
        public static final int kRightJoystickPort = 1;
        public static final int kAtari1Port = 2;
        public static final int kAtari2Port = 3;
        public static final int kGamepadPort = 4;
    }

    public static final class PCM {
        public static final PneumaticsModuleType moduleType = PneumaticsModuleType.CTREPCM;

        public static final int kBaseSolenoid = 0;
    }

    public static final class GAMEPAD_AXIS {
        public static final int LEFT_X = 0;
        public static final int LEFT_Y = 1;
        public static final int RIGHT_X = 2;
        public static final int RIGHT_Y = 3;
    }

}
