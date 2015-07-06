package creators;

import gameObjects.*;

import java.util.LinkedList;
import java.util.List;

import main.GameObject;
import main.GameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class GameObjectCreator {
	private List<GameObject> gameObjects;
	private GameContainer gc;
	private GameState gs;
	private List<PeriodicalCreator> periodicalCreators = new LinkedList<PeriodicalCreator>();

	public GameObjectCreator(GameContainer gc, GameState gs) throws SlickException{
		this.gc = gc;
		this.gs = gs;
		gs.player = new Player(gc);
		initGameObjects();
	}

	private void initGameObjects() throws SlickException {
		gameObjects = new LinkedList<GameObject>();
		//order of addition determines which object is visible if both occupy the same space
		gameObjects.add(new PointsCircle(gc));
		gameObjects.add(new Hospital());
		gameObjects.add(new BasketBall(gc, 20, 50));
		//gameObjects.add(new BasketBall(gc, 470, 500));
		//gameObjects.add(new BasketBall(gc, 100, 490));
		gameObjects.add(new SlowTimeBubble(gc));
		gameObjects.add(new FallingTriangle(gc, gs));
		gameObjects.add(gs.player);
		gs.gameObjects = gameObjects;
		addToGameObjectsPriodically(100000, () -> new BasketBall(gc));
		addToGameObjectsPriodically(1000, () -> new FallingTriangle(gc, gs));
		addToGameObjectsPriodically(1700, () -> new RainDrop(gc));
	}

	private void addToGameObjectsPriodically(int interval, Creator creator) {
		periodicalCreators.add(new PeriodicalCreator(interval, creator));
	}
	
	public void update(int delta) throws SlickException{
		List<GameObject> objectsToAdd = new LinkedList<GameObject>();
		for (PeriodicalCreator pc : periodicalCreators){
			objectsToAdd.addAll(pc.createObjectIfTime(delta));
		}
		gameObjects.addAll(objectsToAdd);
	}

	protected List<GameObject> getGameObjects() {
		return gameObjects;
	}
}
