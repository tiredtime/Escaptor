package main;

import java.util.ArrayList;
import java.util.List;

//instead of using GameState as an outputArgument
public class CollisionImpact {
	public int deltaHealth = 100;
	public int deltaScore = 0;
	public List<GameObject> objectsToDelete = new ArrayList<GameObject>();
	public List<GameObject> gameObjectsToAdd = new ArrayList<GameObject>();
}
