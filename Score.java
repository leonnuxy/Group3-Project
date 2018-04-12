import javafx.scene.control.Label;

/**
 * this is a static class of score that is constant across all levels so score can be tracked from scene to scene
 * @author MyPrecious
 *
 */
public class Score {
	//score variable
	private static int score = 0;
	
	/*
	 * increment score by the passed amount
	 */
	public static void setScore(int toIncrementBy) {
		score += toIncrementBy;
	}
	
	public static int getScore() {
		return score;
	}
	
	/*
	 * initialize the score at 0 at the beginning of any new game
	 */
	public static void initScore() {
		score = 0;
	}
	
	/*
	 * a label for the screen to display the score
	 */
	public static Label scoreLabel() {
		Label score_label = new Label("Collectibles: " + getScore());
		return score_label;
	}
	
	/*
	 * score is associated with time played so the final score must be calculated
	 */
	public static long finalScore() {
		return TimerS.getTotalTime();
	}
	
}
