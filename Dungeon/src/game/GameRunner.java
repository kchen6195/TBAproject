package game;

import java.util.Scanner;

import living.Bots;
import living.Enemies;
import living.Merchant;
import living.Player;
import rooms.Chamber;
import rooms.Fight;
import rooms.Shop;
import util.utilities;


public class GameRunner {

	public static void main(String[] args) {
		//Player x = new Player("bronze"," ","apple");
		//x.printBot();
		//System.out.println((int)(Math.random()*5 + 1));
		Chamber[][] map = new Chamber[5][5];
		for (int j = 0; j<map.length; j++)
        {
        	Chamber[] row = map[j]; //row 1
            for (int i = 0; i<row.length;i++)
            {
            	if(j==0 && i ==0)
            	{
            		Player champ = new Player(" "," "," ");
            	
            		Bots[] bots= {champ};
            		row[i]= new Fight(bots,0,true,j+1,i+1);
            	}
            	else if(i== map[j].length-1)
            	{
            		Merchant merch = new Merchant(j+1);
            	
            		Bots[] bots = {merch};
            		
            		row[i]= new Shop(bots,0,false,j+1,i+1);
            	}
            	else
            	{
            		Enemies enny = new Enemies(j+1);
            		Bots[] bots = {enny};
            		row[i]= new Fight(bots,utilities.getGold(j+1),false,j+1,i+1);
            	}
            }
        }

		for (int j = 0; j<map.length; j++)
		{
			
            for (int i = 0; i<map[j].length;i++)
            {
            	map[j][i].print();
            }
		}
		
	}
}