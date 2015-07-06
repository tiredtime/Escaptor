package gameObjects;

import main.GameState;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

public class FallingTriangle extends GameObjectImpl {
	private GameContainer gc;
	private GameState gs2;
	private Polygon shape;
	
	public FallingTriangle(GameContainer gc, GameState gs){
		this.gs2 = gs;
		this.gc = gc;
		initShape();
	}
	
	public void initShape(){
		shape = new Polygon();
		shape.addPoint(0, 0);
		shape.addPoint(0+30, 10);
		shape.addPoint(0, 20);

		shape.setCenterX(gs2.player.getShape().getCenterX());
		shape.setCenterY(0);
	}
	
	@Override
	public void update(GameState gs) {
		shape.setY(shape.getY() + 1);
		Transform transform = Transform.createRotateTransform(0.01f,shape.getCenterX(), shape.getCenterY());
		shape = (Polygon) shape.transform(transform);
		if (shape.getMinY() >= gc.getScreenWidth()){
			gs.objectsToDelete.add(this);
		}
	}

	@Override
	public void collideWithPlayer(GameState gs) {
		Player p = gs2.player; 
		p.resize(10);
		gs.objectsToDelete.add(this);
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
