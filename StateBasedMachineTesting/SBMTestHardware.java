package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import org.firstinspires.ftc.robotcore.external.State;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import java.util.Collections;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.SBM;

public class SBMTestHardware {
	
	public LinearOpMode myOpMode = null;
	//public ElapsedTime runtime = new ElapsedTime();

	public DcMotor motor1 = null;
	public DcMotor motor2 = null;
	
	// public Servo servo1 = null;
	// public Servo servo2 = null;
	
	// public CRServo crServo1 = null;
	// public CRServo crServo2 = null;
	
	private SBM thisMachine = null;
	
	public SBMTestHardware (LinearOpMode opmode) {
		myOpMode = opmode;
	}
	
	public void init () {
		motor1 = myOpMode.hardwareMap.get(DcMotor.class, "Motor1");
		motor2 = myOpMode.hardwareMap.get(DcMotor.class, "Motor2");
		
		// servo1 = myOpMode.hardwareMap.get(Servo.class, "Servo1");
		// servo2 = myOpMode.hardwareMap.get(Servo.class, "Servo2");
		
		// crServo1 = myOpMode.hardwareMap.get(CRServo.class, "crServo1");
		// crServo2 = myOpMode.hardwareMap.get(CRServo.class, "crServo2");
		
		motor1.setDirection(DcMotor.Direction.FORWARD);
		motor2.setDirection(DcMotor.Direction.FORWARD);
	
		// servo1.setPosition(0);
		// servo2.setPosition(0);
		
		thisMachine = new SBM(this);
	}
	
	public void runMotor1(double runtime) {
		motor1.setPower(.5);
		
		thisMachine.addSBM(motor1, 3000, runtime, 0);
	}
	public void runMotor2(double runtime) {
		motor2.setPower(.3);
		
		thisMachine.addSBM(motor1, 4000, runtime, 0);
	}
	public void runCheckSBM(double runtime){
		thisMachine.checkSBM(runtime);
	}
}
