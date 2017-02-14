import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class UltrasonicPilot extends AbstractPilot{
	public UltrasonicPilot(){
		this.name = "UltrasonicPilot";
	}
	
	public void pilot(int d) {
		UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S1);
		Motor.B.backward();
		Motor.C.backward();
		
		while(sensor.getDistance() < d){
			LCD.drawInt(sensor.getDistance(), 0, 1);
		}
		
		Motor.B.stop();
		Motor.C.stop();
	}

}
