import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;

public class SpeedAdjusterButtonListener implements ButtonListener{
	int incrementer = 0;
	
	public SpeedAdjusterButtonListener(int incrementer){
		this.incrementer = incrementer;
	}
	
	@Override
	public void buttonPressed(Button b) {
		Tacometro.distance += incrementer;
		LCD.clear();
		LCD.drawInt(Tacometro.distance, 0, 1);
	}

	@Override
	public void buttonReleased(Button b) {
		// TODO Auto-generated method stub
		
	}

}
