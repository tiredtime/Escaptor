package gameObjects;

import main.CollisionImpact;
import main.GameObject;
import main.GameState;

public abstract class GameObjectImpl implements GameObject {
	public GameObjectImpl(){
		
	}
	
	@Override
	public void render()  {
	}

	@Override
	public void update(GameState gs) {
		//avoids empty implementations calls in children
	}

	@Override
	public void collideWithPlayer(GameState gs) {
	}

}
