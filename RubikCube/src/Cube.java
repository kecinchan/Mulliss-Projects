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
			
			placeHolder = new Face(this.faceR);
			this.faceR = new Face(this.faceF);
			placeHolder2 = new Face(this.faceB);
			this.faceB = new Face(placeHolder);
			placeHolder = new Face(this.faceL);
			this.faceL = new Face(placeHolder2);
			this.faceF = new Face(placeHolder);
			
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
		, this.faceB.getASticker(0), this.faceB.getASticker(1), this.faceB.getASticker(2), this.faceB.getASticker(3), this.faceB.getASticker(4), this.faceB.getASticker(5), this.faceB.getASticker(6), this.faceB.getASticker(7), this.faceB.getASticker(8), this.faceL.getASticker(0), this.faceL.getASticker(1), this.faceL.getASticker(2), this.faceU.getASticker(0), this.faceU.getASticker(1), this.faceU.getASticker(2), this.faceR.getASticker(0), this.faceR.getASticker(1), this.faceR.getASticker(2), this.faceL.getASticker(3), this.faceL.getASticker(4), this.faceL.getASticker(5), this.faceU.getASticker(3), this.faceU.getASticker(4), this.faceU.getASticker(5), this.faceR.getASticker(3), this.faceR.getASticker(4), this.faceR.getASticker(5), this.faceL.getASticker(6), this.faceL.getASticker(7), this.faceL.getASticker(8), this.faceU.getASticker(6), this.faceU.getASticker(7), this.faceU.getASticker(8), this.faceR.getASticker(6), this.faceR.getASticker(7), this.faceR.getASticker(8), this.faceF.getASticker(0), this.faceF.getASticker(1), this.faceF.getASticker(2), this.faceF.getASticker(3), this.faceF.getASticker(4), this.faceF.getASticker(5), this.faceF.getASticker(6), this.faceF.getASticker(7), this.faceF.getASticker(8), this.faceD.getASticker(0), this.faceD.getASticker(1), this.faceD.getASticker(2), this.faceD.getASticker(3), this.faceD.getASticker(4), this.faceD.getASticker(5), this.faceD.getASticker(6), this.faceD.getASticker(7), this.faceD.getASticker(8) );
		
	}
	
}
