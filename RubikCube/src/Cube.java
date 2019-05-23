public class Cube {

	private Face faceF;
	private Face faceB;
	private Face faceU;
	private Face faceD;
	private Face faceR;
	private Face faceL;
	
	boolean isSolved;
	String frontFace;
	
	public Cube(Face inputFace1, Face inputFace2, Face inputFace3, Face inputFace4, Face inputFace5, Face inputFace6) {
		
		this.faceF = inputFace1;
		this.faceB = inputFace2;
		this.faceU = inputFace3;
		this.faceD = inputFace4;
		this.faceR = inputFace5;
		this.faceL = inputFace6;
		
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
		
		Face placeHolder;
		Face placeHolder2;
		
		if (anti) {
			
			placeHolder = new Face(this.faceF);
			this.faceF = new Face(this.faceL);
			this.faceL = new Face(this.faceB);
			this.faceB = new Face(this.faceR);
			this.faceR = new Face(placeHolder);
			
		} else {
		
			// put front into a placeholder
			placeHolder = new Face(this.faceF);
			// make front into right
			this.faceF = new Face(this.faceR);
		
			placeHolder2 = new Face(this.faceB);
			this.faceB = new Face(this.faceL);
			this.faceL = new Face(placeHolder);
			this.faceR = new Face(placeHolder2);
		
		}
		
	}
	
	public void rotateZ(boolean anti) {
		
		Face placeHolder;
		Face placeHolder2;
		
		if (anti) {
		
			placeHolder = new Face(this.faceL);
			this.faceL = new Face(this.faceU);
			placeHolder2 = new Face(this.faceD);
			this.faceD = new Face(placeHolder);
			placeHolder = new Face(faceR);
			this.faceR = new Face(placeHolder2);
			this.faceU = new Face(placeHolder);
			
			
		} else {
			
			placeHolder = new Face(this.faceR);
			this.faceR = new Face(this.faceU);
			placeHolder2 = new Face(this.faceD);
			this.faceD = new Face(placeHolder);
			placeHolder = new Face(this.faceL);
			this.faceL = new Face(placeHolder2);
			this.faceU = new Face(placeHolder);
			
			
		}
		
	}
	
	public void rotateX(boolean anti) {
		
		Face placeHolder;
		Face placeHolder2;
		
		
		if (anti) {
			
			placeHolder = new Face(this.faceF);
			this.faceF = new Face(this.faceD);
			this.faceD = new Face(this.faceB);
			this.faceB = new Face(this.faceU);
			this.faceU = new Face(placeHolder);
			
		} else {
			
			placeHolder = new Face(this.faceF);
			this.faceF = new Face(this.faceU);
			placeHolder2 = new Face(this.faceD);
			this.faceD = new Face(placeHolder);
			placeHolder = new Face(this.faceB);
			this.faceB = new Face(placeHolder2);
			this.faceU = new Face(placeHolder);
		}
		
	}
	
	public void front(boolean anti) {
		
		String[] placeHolder = new String[3];
		
		if (anti) {
			
			placeHolder[0] = this.faceL.getStickers(6);
			placeHolder[1] = this.faceL.getStickers(7);
			placeHolder[2] = this.faceL.getStickers(8);
			
			this.faceL.setStickers(6, this.faceU.getStickers(6));
			this.faceL.setStickers(7, this.faceU.getStickers(7));
			this.faceL.setStickers(8, this.faceU.getStickers(8));
			
			this.faceU.setStickers(6, this.faceR.getStickers(6));
			this.faceU.setStickers(7, this.faceR.getStickers(7));
			this.faceU.setStickers(8, this.faceR.getStickers(8));
			
			this.faceR.setStickers(6, this.faceD.getStickers(2));
			this.faceR.setStickers(7, this.faceD.getStickers(1));
			this.faceR.setStickers(8, this.faceD.getStickers(0));
			
			this.faceD.setStickers(2, placeHolder[0]);
			this.faceD.setStickers(1, placeHolder[1]);			
			this.faceD.setStickers(0, placeHolder[2]);
			
		} else {
			
			placeHolder[0] = this.faceR.getStickers(6);
			placeHolder[1] = this.faceR.getStickers(7);
			placeHolder[2] = this.faceR.getStickers(8);
			
			this.faceR.setStickers(6, this.faceU.getStickers(6));
			this.faceR.setStickers(7, this.faceU.getStickers(7));
			this.faceR.setStickers(8, this.faceU.getStickers(8));
			
			this.faceU.setStickers(6, this.faceL.getStickers(6));
			this.faceU.setStickers(7, this.faceL.getStickers(7));
			this.faceU.setStickers(8, this.faceL.getStickers(8));
			
			this.faceL.setStickers(6, this.faceD.getStickers(2));
			this.faceL.setStickers(7, this.faceD.getStickers(1));
			this.faceL.setStickers(8, this.faceD.getStickers(0));
			
			this.faceD.setStickers(2, placeHolder[0]);
			this.faceD.setStickers(1, placeHolder[1]);			
			this.faceD.setStickers(0, placeHolder[2]);
			
		}
		
	}
	
	public void right(boolean anti) {
		
		if (anti) {
			
			
			
		} else {
			
			this.rotateY(false);
			this.front(false);
			this.rotateY(true);
			
		}		
		
	}
	
	public void printCube() {
		
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
