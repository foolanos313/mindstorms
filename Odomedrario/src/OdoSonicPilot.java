import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class OdoSonicPilot extends AbstractPilot {
	public OdoSonicPilot(){
		this.name = "OdoSonicPilot";
	}
	
	public void pilot(int d) {
		Odometer odometer = new Odometer();
		UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S1);
		
		float odoWeight = 0.020298f;
		float d_traveled = 0;
		
		Motor.B.backward();
		Motor.C.backward();
		
		while(d_traveled < d){
			d_traveled = odometer.getDistance() * odoWeight + (sensor.getDistance() / 14) * (1-odoWeight);			
		}
		
		Motor.B.stop();
		Motor.C.stop();
		
	}

}
