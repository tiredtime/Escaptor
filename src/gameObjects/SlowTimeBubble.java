package gameObjects;

import graphics.ImageRenderer;
import graphics.Mover;
import main.Game;
import main.GameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class SlowTimeBubble extends GameObjectImpl {
	Shape shape = new Circle(300, 300, 65);
	private GameContainer gc;
	private ImageRenderer renderer = new ImageRenderer("res/slowTimeBubble.png", shape);
	private Mover mover;
	
	public SlowTimeBubble(GameContainer gc) {
		this.gc = gc;
		initMover();
	}

	private void initMover() {
		mover = new Mover(shape, gc);
		mover.setSpeed(1, 3);
	}

	@Override
	public void update(GameState gs){
		controlTimeSpeed(gs);
		mover.move();
		mover.bouncefromWindowFrame();
	}

	private void controlTimeSpeed(GameState gs) {
		if (isPlayerInside(gs)){
			//not sure if this is a hack
			gc.setTargetFrameRate(Game.DEFAULT_FRAMERATE/2);
			mover.setSpeed(3, 1);
		} else {
			gc.setTargetFrameRate(Game.DEFAULT_FRAMERATE);
			mover.setSpeed(1, 3);
		}
	}

	private boolean isPlayerInside(GameState gs) {
		Shape player = gs.player.getShape();
		return shape.getMaxX() > player.getMaxX() &&
			   shape.getMaxY() > player.getMaxY() &&
			   shape.getMinX() < player.getMinX() &&
			   shape.getMinY() < player.getMinY();
	}

	@Override
	public Shape getShape() {
		return shape;
	}

	@Override
	public void render() {
		renderer.render(shape);
	}
}
