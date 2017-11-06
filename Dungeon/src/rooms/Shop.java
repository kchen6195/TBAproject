package rooms;
/*
 * Author: Kelvin Chen
 * Title: TBAproject
 * Date: 11/5/17
 * 
 */
import living.Bots;

public class Shop extends Chamber{
	/*
	 * Author: Kelvin Chen
	 * Description: overriden constructor for Shop
	 * 
	 */
	public Shop(Bots[] occupants, int gold, boolean explored, int x, int y) {
		super(occupants, gold, explored, x, y);
		
	}
	/*
	 * Author: Kelvin Chen
	 * Description: displays chamber
	 * 
	 */
	public void print()
	{
		  if (getOccupants().length != 0)
	        {
	            getOccupants()[0].printBot();
	        }
	        else if (this.explored)
	        {
	            System.out.print("[ S ] \n");
	        }
	        else
	        {
	            System.out.print("[ S ] \n");
	        }

	}
}
