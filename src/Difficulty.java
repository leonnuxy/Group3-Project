
public class Difficulty {
	
	private static double difficulty = 0.0;
	
	public static void setDifficulty(double x) {
		difficulty = x;
	}
	
	public static double getDifficulty() {
		return difficulty;
	}
	
	public static void changeDifficulty(double x) {
		if (difficulty <= 0.045) {
			
		}
		if (LevelActions.twoplayermode == true) {
			difficulty -= x;
		}
		else {
			difficulty -= x;
		}
	}
	
}
