package rooms;
/*
 * Author: Kelvin Chen
 * Title: TBAproject
 * Date: 11/5/17
 * 
 */
import java.util.Arrays;

import living.Bots;
import util.utilities;

public abstract class Chamber {

	
	private Bots[] occupants;
	public int gold;
	public boolean explored;
    private int x, y;
    /*
	 * Author: Kelvin Chen
	 * Description: constructor for Chamber
	 * @params: occupants- mobs, and players
	 * 			gold - gold for the player to collect
	 * 			explored - for printing board
	 * 			x - position for horizontal
	 * 			y - position for verticle
	 */
    public Chamber(Bots[] occupants, int gold,boolean explored, int x, int y)
    {
    	this.x = x;
    	this.y = y;
        this.occupants = occupants;
        this.gold = gold;
        this.explored = false;
    }
    /*
	 * Author: Kelvin Chen
	 * Description: gets the Bots in the chamber
	 * 
	 */
    public Bots[] getOccupants() {
        return occupants;
    }
    /*
	 * Author: Kelvin Chen
	 * Description: sets the Bots in the chamber
	 * 
	 */
    public void setOccupants(Bots[] occupants) {
        this.occupants = occupants;
    }
    public void addOccupant(Bots p)
    {
        this.occupants = Arrays.copyOf(this.occupants,this.occupants.length+1);
        this.occupants[this.occupants.length-1] = p;
       
    }
    public int getX()
    {
    	return x;
    }
    
    public int getY()
    {
    	return y;
    }
    public abstract void print();
}
