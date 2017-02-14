import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class OdoMotora implements ButtonListener{
	public void Go(float d){
		float myd = d / 180.0f;
		boolean isInBlue = false;
		int redThreshold = 120;
		int voltas  = 0;
		ColorSensor colorSensor = new ColorSensor(SensorPort.S4);
		LCD.clear();
		
		Motor.B.setSpeed(900);
		Motor.C.setSpeed(900);
		
		Motor.B.forward();
		Motor.C.forward();
		
		while(voltas < myd){
			int red = colorSensor.getColor().getRed();
			if(!isInBlue && red > redThreshold){
				voltas++;
				isInBlue = true;
			}
			else if(isInBlue && red < redThreshold){
				isInBlue = false;
			}
			
			LCD.drawInt(voltas, 0, 0);
			LCD.drawInt(red, 0, 1);
			LCD.drawInt(Motor.C.getTachoCount(), 0, 2);
		}
		
		Motor.B.stop();
		Motor.C.stop();
		
		System.out.println("OdoMotor is over!!!");
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
