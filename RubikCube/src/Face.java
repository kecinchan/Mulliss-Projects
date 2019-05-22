public class Face {

	private String[] stickers;
	private final String side;

	public Face(String inputSide) {
		
		this.side = inputSide;
		
		for (int i = 0; i < 9; i++) {
			
			stickers[i] = this.side.substring(0, 1);
			
		}
		
	}
	
	public void printFace() {
		
		System.out.printf("「 %s %s %s\n %s %s %s\n %s %s %s 」");
		
	}
	
}
