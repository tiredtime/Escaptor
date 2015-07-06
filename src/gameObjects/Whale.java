package gameObjects;

import main.GameState;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;

public class Whale extends GameObjectImpl {
	private GameContainer gc;
	private Polygon shape;
	
	public Whale(GameContainer gc, GameState gs){
		this.gc = gc;
		initShape();
	}
	
	public void initShape(){
		shape = new Polygon(new float[] {102, 102, 159, 149, 240, 186, 301,
				195, 369, 200, 419, 203, 454, 202, 509, 206, 547, 218, 580,
				238, 604, 268, 616, 288, 626, 325, 631, 349, 625, 368, 615,
				384, 600, 398, 580, 412, 559, 419, 530, 427, 497, 431, 483,
				431, 444, 421, 416, 411, 386, 400, 372, 388, 323, 359, 287,
				340, 251, 313, 226, 297, 203, 273, 187, 258, 159, 233, 123,
				201, 99, 189, 77, 193, 64, 200, 40, 207, 16, 209, 34, 187, 63,
				169, 74, 168, 88, 168, 97, 168, 87, 149, 78, 137, 68, 121, 60,
				107, 59, 91, 59, 76, 62, 44, 64, 28 });

		//shape.setCenterX(gs2.player.getShape().getCenterX());
		//shape.setCenterY(0);
	}
	
	@Override
	public void update(GameState gs){

	}

	@Override
	public void collideWithPlayer(GameState gs){

	}

	@Override
	public void render() {
		gc.getGraphics().setColor(Color.pink);
		gc.getGraphics().fill(getShape());
	}

	@Override
	public Shape getShape() {
		return shape;
	}
}
