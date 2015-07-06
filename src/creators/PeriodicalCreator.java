package creators;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import main.GameObject;

public class PeriodicalCreator {
	private Timer timer;
	private Creator creator;
	
	public PeriodicalCreator(int interval, Creator creator) {
		timer = new Timer(interval);
		this.creator = creator;
	}
	
	public List<GameObject> createObjectIfTime(int deltaTime){
		timer.update(deltaTime);
		if (timer.isEnded()){
			timer.resetWithSurplusMaintained();
			return createListWithNewObject();
		} 
		return Collections.emptyList();
	}
	
	private List<GameObject> createListWithNewObject(){
		List<GameObject> objectsToAdd = new LinkedList<GameObject>();
		objectsToAdd.add(creator.createObject());
		return objectsToAdd;
	}

	public void setInterval(int interval) {
		timer.setInterval(interval);
	}
}
