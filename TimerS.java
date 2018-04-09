
public class TimerS {
	
	public static long startTime;
	public static long endTime;
	
	public static void setStartTime() {
		startTime = System.currentTimeMillis();
		//return startTime;
	}
	
	public static void setEndTime() {
		endTime = System.currentTimeMillis();
		//return endTime;
	}
	
	public static long getTotalTime() {
		return ((endTime - startTime)/1000);
	}
}