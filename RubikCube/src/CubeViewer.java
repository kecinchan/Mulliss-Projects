import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CubeViewer {
	
	FacePanel faceF;
	FacePanel faceB;
	FacePanel faceU;
	FacePanel faceD;
	FacePanel faceL;
	FacePanel faceR;
	
	Cube cube;
	JFrame mainFrame;
	JLabel scramble;
	
	JPanel empty1;
	JPanel empty2;
	JPanel empty3;
	JPanel empty4;
	JPanel empty5;
	JPanel empty6;
	
	JPanel cubePanel;
	JPanel buttonPanel;
	
	JButton buttonF;
	JButton buttonB;
	JButton buttonU;
	JButton buttonD;
	JButton buttonL;
	JButton buttonR;
	JButton buttonFAnti;
	JButton buttonBAnti;
	JButton buttonUAnti;
	JButton buttonDAnti;
	JButton buttonLAnti;
	JButton buttonRAnti;
	ActionListener buttons;
		
	public CubeViewer() {
		
		this.cube = new Cube();
		//this.cube.scramble();
		
		//this.cube.printCube();
		
		this.faceF = new FacePanel(new Face(this.cube.getFace("f")));

		this.faceB = new FacePanel(new Face(this.cube.getFace("b")));
		this.faceU = new FacePanel(new Face(this.cube.getFace("u")));
		this.faceD = new FacePanel(new Face(this.cube.getFace("d")));
		this.faceL = new FacePanel(new Face(this.cube.getFace("l")));
		this.faceR = new FacePanel(new Face(this.cube.getFace("r")));
		
		this.mainFrame = new JFrame();
		
		this.scramble = new JLabel();
		this.scramble.setText(cube.scramble);
		
		this.empty1 = new JPanel();
		this.empty2 = new JPanel();
		this.empty3 = new JPanel();
		this.empty4 = new JPanel();
		this.empty5 = new JPanel();
		this.empty6 = new JPanel();
		
		this.cubePanel = new JPanel();
		this.buttonPanel = new JPanel();
		
		buttonF = new JButton("F");
		buttonB = new JButton("B");
		buttonU = new JButton("U");
		buttonD = new JButton("D");
		buttonL = new JButton("L");
		buttonR = new JButton("R");
		buttonFAnti = new JButton("F'");
		buttonBAnti = new JButton("B'");
		buttonUAnti = new JButton("U'");
		buttonDAnti = new JButton("D'");
		buttonLAnti = new JButton("L'");
		buttonRAnti = new JButton("R'");
		
	}
	
	public void loadGUI() {
		
		/*
		this.cubePanel.setLayout(new GridLayout(4,3));
		this.cubePanel.add(empty1);
		this.cubePanel.add(faceB);
		this.cubePanel.add(empty2);
		this.cubePanel.add(faceL);
		this.cubePanel.add(faceU);
		this.cubePanel.add(faceR);
		this.cubePanel.add(empty3);
		this.cubePanel.add(faceF);
		this.cubePanel.add(empty4);
		this.cubePanel.add(empty5);
		this.cubePanel.add(faceD);
		*/
				
		this.cubePanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 1;
		c.gridy = 0;
		c.ipadx = 180;
		c.ipady = 180;
		this.cubePanel.add(faceB, c);

		c.gridx = 0;
		c.gridy = 1;
		c.ipadx = 190;
		c.ipady = 180;
		this.cubePanel.add(faceL, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.ipadx = 180;
		c.ipady = 180;
		this.cubePanel.add(faceU, c);
		
		c.gridx = 2;
		c.gridy = 1;
		c.ipadx = 180;
		c.ipady = 180;
		this.cubePanel.add(faceR, c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.ipadx = 180;
		c.ipady = 180;
		this.cubePanel.add(faceF, c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.ipadx = 180;
		c.ipady = 180;
		this.cubePanel.add(faceD, c);
		
		this.buttonPanel.setLayout(new GridLayout(3,4));
		
		this.buttonPanel.add(buttonF);
		
		this.buttonPanel.add(buttonFAnti);
		this.buttonPanel.add(buttonB);
		this.buttonPanel.add(buttonBAnti);
		this.buttonPanel.add(buttonU);
		this.buttonPanel.add(buttonUAnti);
		this.buttonPanel.add(buttonD);
		this.buttonPanel.add(buttonDAnti);
		this.buttonPanel.add(buttonL);
		this.buttonPanel.add(buttonLAnti);
		this.buttonPanel.add(buttonR);
		this.buttonPanel.add(buttonRAnti);
		
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 0;
		c.ipady = 80;
		this.cubePanel.add(this.buttonPanel, c);
		
		this.mainFrame.add(this.cubePanel);
		
		//this.mainFrame.setSize(590, 800);
		this.mainFrame.pack();
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.mainFrame.setVisible(true);

		
	}	

}