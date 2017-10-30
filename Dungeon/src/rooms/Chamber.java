package rooms;

import java.util.Arrays;

import living.Bots;
import util.utilities;

public abstract class Chamber {

	
	private Bots[] occupants;
	private int gold;
	public boolean explored;
    private int x, y;
    
    public Chamber(Bots[] occupants, int gold,boolean explored, int x, int y)
    {
    	this.x = x;
    	this.y = y;
        this.occupants = occupants;
        this.gold = gold;
        this.explored = false;
    }
    public Bots[] getOccupants() {
        return occupants;
    }
    public void setOccupants(Bots[] occupants) {
        this.occupants = occupants;
    }
    public void addOccupant(Bots p)
    {
        this.occupants = Arrays.copyOf(this.occupants,this.occupants.length+1);
        this.occupants[this.occupants.length-1] = p;
       // p.setRoom(this);
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
