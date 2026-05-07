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
	
	private double checkTime;

	@Override
	public void runOpMode() {
		
		SBMTestHardware robot = new SBMTestHardware(this);
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
			telemetry.update();
			
			if(gamepad1.xWasReleased()){
				robot.runMotor1(runtime.milliseconds());
			}
			if(gamepad1.yWasReleased()){
				robot.runMotor2(runtime.milliseconds());
			}
			if(checkTime>runtime.milliseconds()){
				robot.runCheckSBM(runtime.milliseconds());
			}
		}
	}
}
