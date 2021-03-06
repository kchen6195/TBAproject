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

/*
 * Author: Kelvin Chen
 * Title: TBAproject
 * Date: 11/5/17
 * 
 */
public class GameRunner {

	public static void main(String[] args) {
		Bots[] empty = new Bots[0];
		
		Player champ = new Player();
		boolean action = true;
		//x.printBot();
		//System.out.println((int)(Math.random()*5 + 1));
		Board game = new Board(5,5);
		//game.printBoard();
		System.out.print("Welcome to my game! get to bottom floor to win. You will fight monsters and gain gold along the way. "
				+ "\n You must defeat all the monsters on the floor to go to the shop. The shop will teleport you to the first chamber\n"
				+ "then move down after. THERE IS NO GOING BACK\n");
		boolean gameOn = true;
		boolean lose = false;
		while(gameOn)
		{
			action = true;
			
			//check for player health each time;
			game.printBoard();
			Scanner move = new Scanner(System.in);
			//System.out.print(move.next());
			String input = move.next();
			
			if(input.equalsIgnoreCase("Down"))
			{
				if(champ.getY()== game.getMaxY())
				{
					//should never get to this condition
					System.out.println("YOU WIN!!!!!!");
					gameOn = false;
				}
				else if(game.map[champ.getY()+1][champ.getX()].explored)
				{
					game.map[champ.getY()][champ.getX()].setOccupants(empty);
					champ.setY(champ.getY()+1);
					
					
					
					game.map[champ.getY()][champ.getX()].addOccupant(champ);
				}
				else
				{
					
					game.map[champ.getY()][champ.getX()].setOccupants(empty);
					champ.setY(champ.getY()+1);
					
					if(game.map[champ.getY()][champ.getX()].getOccupants()[0] instanceof Merchant)
					{
						Merchant monster = (Merchant) game.map[champ.getY()][champ.getX()].getOccupants()[0];
						System.out.println("BUY SOMETHING");
						System.out.println("BattleCry: "+ monster.cry );
						System.out.println("Player Damage: " + champ.damage + " Player Health: "+ champ.health + "/"+ champ.maxH + " " +" Gold : " + champ.gold  
								+ "\n" + "Food: "+ champ.food);
						System.out.println((monster.cry + "\n"
								+"Products: "+ "\n" 
								+ monster.product[0]+ " : "+ monster.price[0]+" gold" +"\n"
								+ monster.product[1]+ " : "+ monster.price[1]+" gold" + "\n"
								+ monster.product[2]+ " : "+ monster.price[2]+" gold" + "\n"
								+ "TO BUY SAY 'SWORD' OR 'ARMOR' OR 'FOOD'"));
						while(action)
						{
							Scanner fight = new Scanner(System.in);
							String act = fight.next();
							
							if(act.equalsIgnoreCase("attack"))
									{
										monster.health = monster.health - champ.damage;
										champ.health = champ.health - monster.damage;
										if(champ.health <= 0)
										{
											System.out.println("YOU LOSE");
											gameOn = false;
											action = false;
										}
										if(monster.health <= 0)
										{
											
											action = false;
											
										}
									}
							else if(act.equalsIgnoreCase("SWORD"))
							{
								if(champ.gold >= monster.price[0])
								{
									champ.gold = champ.gold - monster.price[0];
									champ.inventory[0]= monster.getType();
									champ.damage = champ.getDamage();
									System.out.println("YOU BOUGHT "+ monster.product[0]);
									System.out.println("Player Damage: " + champ.damage + " Player Health: "+ champ.health + "/"
									+ champ.maxH + " " +" Gold : " + champ.gold+ "\n" + "Food: "+ champ.food);

								}
								
							}
							else if(act.equalsIgnoreCase("ARMOR"))
							{
								if(champ.gold >= monster.price[1])
								{
									champ.gold = champ.gold - monster.price[1];
									champ.inventory[1]= monster.getType();
									champ.maxH = champ.getHealth();
									System.out.println("YOU BOUGHT "+ monster.product[1]);
									System.out.println("Player Damage: " + champ.damage + " Player Health: "+ champ.health +
											"/"+ champ.maxH + " " +" Gold : " + champ.gold+ "\n" + "Food: "+ champ.food);
								}
								
							}
							else if(act.equalsIgnoreCase("FOOD"))
							{
								if(champ.gold >= monster.price[2])
								{
									champ.gold = champ.gold - monster.price[2];
									champ.inventory[2]= monster.invFood();
									champ.food= champ.getFood();
									System.out.println("YOU BOUGHT "+ monster.product[2]);
									System.out.println("Player Damage: " + champ.damage + " Player Health: "+ champ.health 
											+ "/"+ champ.maxH + " " +" Gold : " + champ.gold+ "\n" + "Food: "+ champ.food);
								}
								
							}
							else if(act.equalsIgnoreCase("HEAL"))
							{
								if(champ.food == "apple")
								{
									champ.health = champ.health + 10;
								}
								if(champ.food == "orange")
								{
									champ.health = champ.health + 15;
								}
								if(champ.food == "pear")
								{
									champ.health = champ.health + 20;
								}
								if(champ.food == "dragonfruit")
								{
									champ.health = champ.health + 30;
								}
								if(champ.food == "magicfruit")
								{
									champ.health = champ.health + 100;
								}
								if(champ.health > champ.maxH)
								{
									champ.health = champ.maxH;
								}
								System.out.println("YOU HAVE BEEN HEALED");
								champ.food = " ";
							}
							else if(act.equalsIgnoreCase("LEAVE"))
							{
								action = false;
							}
							else
							{
								System.out.println("SAY LEAVE TO LEAVE");
								
							}
							
							
						}
					}
					else if(game.map[champ.getY()][champ.getX()].getOccupants()[0] instanceof Enemies)
					{
					game.map[champ.getY()][champ.getX()].addOccupant(champ);
					Enemies enny = (Enemies) game.map[champ.getY()][champ.getX()].getOccupants()[0];
					if(game.map[champ.getY()][champ.getX()].getOccupants().length==2)
					{
						System.out.println("FIGHT THEM NOW");
						
						
						
						while(action)
						{
							System.out.println("BattleCry: "+ enny.cry + " Damage: "+ enny.damage
									+ " Health: "+ enny.health);
							System.out.println("Player Damage: " + champ.damage + " Player Health: "+ champ.health+ "/"+ 
									champ.maxH + " " +  " Gold : " + champ.gold+ "\n" + "Food: "+ champ.food);
							Scanner fight = new Scanner(System.in);
							String act = fight.next();
							if(act.equalsIgnoreCase("attack"))
									{
								enny.health = enny.health - champ.damage;
										champ.health = champ.health - enny.damage;
										if(champ.health <= 0)
										{
											System.out.println("YOU LOSE");
											gameOn = false;
											action = false;
										}
										if(enny.health <= 0)
										{
											
											action = false;
											
										}
									}
							
							else if(act.equalsIgnoreCase("HEAL"))
							{
								if(champ.food == "apple")
								{
									champ.health = champ.health + 10;
								}
								if(champ.food == "orange")
								{
									champ.health = champ.health + 15;
								}
								if(champ.food == "pear")
								{
									champ.health = champ.health + 20;
								}
								if(champ.food == "dragonfruit")
								{
									champ.health = champ.health + 30;
								}
								if(champ.food == "magicfruit")
								{
									champ.health = champ.health + 100;
								}
								if(champ.health > champ.maxH)
								{
									champ.health = champ.maxH;
								}
								System.out.println("YOU HAVE BEEN HEALED");
								champ.food = " ";
							}
							else
							{
								System.out.println("ATTACK OR HEAL");
							}
							
							
						}
						
					
					}
					game.map[champ.getY()][champ.getX()].explored = true;
					//after kill
					champ.gold +=game.map[champ.getY()][champ.getX()].gold;
					game.map[champ.getY()][champ.getX()].gold = 0;
					game.map[champ.getY()][champ.getX()].setOccupants(empty);
					
					
					game.map[champ.getY()][champ.getX()].addOccupant(champ);
					
					
					
				}
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
					
					game.map[champ.getY()][champ.getX()].setOccupants(empty);
					champ.setX(champ.getX()+1);
					
					if(game.map[champ.getY()][champ.getX()].getOccupants()[0] instanceof Merchant)
					{
						Merchant monster = (Merchant) game.map[champ.getY()][champ.getX()].getOccupants()[0];
						System.out.println("BUY SOMETHING");
						System.out.println("BattleCry: "+ monster.cry );
						System.out.println("Player Damage: " + champ.damage + " Player Health: "+ champ.health + "/"+ champ.maxH + " " +" Gold : " + champ.gold  
								+ "\n" + "Food: "+ champ.food);
						System.out.println((monster.cry + "\n"
								+"Products: "+ "\n" 
								+ monster.product[0]+ " : "+ monster.price[0]+" gold" +"\n"
								+ monster.product[1]+ " : "+ monster.price[1]+" gold" + "\n"
								+ monster.product[2]+ " : "+ monster.price[2]+" gold" + "\n"
								+ "TO BUY SAY 'SWORD' OR 'ARMOR' OR 'FOOD'"));
						while(action)
						{
							Scanner fight = new Scanner(System.in);
							String act = fight.next();
							
							if(act.equalsIgnoreCase("attack"))
									{
										monster.health = monster.health - champ.damage;
										champ.health = champ.health - monster.damage;
										if(champ.health <= 0)
										{
											System.out.println("YOU LOSE");
											gameOn = false;
											action = false;
										}
										if(monster.health <= 0)
										{
											
											action = false;
											
										}
									}
							else if(act.equalsIgnoreCase("SWORD"))
							{
								if(champ.gold >= monster.price[0])
								{
									champ.gold = champ.gold - monster.price[0];
									champ.inventory[0]= monster.getType();
									champ.damage = champ.getDamage();
									System.out.println("YOU BOUGHT "+ monster.product[0]);
									System.out.println("Player Damage: " + champ.damage + " Player Health: "+ champ.health + "/"
									+ champ.maxH + " " +" Gold : " + champ.gold+ "\n" + "Food: "+ champ.food);

								}
								
							}
							else if(act.equalsIgnoreCase("ARMOR"))
							{
								if(champ.gold >= monster.price[1])
								{
									champ.gold = champ.gold - monster.price[1];
									champ.inventory[1]= monster.getType();
									champ.maxH = champ.getHealth();
									System.out.println("YOU BOUGHT "+ monster.product[1]);
									System.out.println("Player Damage: " + champ.damage + " Player Health: "+ champ.health +
											"/"+ champ.maxH + " " +" Gold : " + champ.gold+ "\n" + "Food: "+ champ.food);
								}
								
							}
							else if(act.equalsIgnoreCase("FOOD"))
							{
								if(champ.gold >= monster.price[2])
								{
									champ.gold = champ.gold - monster.price[2];
									champ.inventory[2]= monster.invFood();
									champ.food= champ.getFood();
									System.out.println("YOU BOUGHT "+ monster.product[2]);
									System.out.println("Player Damage: " + champ.damage + " Player Health: "+ champ.health 
											+ "/"+ champ.maxH + " " +" Gold : " + champ.gold+ "\n" + "Food: "+ champ.food);
								}
								
							}
							else if(act.equalsIgnoreCase("HEAL"))
							{
								if(champ.food == "apple")
								{
									champ.health = champ.health + 10;
								}
								if(champ.food == "orange")
								{
									champ.health = champ.health + 15;
								}
								if(champ.food == "pear")
								{
									champ.health = champ.health + 20;
								}
								if(champ.food == "dragonfruit")
								{
									champ.health = champ.health + 30;
								}
								if(champ.food == "magicfruit")
								{
									champ.health = champ.health + 100;
								}
								if(champ.health > champ.maxH)
								{
									champ.health = champ.maxH;
								}
								System.out.println("YOU HAVE BEEN HEALED");
								champ.food = " ";
							}
							else if(act.equalsIgnoreCase("LEAVE"))
							{
								action = false;
								game.map[champ.getY()][champ.getX()].setOccupants(empty);
								
								champ.setX(0);
								game.map[champ.getY()][0].addOccupant(champ);
							}
							else
							{
								System.out.println("SAY LEAVE TO LEAVE");
							}
							
							
						}
					}
					else if(game.map[champ.getY()][champ.getX()].getOccupants()[0] instanceof Enemies)
					{
					game.map[champ.getY()][champ.getX()].addOccupant(champ);
					Enemies enny = (Enemies) game.map[champ.getY()][champ.getX()].getOccupants()[0];
					if(game.map[champ.getY()][champ.getX()].getOccupants().length==2)
					{
						System.out.println("FIGHT THEM NOW");
						
						
						
						while(action)
						{
							System.out.println("BattleCry: "+ enny.cry + " Damage: "+ enny.damage
									+ " Health: "+ enny.health);
							System.out.println("Player Damage: " + champ.damage + " Player Health: "+ champ.health+ "/"+ 
									champ.maxH + " " +  " Gold : " + champ.gold+ "\n" + "Food: "+ champ.food);
							Scanner fight = new Scanner(System.in);
							String act = fight.next();
							if(act.equalsIgnoreCase("attack"))
									{
								enny.health = enny.health - champ.damage;
										champ.health = champ.health - enny.damage;
										if(champ.health <= 0)
										{
											System.out.println("YOU LOSE");
											gameOn = false;
											action = false;
										}
										if(enny.health <= 0)
										{
											
											action = false;
											
										}
									}
							
							else if(act.equalsIgnoreCase("HEAL"))
							{
								if(champ.food == "apple")
								{
									champ.health = champ.health + 10;
								}
								if(champ.food == "orange")
								{
									champ.health = champ.health + 15;
								}
								if(champ.food == "pear")
								{
									champ.health = champ.health + 20;
								}
								if(champ.food == "dragonfruit")
								{
									champ.health = champ.health + 30;
								}
								if(champ.food == "magicfruit")
								{
									champ.health = champ.health + 100;
								}
								if(champ.health > champ.maxH)
								{
									champ.health = champ.maxH;
								}
								System.out.println("YOU HAVE BEEN HEALED");
								champ.food = " ";
							}
							else
							{
								System.out.println("ATTACK OR HEAL");
							}
							
							
						}
						
					
					}
					game.map[champ.getY()][champ.getX()].explored = true;
					//after kill
					champ.gold +=game.map[champ.getY()][champ.getX()].gold;
					game.map[champ.getY()][champ.getX()].gold = 0;
					game.map[champ.getY()][champ.getX()].setOccupants(empty);
					
					
					game.map[champ.getY()][champ.getX()].addOccupant(champ);
					
					
					
				}
				}
			}
			
			
			else
			{
				System.out.println("type right or down.");
			}
		}
	}
}
		
        
	
	

		
		
	
