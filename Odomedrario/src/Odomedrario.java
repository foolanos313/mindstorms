import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;

public class Odomedrario {

	public static void main(String[] args) {
		Pilot(new TacometerPilot(), 180);
	}

	static void Pilot(ButtonListener pilot, int rate){
		LCD.drawInt(Settings.speed, 0, 1);
		Button.ENTER.addButtonListener(pilot);;
		Button.LEFT.addButtonListener(new SpeedAdjusterButtonListener(-rate));
		Button.RIGHT.addButtonListener(new SpeedAdjusterButtonListener(rate));
		while(!Settings.walked);
	}
}
