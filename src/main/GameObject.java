package main;


import org.newdawn.slick.geom.Shape;

public interface GameObject {
	public void render();
	public void update(GameState gs);
	public Shape getShape();
	public void collideWithPlayer(GameState gs);
}
