import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class OdometerPilot extends AbstractPilot{
	public OdometerPilot(){
		this.name = "OdometerPilot";
	}
	
	@Override
	public void pilot(int d) {
		float myd = d;
		Boolean isInBlue = false;
		int redThreshold = 120;
		int voltas  = 0;
		ColorSensor colorSensor = new ColorSensor(SensorPort.S4);
		
		Motor.B.backward();
		Motor.C.backward();
		
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
	}
}
