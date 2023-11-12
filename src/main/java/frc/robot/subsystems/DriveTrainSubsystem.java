package frc.robot.subsystems;


import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.*;
import frc.robot.Constants;

public class DriveTrainSubsystem extends SubsystemBase {
  private final CANSparkMax frontLeft = new CANSparkMax(Constants.MotorIDs.FRONT_LEFT_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
  private final CANSparkMax frontRight = new CANSparkMax(Constants.MotorIDs.FRONT_RIGHT_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
  private final CANSparkMax backLeft = new CANSparkMax(Constants.MotorIDs.BACK_LEFT_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
  private final CANSparkMax backRight = new CANSparkMax(Constants.MotorIDs.BACK_RIGHT_ID, CANSparkMaxLowLevel.MotorType.kBrushless);


  private final MotorControllerGroup leftGroup = new MotorControllerGroup(frontLeft, backLeft);
  private final MotorControllerGroup rightGroup = new MotorControllerGroup(frontRight, backRight);

  private final DifferentialDrive differentialDrive = new DifferentialDrive(leftGroup, rightGroup);
  public DriveTrainSubsystem() {
    configMotor(frontLeft);
    configMotor(frontRight);
    configMotor(backLeft);
    configMotor(backRight);

    leftGroup.setInverted(true);
    rightGroup.setInverted(false);
  }

  public void arcadeDrive(double speed, double turn) {
    differentialDrive.arcadeDrive(
            MathUtil.clamp(speed, -0.99, 0.99),
            MathUtil.clamp(turn, -0.99, 0.99));
  }

  public double getLeftEncoder() {
    return (frontLeft.getEncoder().getPosition() + backLeft.getEncoder().getPosition()) / 2;
  }

  public double getRightEncoder() {
    return -(frontRight.getEncoder().getPosition() + backRight.getEncoder().getPosition()) / 2;
  }

  public double getAverageEncoder() {
    return (getLeftEncoder() + getRightEncoder()) / 2;
  }

  public void stop() {
    differentialDrive.tankDrive(0,0);
  }

  public void resetEncoder() {
    frontLeft.getEncoder().setPosition(0);
    frontRight.getEncoder().setPosition(0);
    backLeft.getEncoder().setPosition(0);
    backRight.getEncoder().setPosition(0);
  }

  private void configMotor(CANSparkMax motor) {
    motor.restoreFactoryDefaults();
    motor.setIdleMode(CANSparkMax.IdleMode.kCoast);
    motor.setOpenLoopRampRate(Constants.MotorConfigurationConstants.RAMP_RATE);
    motor.getEncoder().setPositionConversionFactor(Constants.MotorConfigurationConstants.ROTATIONS_TO_INCHES);
  }
}

