package thirdpartieslibrarytest;

import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.geom.Circle;
import static org.junit.Assert.*;

public class SlickCollisionDetection {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testCircleCircleIntersection() {
		Circle c = new Circle(5,5,10);
		assertTrue(c.intersects(c));
	}
}
