package game;

import java.util.Scanner;

import board.Board;
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
		Bots[] empty = new Bots[0];
		Player champ = new Player();
		//x.printBot();
		//System.out.println((int)(Math.random()*5 + 1));
		Board game = new Board(5,5);
		//game.printBoard();
		System.out.print("Welcome to my game! get to bottom floor to win. You will fight monsters and gain gold along the way. "
				+ "\nYou must defeat 1 monster on each floor to progress. Trust me you want to fight more than 1."
				+  "\n type up, down, right and left to move.\n");
		boolean gameOn = true;
		boolean lose = false;
		while(gameOn)
		{
			//check for player health each time;
			game.printBoard();
			Scanner move = new Scanner(System.in);
			//System.out.print(move.next());
			String input = move.next();
			if(input.equalsIgnoreCase("Up"))
			{
				//move player 1 floor up.
				if(champ.getY()== 0)
				{
					System.out.println("You're on the top floor");
				}
				else
				{
					game.map[champ.getY()][champ.getX()].explored = true;
					//after kill
					game.map[champ.getY()][champ.getX()].setOccupants(empty);
					champ.setY(champ.getY()-1);
					System.out.println(champ.getY());
					// []
				}
			}
			if(input.equalsIgnoreCase("Down"))
			{
				if(champ.getY()== game.getMaxY())
				{
					//should never get to this condition
					System.out.println("You're on the bottom floor");
					
				}
				else
				{
					game.map[champ.getY()][champ.getX()].explored = true;
					//after kill
					game.map[champ.getY()][champ.getX()].setOccupants(empty);
					champ.setY(champ.getY()+1);
					System.out.println(champ.getY());
				}
			}
			if(input.equalsIgnoreCase("right"))
			{
				if(champ.getX()== game.getMaxX())
				{
					
					System.out.println("You're too far right to move");
				}
				else
				{
					game.map[champ.getY()][champ.getX()].explored = true;
					//after kill
					
					game.map[champ.getY()][champ.getX()].setOccupants(empty);
					champ.setX(champ.getX()+1);
					if(game.map[champ.getY()][champ.getX()].getOccupants().length==2)
					{
						Scanner fight = new Scanner(System.in);
						
					}
					System.out.println(champ.getX());
					game.map[champ.getY()][champ.getX()].addOccupant(champ);
					
				}
			}
			
			if(input.equalsIgnoreCase("left"))
			{
				if(champ.getX()== 0)
				{
					
					System.out.println("You're too far left to move");
				}
				else
				{
					game.map[champ.getY()][champ.getX()].explored = true;
					//after kill
					game.map[champ.getY()][champ.getX()].setOccupants(empty);
					champ.setX(champ.getX()-1);
					System.out.println(champ.getX());
				}
			}
			else
			{
				System.out.println("type up, down, right or left.");
			}
		}
		
        }
	
	}

		
		
	
