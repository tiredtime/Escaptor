package gameObjects;

import graphics.ImageRenderer;
import main.GameState;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Hospital extends GameObjectImpl {
	private Rectangle shape = createShape();
	private ImageRenderer renderer = new ImageRenderer("res/hospital.png", shape);
	
	private Rectangle createShape() {
		shape = new Rectangle(0, 0, 0, 0);
		shape.setX(40);
		shape.setY(40);
		shape.setSize(50, 50);
		return shape;
	}

	public void collideWithPlayer(GameState gs) {
		int price = 2;
		if (gs.health < 100 && gs.score > price){
			gs.health += 1;
			gs.score -= price;
		}	
	}

	public void render() {
		renderer.render(shape);
	}
	
	public Shape getShape() {
		return shape;
	}
}
