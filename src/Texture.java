import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Texture {
	public static Texture wood = new Texture("res/wood.png", 64);
	public static Texture wood_stone = new Texture("res/wood_stone.png", 64);
	public static Texture blue = new Texture("res/blue.png", 64);
	public int[] pixels;
	private String loc;
	public final int SIZE;
	public ArrayList<Texture> textures;
	
	
	
	public Texture(String location, int size) {
		textures = new ArrayList<Texture>();
		textures.add(Texture.wood);
		textures.add(Texture.blue);
		textures.add(Texture.wood_stone);
		loc = location;
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	private void load() {
		try {
			BufferedImage image = ImageIO.read(new File(loc));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
