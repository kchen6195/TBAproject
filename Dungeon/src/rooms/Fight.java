package rooms;

import living.Bots;

public class Fight extends Chamber{

	public Fight(Bots[] occupants, int gold, boolean explored, int x, int y) {
		super(occupants, gold, explored, x, y);
		
	}
	public void print()
	{
		  if (getOccupants().length != 0)
	        {
	            getOccupants()[0].printBot();
	        }
	        else if (this.explored)
	        {
	            System.out.print("[ _ ]");
	        }
	        else
	        {
	            System.out.print("[   ]");
	        }

	}
	
}