package main;


import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {
	private GameUpdater updater;
	public static final int DEFAULT_FRAMERATE = 100;
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Game());
		app.setDisplayMode(800, 600, false);
		app.start();
	}
	
	public Game() throws SlickException {
		super("MouseEscape");
		/*Music openingMusic = new Music("res/music/Severed Personality - Abstract Anxiety.ogg");
		openingMusic.play();*/
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		if (gc.isPaused()){
			showEndGameScreen(gc, g);
		} else {
			renderGameScreen(gc);
		}
	}

	private void renderGameScreen(GameContainer gc) throws SlickException {
		GameState gs = updater.getGameState();
		for (GameObject o : gs.gameObjects){
			o.render();
		}
		gc.getGraphics().drawString("Health: " + gs.health + "; score: " + gs.score, 0, 0);
	}

	private void showEndGameScreen(GameContainer gc, Graphics g) throws SlickException {
		g.setColor(Color.black);
		g.drawString("Score: " + updater.getGameState().score, 350, 250);
		g.drawString("Left-click to try again.", 300, 300);
		if(gc.getInput().isMousePressed(0)){
			gc.reinit();
			gc.resume();
		}
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		gc.setShowFPS(false);
		gc.setUpdateOnlyWhenVisible(true);
		gc.setTargetFrameRate(DEFAULT_FRAMERATE);
		updater = new GameUpdater(gc);
		hideMouseCursor();
	}

	private void hideMouseCursor() {
		try {
			Cursor emptyCursor = new Cursor(1, 1, 0, 0, 1, BufferUtils.createIntBuffer(1), null);
			Mouse.setNativeCursor(emptyCursor);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		updater.update(delta);
	}
}