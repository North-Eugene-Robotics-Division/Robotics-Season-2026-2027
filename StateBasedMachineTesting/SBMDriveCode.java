package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.teamcode.SBMTestHardware;

@TeleOp(name="SBM_Test_Drive_Code", group="Linear OpMode")

public class SBMTestDriveCode extends LinearOpMode {
	private ElapsedTime runtime = new ElapsedTime();
	
	private int trackCheckTimeRuns = 0;
	
	private double checkTime;

	@Override
	public void runOpMode() {
		
		SBMTestHardware robot = new SBMTestHardware(this);
		SBM thisMachine = new SBM(this);
		robot.init();
		
		telemetry.addData("Status", "Initialized");
		telemetry.update();
		// Wait for the game to start (driver presses PLAY)
		waitForStart();
		runtime.reset();
		checkTime = runtime.milliseconds();
		
		// run until the end of the match (driver presses STOP)
		while (opModeIsActive()) {
			telemetry.addData("Status", "Running");
			telemetry.addData("Runtime: ", runtime.milliseconds());
			telemetry.addData("SBM Checks: ", trackCheckTimeRuns);
			telemetry.addData("Tracked Objects; ",thisMachine.SBMTelemetry("Objects"));
			telemetry.addData("Tracked End Times: ",thisMachine.SBMTelemetry("FinishTime"));
			telemetry.addData("Tracked Reset States: ",thisMachine.SBMTelemetry("ResetState"));
			telemetry.update();
			
			if(gamepad1.xWasReleased()){
				robot.runMotor1(runtime.milliseconds());
			}
			if(gamepad1.yWasReleased()){
				robot.runMotor2(runtime.milliseconds());
			}
			if(checkTime<runtime.milliseconds()){
				thisMachine.checkSBM(runtime.milliseconds());
				trackCheckTimeRuns++;
			}
		}
	}
}
