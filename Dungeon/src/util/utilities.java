package util;

public class utilities {

	public static int getRandom(int low, int high)
	{
		return (int)(Math.random()*((high-low)+1) + low);
	}
	public static int getGold(int level)
	{
		return getRandom(8,10)*level;
	}
}
