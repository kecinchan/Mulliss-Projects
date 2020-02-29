import java.util.Random;

public class Cube {

	private Face faceF;
	private Face faceB;
	private Face faceU;
	private Face faceD;
	private Face faceR;
	private Face faceL;
	
	private boolean isSolved;
	
	private double solvePercentage;
	
	private String frontFace;
	public String scramble;
	
	public Cube() {
		
		this.faceF = new Face("green");
		this.faceB = new Face("blue");
		this.faceU = new Face("white");
		this.faceD = new Face("yellow");
		this.faceR = new Face("red");
		this.faceL = new Face("ornage");
		
		scramble = "";
		solvePercentage = 1.0;
		
	}
	
	public Cube(Face inputFaceF, Face inputFaceB, Face inputFaceU, Face inputFaceD, Face inputFaceR, Face inputFaceL) {
		
		this.faceF = inputFaceF;
		this.faceB = inputFaceB;
		this.faceU = inputFaceU;
		this.faceD = inputFaceD;
		this.faceR = inputFaceR;
		this.faceL = inputFaceL;
		
		scramble = "";		
		
	}
	
	public double getSolvePercentage() {
		
		return this.solvePercentage;
		
	}
	
	public void setFace(String face, Face inputFace) {
		
		switch(face) {
		
			case "f":
				this.faceF = inputFace;
				break;
			
			case "b":
				this.faceB = inputFace;
				break;
			
			case "u":
				this.faceU = inputFace;
				break;
				
			case "d":
				this.faceD = inputFace;
				break;
				
			case "r":
				this.faceR = inputFace;
				break;
				
			case "l":
				this.faceL = inputFace;
				break;
		
		}
				
	}
	
	public Face getFace(String face) {
		
		switch(face) {
		
			case "f":
				return this.faceF;
		
			case "b":
				return this.faceB;
		
			case "u":
				return this.faceU;
			
			case "d":
				return this.faceD;
			
			case "r":
				return this.faceR;
			
			case "l":
				return this.faceL;
	
		}
		
		return null;
		
	}
	
	public void rotateY(boolean anti) {
		
		Face placeholder;
		Face placeholder2;
		
		if (anti) {
			
			placeholder = new Face(this.faceF);
			this.faceF = new Face(this.faceL);
			this.faceL = new Face(this.faceB);
			this.faceB = new Face(this.faceR);
			this.faceR = new Face(placeholder);
			
			this.faceL.rotate(true);
			this.faceB.rotate(true);
			this.faceR.rotate(true);
			this.faceF.rotate(true);
			this.faceU.rotate(true);
			this.faceD.rotate(false);
			
		} else {
		
			// put front into a placeholder
			placeholder = new Face(this.faceF);
			// make front into right
			this.faceF = new Face(this.faceR);
		
			placeholder2 = new Face(this.faceB);
			this.faceB = new Face(this.faceL);
			this.faceL = new Face(placeholder);
			this.faceR = new Face(placeholder2);
			
			this.faceL.rotate(false);
			this.faceB.rotate(false);
			this.faceR.rotate(false);
			this.faceF.rotate(false);
			this.faceU.rotate(false);
			this.faceD.rotate(true);
			
		}
		
	}
	
	public void rotateZ(boolean anti) {
		
		Face placeholder;
		Face placeholder2;
		
		if (anti) {
		
			placeholder = new Face(this.faceL);
			this.faceL = new Face(this.faceU);
			placeholder2 = new Face(this.faceD);
			this.faceD = new Face(placeholder);
			placeholder = new Face(faceR);
			this.faceR = new Face(placeholder2);
			this.faceU = new Face(placeholder);
			
			
		} else {
			
			placeholder = new Face(this.faceR);
			this.faceR = new Face(this.faceU);
			placeholder2 = new Face(this.faceD);
			this.faceD = new Face(placeholder);
			placeholder = new Face(this.faceL);
			this.faceL = new Face(placeholder2);
			this.faceU = new Face(placeholder);
						
			
		}
		
	}
	
	public void rotateX(boolean anti) {
		
		Face placeholder;
		Face placeholder2;
		
		
		if (anti) {
			
			placeholder = new Face(this.faceF);
			this.faceF = new Face(this.faceD);
			this.faceD = new Face(this.faceB);
			this.faceB = new Face(this.faceU);
			this.faceU = new Face(placeholder);
			
			this.faceL.rotate(true);
			this.faceR.rotate(false);
			
		} else {
			
			placeholder = new Face(this.faceF);
			this.faceF = new Face(this.faceU);
			placeholder2 = new Face(this.faceD);
			this.faceD = new Face(placeholder);
			placeholder = new Face(this.faceB);
			this.faceB = new Face(placeholder2);
			this.faceU = new Face(placeholder);
			
			this.faceL.rotate(false);
			this.faceR.rotate(true);
			
		}
		
	}
	
	public void front(boolean anti) {
		
		String[] placeholder = new String[3];
		
		if (anti) {
			
			placeholder[0] = this.faceL.getStickers(6);
			placeholder[1] = this.faceL.getStickers(7);
			placeholder[2] = this.faceL.getStickers(8);
			
			this.faceL.setStickers(6, this.faceU.getStickers(6));
			this.faceL.setStickers(7, this.faceU.getStickers(7));
			this.faceL.setStickers(8, this.faceU.getStickers(8));
			
			this.faceU.setStickers(6, this.faceR.getStickers(6));
			this.faceU.setStickers(7, this.faceR.getStickers(7));
			this.faceU.setStickers(8, this.faceR.getStickers(8));
			
			this.faceR.setStickers(6, this.faceD.getStickers(2));
			this.faceR.setStickers(7, this.faceD.getStickers(1));
			this.faceR.setStickers(8, this.faceD.getStickers(0));
			
			this.faceD.setStickers(2, placeholder[0]);
			this.faceD.setStickers(1, placeholder[1]);			
			this.faceD.setStickers(0, placeholder[2]);
			
			this.faceF.rotate(true);
			
		} else {
			
			placeholder[0] = this.faceR.getStickers(6);
			placeholder[1] = this.faceR.getStickers(7);
			placeholder[2] = this.faceR.getStickers(8);
			
			this.faceR.setStickers(6, this.faceU.getStickers(6));
			this.faceR.setStickers(7, this.faceU.getStickers(7));
			this.faceR.setStickers(8, this.faceU.getStickers(8));
			
			this.faceU.setStickers(6, this.faceL.getStickers(6));
			this.faceU.setStickers(7, this.faceL.getStickers(7));
			this.faceU.setStickers(8, this.faceL.getStickers(8));
			
			this.faceL.setStickers(6, this.faceD.getStickers(2));
			this.faceL.setStickers(7, this.faceD.getStickers(1));
			this.faceL.setStickers(8, this.faceD.getStickers(0));
			
			this.faceD.setStickers(2, placeholder[0]);
			this.faceD.setStickers(1, placeholder[1]);			
			this.faceD.setStickers(0, placeholder[2]);
		
			this.faceF.rotate(false);
			
		}
		
		this.updateSolvePercentage();		
		
	}
	
	public void right(boolean anti) {
		
		this.rotateY(false);
		this.front(anti);
		this.rotateY(true);	
		
	}
	
	public void left(boolean anti) {
		
		this.rotateY(true);
		this.front(anti);
		this.rotateY(false);	
		
	}
	
	public void up(boolean anti) {
		
		this.rotateX(false);
		this.front(anti);
		this.rotateX(true);
		
	}
	
	public void down(boolean anti) {
		
		this.rotateX(true);
		this.front(anti);
		this.rotateX(false);
		
	}
	
	public void back(boolean anti) {
		
		this.rotateY(false);
		this.rotateY(false);
		this.front(anti);
		this.rotateY(true);
		this.rotateY(true);
		
	}
	
	public void scramble(String scramble) {
		
		int multiplier = 1;
		this.scramble = scramble;
		
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
			
				this.doMove(move);
			
			}
			
			move = "";
			multiplier = 1;
			
		}
		
	}
	
	public void scramble(int turns) {
		
		String[] moves = new String[]{"F", "B", "U", "D", "L", "R", "F'", "B'", "U'", "D'", "R'", "L'"};
		
		String move;
		String disallowedMove = "P";
		
		Random rand = new Random();
		
		for (int i = 1; i <= turns; i++) {
			
			do {
				
				move = moves[rand.nextInt(12)];
				
			} while (move.equals(disallowedMove));
			
			this.doMove(move);
			this.scramble += move;
			
			if (move.length() == 1) {
				
				disallowedMove = move + "'";
				
			} else {
				
				disallowedMove = move.substring(0, 1);
				
			}
			
		}
		
	}
	
	public void scramble() {
		
		this.scramble(20);
		
	}
	
	public void doAlgorithm(String algorithm) {
		
		String move;
		
		for (int i = 0; i < algorithm.length(); i++) {
			
			move = algorithm.substring(i, i+1);
			
			if (i != (algorithm.length() - 1) && algorithm.substring(i+1, i+2).equals("'")) {
				
				move += "'";
				i++;
				
			}
			
			doMove(move);
			
		}
		
	}
	
	public void doMove(String move) {
		
		boolean anti = false;
		
		if (move.length() == 2) {
			
			anti = true;
			move = move.substring(0, 1);
			
		}
		
		switch (move) {
		
		case "U": 
			
			this.up(anti);
			break;
		
		case "D": 
							
			this.down(anti);	
			break;
		
		case "F": 
			
			this.front(anti);
			break;
		
		case "B": 
			
			this.back(anti);
			break;
		
		case "L": 
			
			this.left(anti);			
			break;
		
		case "R": 
			
			this.right(anti);
			break;
			
		case "X":
			
			this.rotateX(anti);
			break;
			
		case "Y":
			
			this.rotateY(anti);
			break;
			
		case "Z":
			
			this.rotateZ(anti);
			break;
	
		}
		
	}
	
	public void updateSolvePercentage() {
		
		this.solvePercentage = (this.faceF.correctAmount() + this.faceB.correctAmount() +this.faceU.correctAmount() +this.faceD.correctAmount() +this.faceL.correctAmount() +this.faceR.correctAmount()) / 54.0;
		
	}
	
	
	public void printCube() {
		
		System.out.println("Scramble: " + this.scramble);
		System.out.printf("    -----\n"
				+         "    |%s%s%s|\n"
				+ 		  "    |%s%s%s|\n"
				+  		  "    |%s%s%s|\n"
				+ 		  "----|---|----\n"
				+         "|%s%s%s|%s%s%s|%s%s%s|\n"
				+ 		  "|%s%s%s|%s%s%s|%s%s%s|\n"
				+  		  "|%s%s%s|%s%s%s|%s%s%s|\n"
				+ 		  "    |---|\n"
				+ 		  "    |%s%s%s|\n"
				+ 		  "    |%s%s%s|\n"
				+ 		  "    |%s%s%s|\n"
				+ 		  "    -----\n"
				+ 		  "    |%s%s%s|\n"
				+ 		  "    |%s%s%s|\n"
				+ 		  "    |%s%s%s|\n"
				+ 		  "    -----\n"
		, this.faceB.getStickers(0), this.faceB.getStickers(1), this.faceB.getStickers(2), this.faceB.getStickers(3), this.faceB.getStickers(4), this.faceB.getStickers(5), this.faceB.getStickers(6), this.faceB.getStickers(7), this.faceB.getStickers(8), this.faceL.getStickers(0), this.faceL.getStickers(1), this.faceL.getStickers(2), this.faceU.getStickers(0), this.faceU.getStickers(1), this.faceU.getStickers(2), this.faceR.getStickers(0), this.faceR.getStickers(1), this.faceR.getStickers(2), this.faceL.getStickers(3), this.faceL.getStickers(4), this.faceL.getStickers(5), this.faceU.getStickers(3), this.faceU.getStickers(4), this.faceU.getStickers(5), this.faceR.getStickers(3), this.faceR.getStickers(4), this.faceR.getStickers(5), this.faceL.getStickers(6), this.faceL.getStickers(7), this.faceL.getStickers(8), this.faceU.getStickers(6), this.faceU.getStickers(7), this.faceU.getStickers(8), this.faceR.getStickers(6), this.faceR.getStickers(7), this.faceR.getStickers(8), this.faceF.getStickers(0), this.faceF.getStickers(1), this.faceF.getStickers(2), this.faceF.getStickers(3), this.faceF.getStickers(4), this.faceF.getStickers(5), this.faceF.getStickers(6), this.faceF.getStickers(7), this.faceF.getStickers(8), this.faceD.getStickers(0), this.faceD.getStickers(1), this.faceD.getStickers(2), this.faceD.getStickers(3), this.faceD.getStickers(4), this.faceD.getStickers(5), this.faceD.getStickers(6), this.faceD.getStickers(7), this.faceD.getStickers(8) );
		
	}
	
}
