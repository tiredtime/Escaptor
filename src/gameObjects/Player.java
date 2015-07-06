package gameObjects;

import graphics.ImageRenderer;
import main.GameObject;
import main.GameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class Player extends GameObjectImpl {
	Image img;
	Circle shape = new Circle(0,0,25);
	private GameContainer gc;
	private ImageRenderer renderer = new ImageRenderer("res/playerRegular.png", shape);;
	
	public Player(GameContainer gc) {
		this.gc = gc;
	}

	public void resize(int radiusDelta) {
		//circle.setRadius just does not work, Slick2d bug
		float radius = shape.getRadius();
		shape = new Circle(0, 0, radius + radiusDelta);
		setLocationToMousePosition();
		renderer.resizeImg(shape);
	}

	public void render(){
		renderer.render(shape);
	}

	public void update(GameState gs) {
		setLocationToMousePosition();
		for (GameObject o : gs.gameObjects) {
			if (gs.player.intersects(o)) {
				o.collideWithPlayer(gs);
			}
		}
	}

	private void setLocationToMousePosition() {
		int x = gc.getInput().getMouseX();
		int y = gc.getInput().getMouseY();
		shape.setLocation(x, y);
	}

	public Shape getShape() {
		return shape;
	}
	
	public boolean intersects(GameObject o) {
		return shape.intersects(o.getShape());
	}
}
