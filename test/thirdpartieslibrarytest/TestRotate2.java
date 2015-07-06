package thirdpartieslibrarytest;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Transform;

public class TestRotate2 extends BasicGame {

    public TestRotate2(String title) {
        super("woot");
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new TestRotate2("test"));
        app.setDisplayMode(800, 600, false);
        app.setTargetFrameRate(60);
        app.setSmoothDeltas(true);
        app.setMultiSample(2);
        app.start();
    }

    @Override
    public void render(GameContainer container, Graphics g)
            throws SlickException {
        g.setColor(Color.white);
        if (rect3.intersects(rect1) || rect3.intersects(rect2) || rect3.intersects(rect4)) {
            g.setColor(Color.red);
        }
        g.draw(rect3);

        g.setColor(Color.white);
        if (rect4.intersects(rect1) || rect4.intersects(rect2) || rect4.intersects(rect3)) {
            g.setColor(Color.red);
        }
        g.draw(rect4);

        g.setColor(Color.white);
        if (rect1.intersects(rect4) || rect1.intersects(rect2) || rect1.intersects(rect3)) {
            g.setColor(Color.red);
        }
        g.draw(rect1);

        g.setColor(Color.white);
        if (rect2.intersects(rect1) || rect2.intersects(rect3) || rect2.intersects(rect4)) {
            g.setColor(Color.red);
        }
        g.draw(rect2);
    }

    Polygon rect1, rect2, rect3, rect4;
    @Override
    public void init(GameContainer container) throws SlickException {
        rect1 = new Polygon(new float[]{0,0,100,0,100,100,0,100});
        rect1.setLocation(200, 200);

        rect2 = new Polygon(new float[]{0,0,100,0,100,100,0,100});
        rect2.setLocation(325,200);

        rect3 = new Polygon(new float[]{0,0,20,0,20,200,0,200});
        rect3.setLocation(325,265);

        rect4 = new Polygon(new float[]{0,0,20,0,20,200,0,200});
        rect4.setLocation(325,50);
    }

    @Override
    public void update(GameContainer container, int delta)
            throws SlickException {
        rect1 = (Polygon) rect1.transform(Transform.createRotateTransform(
                (float) Math.toRadians(-4), rect1.getCenterX(),
                rect1.getCenterY()));
        rect2 = (Polygon) rect2.transform(Transform.createRotateTransform(
                (float) Math.toRadians(-1), rect2.getCenterX(),
                rect2.getCenterY()));
        rect3 = (Polygon) rect3.transform(Transform.createRotateTransform(
                (float) Math.toRadians(3), rect3.getCenterX(),
                rect3.getCenterY()));
        rect4 = (Polygon) rect4.transform(Transform.createRotateTransform(
                (float) Math.toRadians(-3), 335, 125));
    }

}
