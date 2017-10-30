package util;

public class utilities {

	public static int getRandom(int low, int high)
	{
		return (int)(Math.random()*((high-low)+1) + low);
	}
}
