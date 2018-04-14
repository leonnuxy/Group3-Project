import javafx.scene.control.Label;

/**
 * this is a static class of score that is constant across all levels so score can be tracked from scene to scene
 * @author MyPrecious
 *
 */
public class Score {
	//score variable
	private static int score = 0;
	private static long scoreFinal = 0;
	private static String name = "";
	
	/* gets the name of the player */
	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Score.name = name;
	}

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
	 * Initialise the score at 0 at the beginning of any new game
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
	public static void setFinalScore(long finalScore) {
		scoreFinal = finalScore;
	}
	
	public static long getFinalScore() {
		return scoreFinal;
	}
//	TimerS.getTotalTime()
	
}
