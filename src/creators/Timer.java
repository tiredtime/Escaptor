package creators;

public class Timer {
	private int interval;
	private int timeElapsed = 0;
	
	public Timer(int interval) {
		this.interval = interval;
	}

	public void update(int deltaTime) {
		timeElapsed += deltaTime;
	}

	public boolean isEnded() {
		return timeElapsed>=interval;
	}

	public void resetWithSurplusMaintained() {
		timeElapsed -= interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}
}
