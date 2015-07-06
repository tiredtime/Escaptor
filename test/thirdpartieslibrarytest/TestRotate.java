package thirdpartieslibrarytest;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Transform;

public class TestRotate extends BasicGame {
	Polygon rect1;

	public TestRotate(String title) {
		super("TestRotate");
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new TestRotate("test"));
		app.setDisplayMode(800, 600, false);
		app.setTargetFrameRate(60);
		app.start();
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		g.setColor(Color.white);
		g.draw(rect1);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		rect1 = new Polygon(new float[] { 0, 0, 100, 0, 100, 100, 0, 100 });
		rect1.setLocation(200, 200);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		float angle = (float) Math.toRadians(-4);
		Transform trasformation = Transform.createRotateTransform(angle, rect1.getCenterX(), rect1.getCenterY());
		rect1 = (Polygon) rect1.transform(trasformation);
	}

}
