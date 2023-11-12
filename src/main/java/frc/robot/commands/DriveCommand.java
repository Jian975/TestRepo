package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSubsystem;

import java.util.function.DoubleSupplier;


public class DriveCommand extends CommandBase {
  private final DriveTrainSubsystem driveTrainSubsystem;
  private final DoubleSupplier speedSupplier, turnSupplier;

  public DriveCommand(DriveTrainSubsystem driveTrainSubsystem, DoubleSupplier speedSupplier,
                      DoubleSupplier turnSupplier) {
    this.driveTrainSubsystem = driveTrainSubsystem;
    this.speedSupplier = speedSupplier;
    this.turnSupplier = turnSupplier;
    addRequirements(this.driveTrainSubsystem);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    driveTrainSubsystem.arcadeDrive(
            speedSupplier.getAsDouble() * Constants.Multipliers.SPEED_MULTIPLIER,
            turnSupplier.getAsDouble() * Constants.Multipliers.TURN_MULTIPLIER);
  }

  @Override
  public boolean isFinished() {
    // TODO: Make this return true when this Command no longer needs to run execute()
    return false;
  }

  @Override
  public void end(boolean interrupted) {

  }
}
