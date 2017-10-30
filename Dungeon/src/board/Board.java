package board;

import living.Bots;
import living.Enemies;
import living.Merchant;
import living.Player;
import rooms.Chamber;
import rooms.Fight;
import rooms.Shop;
import util.utilities;

public class Board {
	private Chamber[][] map;
	public Board(int vert, int horz)
	{
		Chamber[][] map = new Chamber[vert][horz];
		for (int j = 0; j<map.length; j++)
        {
        	
            for (int i = 0; i<map[j].length;i++)
            {
            	if(j==0 && i ==0)
            	{
            		Player champ = new Player(" "," "," ");
            	
            		Bots[] bots= {champ};
            		this.map[j][i]= new Fight(bots,0,true,j+1,i+1);
            	}
            	else if(i== map[j].length-1)
            	{
            		Merchant merch = new Merchant(j+1);
            	
            		Bots[] bots = {merch};
            		
            		this.map[j][i]= new Shop(bots,0,false,j+1,i+1);
            	}
            	else
            	{
            		Enemies enny = new Enemies(j+1);
            		Bots[] bots = {enny};
            		this.map[j][i]= new Fight(bots,utilities.getGold(j+1),false,j+1,i+1);
            	}
            }
	}
}
	public void printBoard()
	{
		for (int j = 0; j<this.map.length; j++)
		{
			
            for (int i = 0; i<this.map[j].length;i++)
            {
            	this.map[j][i].print();
            }
		}
	}
}
