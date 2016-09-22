import lejos.nxt.Button;
import lejos.nxt.LCD;

public class Odomedrario {

	public static void main(String[] args) {
		Pilot(new OdometerPilot(), 1);
	}

	static void Pilot(AbstractPilot pilot, int rate){
		pilot.InitialMessage();
		LCD.drawInt(Settings.speed, 0, 3);
		Button.ENTER.addButtonListener(pilot);
		Button.LEFT.addButtonListener(new SpeedAdjusterButtonListener(-rate));
		Button.RIGHT.addButtonListener(new SpeedAdjusterButtonListener(rate));
		while(!Settings.walked);
	}
}
