// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OperatorConstants;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveTrainSubsystem;

public class RobotContainer
{
    private final XboxController driverController =
            new XboxController(OperatorConstants.DRIVER_CONTROLLER_PORT);
    private final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();
    private final DriveCommand driveCommand = new DriveCommand(driveTrainSubsystem,
            driverController::getLeftY, driverController::getRightY);
    
    public RobotContainer()
    {
        configureBindings();
        configureDefaultCommands();
    }

    private void configureBindings()
    {
    }

    private void configureDefaultCommands() {
        driveTrainSubsystem.setDefaultCommand(driveCommand);
    }

    public Command getAutonomousCommand()
    {
        return null;
    }
}
