/*
 * Timer class to help with the score calcultion in a snake game
 */
public class TimerS {
	
	//initialize the varibales 
	public static long startTime;
	public static long endTime;
	
	/*
	 * set a start time
	 */
	public static void setStartTime() {
		startTime = System.currentTimeMillis();
	}
	
	/*
	 * set an end time
	 */
	public static void setEndTime() {
		endTime = System.currentTimeMillis();
	}
	
	/*
	 * calculate the total time played and return it as a seconds value
	 */
	public static long getTotalTime() {
		return ((endTime - startTime)/1000);
	}
}