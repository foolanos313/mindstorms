import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class Tacometro {
	public static int distance = 0;
	public static boolean walked = false;

	public static void main(String[] args) {
		System.out.println("Starting...");
		Button.waitForAnyPress();
		
		UltraMotor motor = new UltraMotor();
		motor.Measurement();
	}
	
	static void Run(ButtonListener buttonListener){
		System.out.println("HUE");
		LCD.drawInt(Tacometro.distance, 0, 1);
		Button.ENTER.addButtonListener(buttonListener);;
		Button.LEFT.addButtonListener(new SpeedAdjusterButtonListener(-180));
		Button.RIGHT.addButtonListener(new SpeedAdjusterButtonListener(180));
		while(!walked);
	}
	
	static void HereWeGo(){
		Motora motora = new Motora();
		motora.Go(3600);
	}
	
	static void NoPilotTest(){
		System.out.println("Tacometro");
		
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
