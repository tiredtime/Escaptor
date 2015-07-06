package gameObjects;

import main.GameState;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class PointsCircle extends GameObjectImpl {
	Shape shape; 
	private GameContainer gc;
			
	public PointsCircle(GameContainer gc) {
		this.gc = gc;
		shape = new Circle(gc.getWidth()/2, gc.getHeight()/2, 100);
	}

	@Override
	public void render() {
		gc.getGraphics().setColor(Color.green);
		gc.getGraphics().fill(shape);
	}

	@Override
	public Shape getShape() {
		return shape;
	}

	@Override
	public void collideWithPlayer(GameState gs) {
		gs.score += 1;
	}
}
