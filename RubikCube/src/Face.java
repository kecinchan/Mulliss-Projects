public class Face {

	private String[] stickers;
	private final String side;

	public Face(String inputSide) {
		
		this.side = inputSide;
		stickers = new String[9];
		
		for (int i = 0; i < 9; i++) {
			
			stickers[i] = this.side.substring(0, 1);
			
		}
		
	}
	
	public Face(Face inputFace) {
		
		this.side = inputFace.getSide();
		this.stickers = new String[9];
		
		for (int i = 0; i < 9; i++) {
			
			this.stickers[i] = inputFace.getStickers(i);
			
		}
		
	}
	
	public String getSide() {
		
		return this.side;
		
	}
	
	public String[] getStickers() {
		
		return this.stickers;
		
	}
	
	public String getStickers(int index) {
		
		return this.stickers[index];
		
	}
	
	public void setStickers(String[] inputStickers) {
		
		for (int i = 0; i < 9; i++) {
			
			this.stickers[i] = inputStickers[i];
			
		}
		
	}
	
	public void setStickers(int index, String color) {
		
		this.stickers[index] = color;
		
	}
	
	public void rotate(boolean anti) {
		
		String placeHolder = "";
		
		if (anti) {
			
			placeHolder = this.stickers[6];
			this.stickers[6] = this.stickers[0];
			this.stickers[0] = this.stickers[2];
			this.stickers[2] = this.stickers[8];
			this.stickers[8] = placeHolder;
			
			placeHolder = this.stickers[7];
			this.stickers[7] = this.stickers[3];
			this.stickers[3] = this.stickers[1];
			this.stickers[1] = this.stickers[5];
			this.stickers[5] = placeHolder;
			
		} else {
			
			placeHolder = this.stickers[6];
			this.stickers[6] = this.stickers[8];
			this.stickers[8] = this.stickers[2];
			this.stickers[2] = this.stickers[0];
			this.stickers[0] = placeHolder;
		
			placeHolder = this.stickers[7];
			this.stickers[7] = this.stickers[5];
			this.stickers[5] = this.stickers[1];
			this.stickers[1] = this.stickers[3];
			this.stickers[3] = placeHolder;
			
		}
		
	}
	
	public int correctAmount() {
		
		int correctCount = 0;
		
		for (String sticker : this.stickers) {
			
			if (sticker.equals(this.side.substring(0, 1))) {
				
				correctCount++;
				
			}
			
		}
		
		return correctCount;
		
	}
	
	public void printFace() {
		
		System.out.printf("-------\n|%s %s %s|\n|%s %s %s|\n|%s %s %s|\n-------", stickers[0], stickers[1], stickers[2], stickers[3], stickers[4], stickers[5], stickers[6], stickers[7], stickers[8]);
		
	}
	
}
