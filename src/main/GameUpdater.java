package main;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import creators.GameObjectCreator;

public class GameUpdater {
	private GameState gs = new GameState();
	private GameContainer gc;
	private GameObjectCreator objectCreator;

	public GameUpdater(GameContainer gc) throws SlickException{
		this.gc = gc;
		objectCreator = new GameObjectCreator(gc, gs);
	}
	
	public void update(int delta) throws SlickException {
		if (!gc.isPaused()) {
			objectCreator.update(delta);
			update();
			deleteGameObjects();
			checkIfGameIsOver();
		}
	}

	private void deleteGameObjects() {
		for (GameObject o : gs.objectsToDelete){
			gs.gameObjects.remove(o);
		}
		gs.objectsToDelete.clear();
	}

	private void checkIfGameIsOver() {
		if (gs.health <= 0) {
			gc.pause();
		}
	}

	private void update() throws SlickException {
		int initialHealth = gs.health;
		int initialScore = gs.score;
		for (GameObject o : gs.gameObjects) {
			o.update(gs);
		}
		int deltaHealth = gs.health - initialHealth;
		int deltaScore = gs.score - initialScore;
		setBackground(deltaHealth, deltaScore);
	}

	private void setBackground(int deltaHealth, int deltaScore) {
		if (deltaHealth < 0) {
			gc.getGraphics().setBackground(Color.red);
		} else if (deltaScore < 0) {
			gc.getGraphics().setBackground(Color.blue);
		}
		else {
			gc.getGraphics().setBackground(Color.black);
		}
	}

	protected GameState getGameState() {
		return gs;
	}

}
