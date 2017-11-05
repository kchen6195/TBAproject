package living;

public class Player implements Bots{
	public int damage;
	public int health;
	public int maxH;
	public String food;
	private int posX;
	private int posY;
	public int gold;
	public String[] inventory = new String[3];
	public Player(String sword, String armor, String food)
	{
		this.inventory[0]= sword;
		this.inventory[1]= armor;
		this.inventory[2]= food;
		this.damage = getDamage();
		this.health= getHealth();
		this.maxH = getHealth();
		this.food= getFood();
		setX(0);
		setY(0);
	}
	public Player()
	{
		this(" ", " ", " ");
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
			return 11;
		}
		if(inventory[1]=="silver")
		{
			return 14;
		}
		if(inventory[1]=="golden")
		{
			return 20;
		}
		if(inventory[1]=="dragon")
		{
			return 30;
		}
		if(inventory[1]=="magic")
		{
			return 70;
		}
		return 8;
	}
	public String getFood()
	{
		return inventory[2];
	}
	public void setX(int x )
	{
		this.posX = x;
		
	}
	public void setY(int y )
	{
		this.posY = y;
	}
	public int getX()
	{
		return this.posX;
	}
	public int getY()
	{
		return this.posY;
	}
	
	public void printBot()
	{
		/*System.out.print(" Damage: "+ damage
				+ " Health: "+ health+ " Food: "+ food);*/
		System.out.print("[ Player ]");
	}
}
