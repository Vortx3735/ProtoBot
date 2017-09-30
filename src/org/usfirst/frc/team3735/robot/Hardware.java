package org.usfirst.frc.team3735.robot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Solenoid;
import com.ctre.CANTalon;

public class Hardware {
	private static ArrayList<Integer> takenPorts = new ArrayList<Integer>();
	private static CANTalon[] motors = new CANTalon[17];	//just ignore cantalon[0]
	
	public static CANTalon getMotor(int port) {
		if(!takenPorts.contains((Integer) port)) {
			motors[port] = new CANTalon(port);
		}
		return motors[port];
	}
	
	private static ArrayList<Integer> takenPortsSol = new ArrayList<Integer>();
	private static Solenoid[] sols = new Solenoid[10];
	
	public static Solenoid getSolenoid(int port) {
		if(!takenPortsSol.contains((Integer) port)) {
			sols[port] = new Solenoid(port);
			takenPortsSol.add((Integer)port);
		}
		return sols[port];
	}
}
