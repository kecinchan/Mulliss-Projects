
public class Runner {

	public static void main(String[] args) {
		
		Face blueFace = new Face("blue");
		Face whiteFace = new Face("white");
		Face greenFace = new Face("green");
		Face yellowFace = new Face("yellow");
		Face orangeFace = new Face("orange");
		Face redFace = new Face("red");
		
		Cube cube = new Cube(greenFace, blueFace, whiteFace, yellowFace, redFace, orangeFace);
		cube.printCube();
		
		cube.rotateZ(false);
		cube.printCube();
		cube.rotateZ(true);
		cube.printCube();
		
	}

}
