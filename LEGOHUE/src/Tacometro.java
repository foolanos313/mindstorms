import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class Tacometro {

	public static void main(String[] args) {
		PilotTest();
	}
	
	static void NoPilotTest(){
		System.out.println("Tacometro");
		ColorSensor colorSensor = new ColorSensor(SensorPort.S4);
		
		Button.waitForAnyPress();
		LCD.clear();
		
		Motor.B.forward();
		Motor.C.forward();
		
		while(Motor.B.getTachoCount() < 7200);
		
		Motor.B.stop();
		Motor.C.stop();
		LCD.drawInt(Motor.B.getTachoCount(), 0, 1);
		Button.waitForAnyPress();
	}
	
	static void PilotTest(){
		Pilotor traveler = new Pilotor();
	    traveler.pilot = new DifferentialPilot(4.5f, 10, Motor.B, Motor.C);
	    Button.waitForAnyPress();
	    traveler.go(400);
	    System.out.println(Motor.B.getTachoCount());
	    Button.waitForAnyPress();
	}
}
