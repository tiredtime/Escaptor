package creators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TimerTests {
	Timer timer;
	
	@Before
	public void setUp() throws Exception {
		timer = new Timer(10);
	}
	
	@Test
	public void testDoesNotEndPrematurely(){
		timer.update(5);
		assertFalse(timer.isEnded());
	}
	
	@Test
	public void testCanEnd(){
		timer.update(10);
		assertTrue(timer.isEnded());
	}
	
	@Test
	public void testCanReset(){
		timer.update(15);
		timer.resetWithSurplusMaintained();
		assertFalse(timer.isEnded());
	}
	
	@Test
	public void testResetMaintainsSurplus(){
		timer.update(17);
		timer.resetWithSurplusMaintained();
		timer.update(6);
		assertTrue(timer.isEnded());
	}
	
	@Test
	public void testChangedInterval(){
		timer.update(9);
		timer.setInterval(15);
		timer.update(2);
		assertFalse(timer.isEnded());
	}
	
	@Test
	public void testIntervalDecreasedLowerThanTimeElapsed(){
		timer.update(9);
		timer.setInterval(5);
		assertTrue(timer.isEnded());
	}
}
