import lejos.nxt.Motor;

public class OdometerPilot extends AbstractPilot{
	public OdometerPilot(){
		this.name = "OdometerPilot";
	}
	
	public void pilot(int d) {
		Odometer odometer = new Odometer();
		
		Motor.B.backward();
		Motor.C.backward();
		
		while(odometer.getDistance() < d){
		}
		
		Motor.B.stop();
		Motor.C.stop();		
	}
}
