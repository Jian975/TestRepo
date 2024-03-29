// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{
    public static class MotorIDs {
        public static final int FRONT_LEFT_ID = 1;
        public static final int BACK_RIGHT_ID = 2;
        public static final int FRONT_RIGHT_ID = 3;
        public static final int BACK_LEFT_ID = 4;
    }

    public static class MotorConfigurationConstants {

        public static final double ROTATIONS_TO_INCHES = 1;
        public static final double RAMP_RATE = 0.2;
    }

    public static class Multipliers {

        public static final double TURN_MULTIPLIER = 0.6;
        public static final double SPEED_MULTIPLIER = 0.9;
    }
    public static class OperatorConstants
    {
        public static final int DRIVER_CONTROLLER_PORT = 0;
    }
}
