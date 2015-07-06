package gameObjects;

import graphics.ImageRenderer;

import java.util.Random;

import main.GameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class RainDrop extends GameObjectImpl {
	private GameContainer gc;
	private Circle shape = new Circle(0, 0, 15);
	private ImageRenderer renderer;
	
	public RainDrop(GameContainer gc) {
		this.gc = gc;
		setRandomCenterX();
		renderer = new ImageRenderer("res/rainDrop2.png", shape);
	}

	private void setRandomCenterX() {
		int x = new Random().nextInt(gc.getWidth());
		shape.setCenterX(x);
	}

	@Override
	public void update(GameState gs) {
		shape.setY(shape.getY() + 2);
		if (shape.getMinY() >= gc.getScreenHeight()){
			gs.objectsToDelete.add(this);
		}
	}

	@Override
	public Shape getShape() {
		return shape;
	}

	@Override
	public void collideWithPlayer(GameState gs) {
		gs.health += 0;
		gs.score += 10;
		gs.objectsToDelete.add(this);
	}
	
	@Override
	public void render() {
		renderer.render(shape);
	}
}
