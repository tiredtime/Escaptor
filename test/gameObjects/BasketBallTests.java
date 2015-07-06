package gameObjects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import main.GameObject;
import main.GameState;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BasketBallTests {
	/*private GameContainer gc = mock(GameContainer.class);
	private GameState gs = mock(GameState.class);
	private BasketBall ball;
	
	@Before
	public void setUp() throws Exception {
		when(gc.getWidth()).thenReturn(200);
		when(gc.getHeight()).thenReturn(200);
		Mockito.when(new Image(Mockito.anyString())).thenReturn(null);
		ball = new BasketBall(gc, 100, 100);
	}

	@Test
	public void canMove() throws SlickException {
		updateMany(ball, 5);
		assertEquals(100 + 5 * BasketBall.SPEED, ball.shape.getLocation().x, 0.001);
		assertEquals(100 + 5 * BasketBall.SPEED, ball.shape.getLocation().y, 0.001);
	}
	
	@Test
	public void bouncesAtTheRightTime() throws SlickException {
		updateMany(ball, 80);
		assertEquals(1, ball.dx);
		assertEquals(1, ball.dy);
		updateMany(ball, 1);
		assertEquals(-1, ball.dx);
		assertEquals(-1, ball.dy);
	}
	
	private void updateMany(GameObject o, int times) throws SlickException{
		for (int i = 1; i <= times; i++){
			o.update(gs);
		}
	}*/

}
