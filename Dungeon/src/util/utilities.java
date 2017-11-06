package util;
/*
 * Author: Kelvin Chen
 * Title: TBAproject
 * Date: 11/5/17
 * 
 */
public class utilities {

	/*
	 * Author: Kelvin Chen
	 * Description: generate random number in range inclusive
	 * @param - low min number
	 * 			high max number
	 */
	public static int getRandom(int low, int high)
	{
		return (int)(Math.random()*((high-low)+1) + low);
	}
	/*
	 * Author: Kelvin Chen
	 * Description: generate random number of gold
	 * @param - level- multiplier on gold
	 */
	public static int getGold(int level)
	{
		return getRandom(8,10)*level;
	}
}
