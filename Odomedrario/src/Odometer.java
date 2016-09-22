import lejos.nxt.ColorSensor;
import lejos.nxt.SensorPort;

public class Odometer {
	int voltas = 0;
	int redThreshold = 120;
	ColorSensor colorSensor;
	Boolean isInBlue = false;
	
	public Odometer(){
		colorSensor = new ColorSensor(SensorPort.S4);
	}
	
	public int getDistance(){		
		int red = colorSensor.getColor().getRed();
		
		if(!isInBlue && red > redThreshold){
			voltas++;
			isInBlue = true;
		}
		else if(isInBlue && red < redThreshold){
			isInBlue = false;
		}
		
		return voltas;
	}
}
