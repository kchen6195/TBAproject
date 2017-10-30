package living;

public class Player implements Bots{
	private int damage;
	private int health;
	private String food;
	private String[] inventory = new String[3];
	public Player(String sword, String armor, String food)
	{
		this.inventory[0]= sword;
		this.inventory[1]= armor;
		this.inventory[2]= food;
		this.damage = getDamage();
		this.health= getHealth();
		this.food= getFood();
		
	}
	public int getDamage()
	{
		if(inventory[0]=="bronze")
		{
			return 4;
		}
		if(inventory[0]=="silver")
		{
			return 6;
		}
		if(inventory[0]=="golden")
		{
			return 8;
		}
		if(inventory[0]=="dragon")
		{
			return 15;
		}
		if(inventory[0]=="magic")
		{
			return 40;
		}
		return 1;
	}
	public int getHealth()
	{
		if(inventory[1]=="bronze")
		{
			return 7;
		}
		if(inventory[1]=="silver")
		{
			return 9;
		}
		if(inventory[1]=="golden")
		{
			return 11;
		}
		if(inventory[1]=="dragon")
		{
			return 30;
		}
		if(inventory[1]=="magic")
		{
			return 70;
		}
		return 3;
	}
	public String getFood()
	{
		return inventory[2];
	}
	public void printBot()
	{
		/*System.out.print(" Damage: "+ damage
				+ " Health: "+ health+ " Food: "+ food);*/
		System.out.print("[ Player ]");
	}
}
