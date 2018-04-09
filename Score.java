import javafx.scene.control.Label;

public class Score {
	private static int score = 0;
	
	public static void setScore(int toIncrementBy) {
		score += toIncrementBy;
	}
	
	public static int getScore() {
		return score;
	}
	
	public static void initScore() {
		score = 0;
	}
	
	public static Label scoreLabel() {
		Label score_label = new Label("Collectibles: " + getScore());
		return score_label;
	}
	
	public static long finalScore() {
		return TimerS.getTotalTime();
	}
	
}
