package board;

import living.Bots;
import living.Enemies;
import living.Merchant;
import living.Player;
import rooms.Chamber;
import rooms.Fight;
import rooms.Shop;
import util.utilities;
/*
 * Author: Kelvin Chen
 * Title: TBAproject
 * Date: 11/5/17
 * 
 */
public class Board {
	public Chamber[][] map;
	private int maxY;
	private int maxX;
	/*
	 * Author: Kelvin Chen
	 * Description: constructor
	 *
	 * @params: vert - dimensions of verticle;
	 * @params: horz - dimensions of horzontal;
	 */
	public Board(int vert, int horz)
	{
		this.maxY = vert;
		this.maxX = horz;
		this.map= new Chamber[vert][horz];
		for (int j = 0; j<map.length; j++)
        {
        	
            for (int i = 0; i<map[j].length;i++)
            {
            	if(j==0 && i ==0)
            	{
            		Player champ = new Player(" "," "," ");
            	
            		Bots[] bots= {champ};
            		map[j][i]= new Fight(bots,0,true,j+1,i+1);
            	}
            	else if(i== map[j].length-1)
            	{
            		Merchant merch = new Merchant(j+1);
            	
            		Bots[] bots = {merch};
            		
            		map[j][i]= new Shop(bots,0,false,j+1,i+1);
            	}
            	else
            	{
            		/*
            		 * Author: Kelvin Chen
            		 * Description: summons ULTRA MONSTER
            		 *	1 PERCENT CHANCE INSTA KILL 
            		 * 
            		 * 
            		 */
            		boolean rarity = false;
            		if(utilities.getRandom(1,100)==1)
            		{
            			rarity = true;
            		}
            		Enemies enny = new Enemies(j+1,rarity);
            		Bots[] bots = {enny};
            		map[j][i]= new Fight(bots,utilities.getGold(j+1),true,j+1,i+1);
            	}
            }
	}
}
	/*
	 * Author: Kelvin Chen
	 * Description: overloaded constructor
	 *
	 * @params: vert - dimensions of board side;
	 * 
	 */
	public Board(int vert)
	{
		this(vert,vert);
	}
	
	/*
	 * Author: Kelvin Chen
	 * Description: for loops and calls print for each bot
	 *
	 * 
	 * 
	 */
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
	public int getMaxY()
	{
		return this.maxY-1;
	}
	public int getMaxX()
	{
		return this.maxX-1;
	}
}
