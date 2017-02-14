import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;

public class SpeedAdjusterButtonListener implements ButtonListener{
	int incrementer = 0;
	
	public SpeedAdjusterButtonListener(int incrementer){
		this.incrementer = incrementer;
	}
	
	public void buttonPressed(Button b) {
		Settings.speed += incrementer;
		LCD.clear();
		LCD.drawInt(Settings.speed, 0, 1);
	}

	public void buttonReleased(Button b) {}

}
