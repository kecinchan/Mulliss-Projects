import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CubeViewer implements ActionListener {
	
	FacePanel faceF;
	FacePanel faceB;
	FacePanel faceU;
	FacePanel faceD;
	FacePanel faceL;
	FacePanel faceR;
	
	Cube cube;
	JFrame mainFrame;
	
	JLabel scramble;
	JLabel solvePercentage;
	
	JPanel empty1;
	JPanel empty2;
	JPanel empty3;
	JPanel empty4;
	JPanel empty5;
	JPanel empty6;
	
	JPanel cubePanel;
	JPanel buttonPanel;
	JPanel buttonPanel2;
	
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
	JButton scrambleButton;
	JButton resetButton;
	JButton solveButton;
	
	ActionListener buttons;
		
	public CubeViewer() {
		
		this.cube = new Cube();
		
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
		
		this.solvePercentage = new JLabel();
		this.solvePercentage.setText("solve percent: " + this.cube.getSolvePercentage()*100);
		
		this.empty1 = new JPanel();
		this.empty2 = new JPanel();
		this.empty3 = new JPanel();
		this.empty4 = new JPanel();
		this.empty5 = new JPanel();
		this.empty6 = new JPanel();
		
		this.cubePanel = new JPanel();
		this.buttonPanel = new JPanel();
		this.buttonPanel2 = new JPanel();
		
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
		this.scrambleButton = new JButton("scramble");
		this.resetButton = new JButton("reset");
		this.solveButton = new JButton("test");
		
	}
	
	public void loadGUI() {
				
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
		
		this.buttonF.addActionListener(this);
		this.buttonF.setActionCommand("F");
		this.buttonFAnti.addActionListener(this);
		this.buttonFAnti.setActionCommand("F'");
		
		this.buttonB.addActionListener(this);
		this.buttonB.setActionCommand("B");
		this.buttonBAnti.addActionListener(this);
		this.buttonBAnti.setActionCommand("B'");
		
		this.buttonL.addActionListener(this);
		this.buttonL.setActionCommand("L");
		this.buttonLAnti.addActionListener(this);
		this.buttonLAnti.setActionCommand("L'");
		
		this.buttonR.addActionListener(this);
		this.buttonR.setActionCommand("R");
		this.buttonRAnti.addActionListener(this);
		this.buttonRAnti.setActionCommand("R'");
		
		this.buttonU.addActionListener(this);
		this.buttonU.setActionCommand("U");
		this.buttonUAnti.addActionListener(this);
		this.buttonUAnti.setActionCommand("U'");

		this.buttonD.addActionListener(this);
		this.buttonD.setActionCommand("D");
		this.buttonDAnti.addActionListener(this);
		this.buttonDAnti.setActionCommand("D'");
		
		this.scrambleButton.addActionListener(this);
		this.scrambleButton.setActionCommand("scramble");
		
		this.resetButton.addActionListener(this);
		this.resetButton.setActionCommand("reset");
		
		this.solveButton.addActionListener(this);
		this.solveButton.setActionCommand("solve");
		
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 0;
		c.ipady = 80;
		this.cubePanel.add(this.buttonPanel, c);
		
		c.gridx = 2;
		c.gridy = 0;
		this.cubePanel.add(this.buttonPanel2, c);
		
		this.buttonPanel2.setLayout(new BoxLayout(this.buttonPanel2, BoxLayout.PAGE_AXIS));
		this.buttonPanel2.add(this.scrambleButton);
		this.buttonPanel2.add(this.resetButton);
		this.buttonPanel2.add(this.solvePercentage);
		this.buttonPanel2.add(this.solveButton);
		
		c.gridx = 2;
		c.gridy = 0;
		this.cubePanel.add(this.buttonPanel2, c);
		
		
		this.mainFrame.add(this.cubePanel);
		
		//this.mainFrame.setSize(590, 800);
		this.mainFrame.pack();
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.mainFrame.setVisible(true);

	}
	
	public void scramble(String scramble, boolean animate) {
		
		int multiplier = 1;
		this.cube.scramble = scramble;
		
		String move = "";
		String shift = "";
		
		for (int i = 0; i < scramble.length(); i++) {
			
			move = scramble.substring(i, i+1);
			
			if (i != scramble.length() - 1) {
				
				shift = scramble.substring(i+1, i+2);
				
				if (shift.equals("'")) {
					
					move += "'";
					
				} else if (shift.equals("2")) {
					
					multiplier = 2;
					i++;
					
				}
				
				shift = "";
				
			}
			
			for (int j = 1; j <= multiplier; j++ ) {
			
				if (animate) {
					
					try {
						
						Thread.sleep(100);
						
					} catch (InterruptedException e) {}
					
				}
				
				this.doMove(move);
				this.redraw();
				
			}
			
			move = "";
			multiplier = 1;
			
		}
		
	}
	
	public void scramble(int turns) {
		
		this.scramble(turns, false);
		
	}
	
	public void scramble(int turns, boolean animate) {
		
		String[] moves = new String[]{"F", "B", "U", "D", "L", "R", "F'", "B'", "U'", "D'", "R'", "L'"};
		
		String move;
		String disallowedMove = "P";
		
		Random rand = new Random();
		
		for (int i = 1; i <= turns; i++) {
			
			do {
				
				move = moves[rand.nextInt(12)];
				
			} while (move.equals(disallowedMove));
			

			
			this.doMove(move);
			this.redraw();
			
			if (animate) {
				
				try {Thread.sleep(100);} catch (InterruptedException e) {}
				
			}
			
			this.cube.scramble += move;
			
			if (move.length() == 1) {
				
				disallowedMove = move + "'";
				
			} else {
				
				disallowedMove = move.substring(0, 1);
				
			}
			
		}
		
	}
	
	public void scramble() {
		
		this.scramble(20, false);
		
	}
	
	public void scramble(boolean animate) {
		
		this.scramble(20, animate);
		
	}
	
	public void doMove(String move) {
		
		boolean anti = false;
		
		if (move.length() == 2) {
			
			anti = true;
			move = move.substring(0, 1);
			
		}
		
		switch (move) {
		
		case "U": 
			
			this.cube.up(anti);
			break;
		
		case "D": 
							
			this.cube.down(anti);	
			break;
		
		case "F": 
			
			this.cube.front(anti);
			break;
		
		case "B": 
			
			this.cube.back(anti);
			break;
		
		case "L": 
			
			this.cube.left(anti);			
			break;
		
		case "R": 
			
			this.cube.right(anti);
			break;
			
		case "scramble":
			this.scramble(true);
			break;
			
		case "reset":
			this.cube = new Cube();
			break;
			
		case "solve":
			this.cube.doAlgorithm("UUU'");
	
		}
		
	}

	
	public void redraw() {
		
		this.faceF.face.setStickers(this.cube.getFace("f").getStickers());
		this.faceB.face.setStickers(this.cube.getFace("b").getStickers());
		this.faceL.face.setStickers(this.cube.getFace("l").getStickers());
		this.faceR.face.setStickers(this.cube.getFace("r").getStickers());
		this.faceU.face.setStickers(this.cube.getFace("u").getStickers());
		this.faceD.face.setStickers(this.cube.getFace("d").getStickers());
		this.solvePercentage.setText("solve percent: " + Math.floor(this.cube.getSolvePercentage()*100));
		//this.faceF.paintImmediately(this.faceF.getBounds());
		//this.mainFrame.repaint();
		
		this.mainFrame.repaint(0);
		  
	}
		


	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.doMove(e.getActionCommand());
		this.redraw();
		
	}	

}