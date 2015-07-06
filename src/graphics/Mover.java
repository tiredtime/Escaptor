package graphics;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public class Mover {
	private Shape shape;
	private Speed speed;
	private GameContainer gc;

	public Mover(Shape shape, GameContainer gc) {
		this.shape = shape;
		this.gc = gc;
	}
	
	public void move() {
		Vector2f location = shape.getLocation();
		shape.setLocation(location.x + speed.x, location.y + speed.y);
	}
	
	public void setSpeed(float dx, float dy) {
		if (speed == null){
			speed = new Speed();
			speed.x = dx;
			speed.y = dy;
		} else {
			//to preserve direction
			speed.x =  Math.signum(speed.x) * dx;
			speed.y =  Math.signum(speed.y) * dy;
		}
	}
	
	public void bouncefromWindowFrame() {
		Vector2f location = shape.getLocation();
		if (location.x >= gc.getWidth() - shape.getWidth()) 
			speed.x = -Math.abs(speed.x);
		if (location.x <= 0) 
			speed.x = Math.abs(speed.x);
		if (location.y >= gc.getHeight() - shape.getHeight()) 
			speed.y = -Math.abs(speed.y);
		if (location.y <= 0) 
			speed.y = Math.abs(speed.y);
	}
	
	public boolean isOutOfBounds() {
		//TODO
		return false;
	}
	
	public void randomizeLocation() {
		Random generator = new Random();
		int x = generator.nextInt(gc.getWidth());
		int y = generator.nextInt(gc.getHeight());
		shape.setLocation(x, y);
	}
}
