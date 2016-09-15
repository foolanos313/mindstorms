import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class OdometerPilot implements ButtonListener{
	public void Go(float d){
		System.out.println("Press any key to start OdometerPilot...");
		Button.waitForAnyPress();
		LCD.clear();
		
		float myd = d / 180.0f;
		Boolean isInBlue = false;
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
		
		System.out.println("OdometerPilot is over!!!");
		Button.waitForAnyPress();
		Settings.walked = true;
	}

	@Override
	public void buttonPressed(Button b) {
		Go(Settings.speed);
		
	}

	@Override
	public void buttonReleased(Button b) {
		// TODO Auto-generated method stub
		
	}
}
