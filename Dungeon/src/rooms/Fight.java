package rooms;
/*
 * Author: Kelvin Chen
 * Title: TBAproject
 * Date: 11/5/17
 * 
 */
import living.Bots;

public class Fight extends Chamber{
	/*
	 * Author: Kelvin Chen
	 * Description: overriden constructor
	 * 
	 * 
	 */
	public Fight(Bots[] occupants, int gold, boolean explored, int x, int y) {
		super(occupants, gold, explored, x, y);
		
	}
	/*
	 * Author: Kelvin Chen
	 * Description: displays chamber
	 * 
	 */
	public void print()
	{
		  if (getOccupants().length != 0 )
	        {
			  if(getOccupants().length== 2)
			  {
				  
				  getOccupants()[1].printBot();
			  }
			  else
	            getOccupants()[0].printBot();
	        }
	        else if (this.explored)
	        {
	            System.out.print("[ X ]");
	        }
	        else
	        {
	            System.out.print("[   ]");
	        }

	}
	
}
