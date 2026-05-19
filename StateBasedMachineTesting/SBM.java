package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import java.util.List;
import java.lang.reflect.Array;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import java.util.ArrayList;
import java.util.Collections;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.SBMTestHardware;
import org.firstinspires.ftc.teamcode.SBMTestDriveCode;

public class SBM {

	// HardwareDevice to allow for servos and motors, both implement it.
	public ArrayList<HardwareDevice> objects = new ArrayList<HardwareDevice>();
	
	//Time list is the time in miliseconds when the corresponding object needs to be turned off
	public ArrayList<Double> finishTime = new ArrayList<Double>();
	
	//ResetState is the value to set the hardware device to after the time is up - usually a default servo position or 0 for motors
	public ArrayList<Float> resetState = new ArrayList<Float>();
	
	public ArrayList<String> name = new ArrayList<String>();
	
	public ArrayList<String> testNames = new ArrayList<String>(List.of("John", "Jeff", "Jacob"));
	public int trackedAddSBM;
	
	private SBMTestHardware theRobot = null;
	private SBMTestDriveCode myOpMode = null;
	
	public SBM(SBMTestHardware hardware) {
		theRobot = hardware;
	}
	
	public SBM(SBMTestDriveCode opmode) {
		myOpMode = opmode;
	}

	//Used by other files to add objects and their timers to the SBM checklist
	public void addSBM(HardwareDevice object, double endTime, float state, String objName) {
		objects.add(object);
		finishTime.add(endTime);
		resetState.add(state);
		name.add(objName);
		trackedAddSBM++;
	}
	
	public void checkSBM(double runtime) {
		//go through all objects in sbm
		for (int i = 0; i > objects.size(); i++) {
			// if the current time is past the object's finish time 
			if (finishTime.get(i) < runtime) {
				// possibly change this to switch statement
				if (objects.get(i) instanceof DcMotor) {
					DcMotor temp = (DcMotor) objects.get(i);
					temp.setPower(resetState.get(i));
				} else if (objects.get(i) instanceof Servo) {
					Servo temp = (Servo) objects.get(i);
					temp.setPosition(resetState.get(i));
				} else {
					
				}
				
			} 
		}
	}
	
	public ArrayList SBMTelemetry(String list) {
		ArrayList<String> returnVal = new ArrayList<String>();
		returnVal.add("Unkown");
		if (list == "Objects") {
			return objects.size();
		} else if (list == "FinishTime") {
			return finishTime;
		} else if (list == "ResetState") {
			return resetState;
		} else if (list == "Name") {
			return name;
		}
		return returnVal;
	}
}
