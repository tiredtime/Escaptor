package graphics;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class MoverTests {
	Mover mover;
	
	@Before
	public void setUp() throws Exception {
		GameContainer gcMock = mock(GameContainer.class);
		when(gcMock.getHeight()).thenReturn(100);
		when(gcMock.getWidth()).thenReturn(200);
		Shape shape = new Circle(5,10,25);
		mover = new Mover(shape, gcMock);
	}

	@Test
	public void test() {
		mover.move();
	}

}
