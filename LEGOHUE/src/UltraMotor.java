import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.util.Delay;

public class UltraMotor {
	public void Measurement(){
		UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S1);
		
		while(true){
			LCD.drawInt(sensor.getDistance(), 0, 1);
			Delay.msDelay(100);
			LCD.clear();
		}
	}
}
