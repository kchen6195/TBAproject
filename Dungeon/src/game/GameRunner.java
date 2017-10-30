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
		//Player x = new Player("bronze"," ","apple");
		//x.printBot();
		//System.out.println((int)(Math.random()*5 + 1));
		Board game = new Board(5,5);
		game.printBoard();
        }

		
		
	}
