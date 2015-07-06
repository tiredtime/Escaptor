package util;

import java.awt.Point;
import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Polygon;

public class CoordinateCreator extends BasicGame {
	Polygon polygon = new Polygon();
	ArrayList<Point> points = new ArrayList<Point>();
	public CoordinateCreator() {
		super("CoordinateCreator");
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new CoordinateCreator());
		app.setDisplayMode(800, 600, false);
		app.setTargetFrameRate(60);
		app.start();
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		drawTempPolygon(container, g);
		drawPolygon(g);
		drawPoints(g);
	}

	private void drawPoints(Graphics g) {
		g.setColor(Color.gray);
		for (Point p : points){
			Circle c = new Circle(p.x, p.y, 5);
			g.draw(c);
		}
	}

	private void drawPolygon(Graphics g) {
		g.setColor(Color.white);
		if (polygon.getPointCount() >=3){
			g.draw(polygon);
		}
	}

	private void drawTempPolygon(GameContainer container, Graphics g) {
		g.setColor(Color.yellow);
		if (polygon.getPointCount() >=2){
			Polygon tempPolygon = new Polygon(polygon.getPoints());
			int x = container.getInput().getMouseX();
			int y = container.getInput().getMouseY();
			tempPolygon.addPoint(x, y);
			g.draw(tempPolygon);
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		container.getGraphics().setColor(Color.white);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if(container.getInput().isMousePressed(0)){
			int x = container.getInput().getMouseX();
			int y = container.getInput().getMouseY();
			System.out.println(x + ", " + y + ", ");
			polygon.addPoint(x, y);
			points.add(new Point(x, y));
		}
	}
}
