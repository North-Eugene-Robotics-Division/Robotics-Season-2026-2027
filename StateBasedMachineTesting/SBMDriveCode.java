package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.robot.Robot;
import java.util.ArrayList;
import com.qualcomm.robotcore.hardware.HardwareDevice;

import org.firstinspires.ftc.teamcode.SBMTestHardware;

@TeleOp(name="SBM_Test_Drive_Code", group="Linear OpMode")

public class SBMTestDriveCode extends LinearOpMode {
	private ElapsedTime runtime = new ElapsedTime();
	
	private int trackCheckTimeRuns = 0;
	private int cycleTime = 1000;
	
	private double checkTime;

	@Override
	public void runOpMode() {
		
		SBMTestHardware robot = new SBMTestHardware(this);
		SBM thisMachine = new SBM(this);
		robot.init();
		
		// telemetry.addData("Status", "Initialized");
		// telemetry.update();
		// Wait for the game to start (driver presses PLAY)
		waitForStart();
		runtime.reset();
		checkTime = runtime.milliseconds();
		
		// run until the end of the match (driver presses STOP)
		while (opModeIsActive()) {
			// telemetry.addData("Status", "Running");
			telemetry.addData("Runtime: ", runtime.milliseconds());
			telemetry.addData("SBM Checks: ", trackCheckTimeRuns);
			// telemetry.addData("Tracked Objects; ",thisMachine.SBMTelemetry("Objects"));
			// telemetry.addData("Tracked End Times: ",thisMachine.SBMTelemetry("FinishTime"));
			// telemetry.addData("Tracked Reset States: ",thisMachine.SBMTelemetry("ResetState"));
			// telemetry.update();

			// ArrayList<HardwareDevice> objs = thisMachine.SBMTelemetry("Objects");
			// ArrayList<Double> fTimes = thisMachine.SBMTelemetry("FinishTime");
			
			// for (int ObjNum = 0; ObjNum < objs.size(); ObjNum++){
			// 	telemetry.addData("Object: ", "%.0f Until: %.2f", ObjNum, fTimes.get(ObjNum));
			// 	telemetry.addData("Cycle", ObjNum);
			// }
			telemetry.update();
			
			if(gamepad1.xWasReleased()){
				robot.runMotor1(runtime.milliseconds());
			}
			if(gamepad1.yWasReleased()){
				robot.runMotor2(runtime.milliseconds());
			}
			if(checkTime+cycleTime<runtime.milliseconds()){
				thisMachine.checkSBM(runtime.milliseconds());
				trackCheckTimeRuns++;
				checkTime = runtime.milliseconds();
			}
		}
	}
}
