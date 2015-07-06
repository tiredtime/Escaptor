package main;

import gameObjects.Player;

import java.util.ArrayList;
import java.util.List;

//Object that is modified by many other objects, sometimes as an output argument.
//Did not find a better way to do it :(
public class GameState {
	public int health = 100;
	public int score = 0;
	public List<GameObject> objectsToDelete = new ArrayList<GameObject>();
	public List<GameObject> gameObjects = new ArrayList<GameObject>();
	public Player player;
	public int deltaTime;
}
