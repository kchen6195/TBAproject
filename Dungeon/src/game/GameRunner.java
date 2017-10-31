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
		Player champ = new Player();
		//x.printBot();
		//System.out.println((int)(Math.random()*5 + 1));
		Board game = new Board(5,5);
		game.printBoard();
		
		boolean gameOn = true;
		while(gameOn)
		{
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
					champ.setY(champ.getY()-1);
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
					champ.setY(champ.getY()+1);
					System.out.println(champ.getY());
				}
			}
		}
        }

		
		
	}
