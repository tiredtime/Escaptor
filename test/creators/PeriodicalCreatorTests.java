package creators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import main.GameObject;
import main.GameState;

import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.geom.Shape;

public class PeriodicalCreatorTests {
	PeriodicalCreator creator;
	
	@Before
	public void setUp() throws Exception {
		creator = new PeriodicalCreator(0, () -> new SampleGameObject());
	}
	
	@Test
	public void testZeroPeriodCreatesObjectEveryTime(){
		creator.setInterval(0);
		assertObjectReturned(1);
		assertObjectReturned(1);
	}
	
	@Test
	public void testReturnsObjectOnReachedInterval(){
		creator.setInterval(2);
		assertEmptyListReturned(1);
		assertObjectReturned(1);
	}
	
	@Test
	public void testIntervalRestets(){
		creator.setInterval(10);
		assertObjectReturned(10);
		assertEmptyListReturned(5);
	}
	
	@Test
	public void testSurplusDelta(){
		creator.setInterval(3);
		assertEmptyListReturned(2);
		assertObjectReturned(2);
		assertObjectReturned(2);
	}
	
	@Test
	public void testChangedInterval(){
		creator.setInterval(10);
		assertEmptyListReturned(9);
		creator.setInterval(15);
		assertEmptyListReturned(1);
		assertObjectReturned(5);
	}
	
	@Test
	public void testIntervalDecreasedLowerThanTimeElapsed(){
		creator.setInterval(10);
		assertEmptyListReturned(6);
		creator.setInterval(5);
		assertObjectReturned(1);
	}

	private void assertObjectReturned(int delta) {
		assertEquals(1, creator.createObjectIfTime(delta).size());
	}
	
	private void assertEmptyListReturned(int delta) {
		assertTrue(creator.createObjectIfTime(delta).isEmpty());
	}
	
	private class SampleGameObject implements GameObject {
		@Override
		public void render() {}

		@Override
		public void update(GameState gs) {}
		
		@Override
		public Shape getShape() {return null;}

		@Override
		public void collideWithPlayer(GameState gs) {}
	}
}
