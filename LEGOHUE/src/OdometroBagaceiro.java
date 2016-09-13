import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class OdometroBagaceiro {

	public static void main(String[] args) {
		Boolean isInBlue = false;
		int redThreshold = 120;
		int voltas  = 0;
		System.out.println("Metal is the law!!!");
		ColorSensor colorSensor = new ColorSensor(SensorPort.S4);
		
		Button.waitForAnyPress();
		LCD.clear();
		
		Motor.B.forward();
		Motor.C.forward();
		
		while(voltas < 20){
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
	}


}
