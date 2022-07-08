package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;


public class TileManager {
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp){
		
		this.gp = gp;
		
		tile = new Tile[4];
		mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
		
		loadMap();
		getTileImage();
	}
	
	//CREATING FOR UTILITY TOOL CLASS
		
	public void setup(int index,String imagepath,boolean collision) {
		UtilityTool uTool=new UtilityTool();
		try {
			tile[index]=new Tile();
			//changed something in this line
			tile[index].image=ImageIO.read(getClass().getResourceAsStream( imagepath +".jpg"));
			tile[index].image=uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision=collision;
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap() {
		
		try {
			
			
			InputStream is = getClass().getResourceAsStream("map01.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
//			File file = new File("E:\\sam\\2-1\\CSE-234\\OOP Project\\res\\maps\\map01.txt");
//			BufferedReader br = new BufferedReader(new FileReader(file));
			
			
			int row = 0;
			int col = 0;
			
			while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
				
				String line = br.readLine();
//				System.out.println("Here?");
//				System.out.println(line);
				
				while(col < gp.maxScreenCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
//					System.out.print(num+" ");
					mapTileNum[col][row] = num;
					++col;
				}
				++row;
				col = 0;
//				System.out.println();
			}
			
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void getTileImage()	{
		
		try	{
			
		File directory = new File(" ");
		System.out.println(directory.getAbsolutePath());
			
//			setup(0,"black_tile",true);
//			setup(0,"black_tile",true);
//			setup(0,"brick",true);
//			setup(0,"ladder_black",false);
//			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("black_tile.jpg"));
			tile[0].collision = true;
//			tile[0].image = ImageIO.read(new File("./res/tiles/brick.jpg"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("black_tile.jpg"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("brick.jpg"));
			tile[2].collision = true;
			
			tile[3] = new Tile();
			//tile[3].image = ImageIO.read(getClass().getResourceAsStream("ladder_black.jpg"));
			
		}catch(IOException e)	{
		e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2)	{
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		
		while(row < gp.maxScreenRow) {
			while(col < gp.maxScreenCol) {
				
				int tileType = mapTileNum[col][row];
//				System.out.print(tileType+" ");

				g2.drawImage(tile[tileType].image, x, y, gp.tileSize, gp.tileSize, null);
				++col;
				x += gp.tileSize;
			}
			col = 0;
			x = 0;
			++row;
			y += gp.tileSize;
//			System.out.println();
		}
		
	}
	
	
}
