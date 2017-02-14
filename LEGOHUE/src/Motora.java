import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;
import lejos.nxt.Motor;

public class Motora implements ButtonListener{
	public void Go(float d){
		System.out.println("Opa Wopa Cheeki Breeki");
		Button.waitForAnyPress();
		LCD.clear();
		
		Motor.A.setSpeed(900);
		Motor.B.setSpeed(900);
		Motor.C.setSpeed(900);
		
		Motor.A.forward();
		Motor.B.forward();
		Motor.C.forward();
		
		while(Motor.A.getTachoCount() <= d){
			LCD.drawInt(Motor.A.getTachoCount(), 0, 1);
		}
		
		Motor.A.stop();
		Motor.B.stop();
		Motor.C.stop();

		System.out.println("Its over!!");
		Button.waitForAnyPress();
		Tacometro.walked = true;
	}

	public void buttonPressed(Button b) {
		Go(Tacometro.distance);
		
	}

	public void buttonReleased(Button b) {
		// TODO Auto-generated method stub
		
	}
}
