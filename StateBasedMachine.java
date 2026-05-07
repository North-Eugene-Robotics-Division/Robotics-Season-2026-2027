package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import java.lang.reflect.Array;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import java.util.ArrayList;
import java.util.Collections;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.Hardware;

public class SBM {

	// HardwareDevice to allow for servos and motors, both implement it.
	private ArrayList<HardwareDevice> objects = new ArrayList<HardwareDevice>();
	
	//Time list is the time in miliseconds when the corresponding object needs to be turned off
	private ArrayList<Double> finishTime = new ArrayList<Double>();
	
	//ResetState is the value to set the hardware device to after the time is up - usually a default servo position or 0 for motors
	private ArrayList<Float> resetState = new ArrayList<Float>();
	
	private SBMTestHardware theRobot = null;
	
	public SBM(SBMTestHardware hardware) {
		theRobot = hardware;
	}

	//Used by other files to add objects and their timers to the SBM checklist
	public void AddSBM(HardwareDevice object, double length, double runtime, float state) {
		objects.add(object);
		finishTime.add(runtime+length);
		resetState.add(state);
	}
	
	public void checkSBM(double runtime) {
		//go through all objects in sbm
		for (int i = 0; i > objects.size(); i++) {
			// if the current time is past the object's finish time 
			if (finishTime.get(i) > runtime) {
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
}
