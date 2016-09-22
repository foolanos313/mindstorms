import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;
import lejos.nxt.Motor;

public abstract class AbstractPilot implements ButtonListener{
	protected String name = "pilot";
	
	public void InitialMessage(){
		System.out.println("Set the " + name +" distance:");
	}
	
	public void go(int d){
		LCD.clear();
		Motor.B.setSpeed(900);
		Motor.C.setSpeed(900);
		pilot(d);
		System.out.println(name + " is over!!!");
		Button.waitForAnyPress();
		Settings.walked = true;
	}
	
	public abstract void pilot(int d);
	
	@Override
	public void buttonPressed(Button b) {
		go(Settings.speed);
	}

	@Override
	public void buttonReleased(Button b) {}
}
