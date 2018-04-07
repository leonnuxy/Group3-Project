
public class TimerS {
	
	public static long getTime() {
		return System.currentTimeMillis();
	}
	
	public static long getTotalTime(long start, long end) {
		return ((end - start)/1000);
	}
}