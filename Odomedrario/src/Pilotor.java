import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Robot that stops if it hits something before it completes its travel.
 */
public class Pilotor {
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
}