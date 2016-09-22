import lejos.nxt.LCD;
import lejos.nxt.Motor;

public class TacometerPilot extends AbstractPilot{
	public TacometerPilot(){
		this.name = "TacometerPilot";
	}
	@Override
	public void pilot(int d) {
		Motor.B.forward();
		Motor.C.forward();
		
		while(Motor.A.getTachoCount() <= d){
			LCD.drawInt(Motor.A.getTachoCount(), 0, 1);
		}
		Motor.B.stop();
		Motor.C.stop();
	}
}
