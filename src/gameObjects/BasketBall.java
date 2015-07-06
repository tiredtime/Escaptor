package gameObjects;

import graphics.ImageRenderer;
import graphics.Mover;
import main.GameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class BasketBall extends GameObjectImpl {
	private GameContainer gc;
	Shape shape = new Circle(0,0,25);
	private ImageRenderer renderer = new ImageRenderer("res/ball.png", shape);
	private Mover mover;
	
	public BasketBall(GameContainer gc, int x, int y) {
		this.gc = gc;
		shape.setLocation(x, y);
		initMover();
	}
	
	public BasketBall(GameContainer gc) {
		this.gc = gc;
		initMover();
		mover.randomizeLocation();
	}
	
	private void initMover() {
		mover = new Mover(shape, gc);
		mover.setSpeed(6, 3.2f);
	}
	
	@Override 
	public void update(GameState gs) {
		mover.bouncefromWindowFrame();
		mover.move();
	}
	
	@Override 
	public void collideWithPlayer(GameState gs) {
		gs.health -= 5;
	}

	@Override 
	public void render() {
		renderer.render(shape);
	}

	@Override 
	public Shape getShape() {
		return shape;
	}
}
