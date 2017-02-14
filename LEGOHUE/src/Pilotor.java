import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Robot that stops if it hits something before it completes its travel.
 */
public class Pilotor implements ButtonListener{
	public int d;
  DifferentialPilot pilot;
  TouchSensor bump = new TouchSensor(SensorPort.S1);

  public void go(int distance) {
    pilot.travel(distance, true);
    
    while (pilot.isMoving()) {
      if (bump.isPressed()) pilot.stop();
    }
    System.out.println(" "+pilot.getMovement().getDistanceTraveled());
    Button.waitForAnyPress();
  }

public void buttonPressed(Button b) {
	go(d);	
}

public void buttonReleased(Button b) {
	// TODO Auto-generated method stub
	
}
}