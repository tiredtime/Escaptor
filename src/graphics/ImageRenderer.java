package graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public class ImageRenderer {
	private Image img;
	private Image originalImg;
	private int width;
	private int height;
	
	public ImageRenderer(String imageUrl, Shape shape) {
		try {
			String url = imageUrl;
			originalImg = new Image(url);
			resizeImg(shape);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void render(Shape shape) {
		Vector2f location = shape.getLocation();
		img.draw(location.x, location.y);
	}
	
	public void resizeImg(Shape shape){
		width = (int) shape.getWidth();
		height = (int) shape.getHeight();
		img = originalImg.getScaledCopy(width, height);
	}
}
