import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class FacePanel extends JPanel {
	
	Face face;
	
	public FacePanel(Face faceF) {
		
		setBackground(Color.BLACK);
		this.face = new Face(faceF);
		setSize(190, 190);
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		drawFace(g);
		
	}
	
	public void drawFace(Graphics g) {
		
		g.setColor(cubeColor(this.face.getStickers(0)));
		g.fillRect(10, 10, 50, 50);
		
		g.setColor(cubeColor(this.face.getStickers(1)));
		g.fillRect(70, 10, 50, 50);
		
		g.setColor(cubeColor(this.face.getStickers(2)));
		g.fillRect(130, 10, 50, 50);
		
		g.setColor(cubeColor(this.face.getStickers(3)));
		g.fillRect(10, 70, 50, 50);
		
		g.setColor(cubeColor(this.face.getStickers(4)));
		g.fillRect(70, 70, 50, 50);
		
		g.setColor(cubeColor(this.face.getStickers(5)));
		g.fillRect(130, 70, 50, 50);
		
		g.setColor(cubeColor(this.face.getStickers(6)));
		g.fillRect(10, 130, 50, 50);
		
		g.setColor(cubeColor(this.face.getStickers(7)));
		g.fillRect(70, 130, 50, 50);
		
		g.setColor(cubeColor(this.face.getStickers(8)));
		g.fillRect(130, 130, 50, 50);
		
	}
	
	public static Color cubeColor(String color) {
		
		switch (color) {
		
			case "w":
				return(Color.WHITE);
			
			case "y":
				return(Color.YELLOW);
		
			case "o":
				return(new Color(225, 92, 0));
			
			case "r":
				return(Color.RED);
		
			case "g":
				return(Color.GREEN);
			
			case "b":
				return(Color.BLUE);
	
		}
		
		return(Color.BLACK);
		
	}

}
