package living;

import util.utilities;

public class Enemies implements Bots{
	protected int level;
	public int damage;
	public int health;
	public String cry;
	private boolean rare;
	public Enemies(int floor)
	{
		 this(floor,false);
	}
	public Enemies(int floor,boolean rare)
	{
		this.level = floor;
		this.rare = rare;
		this.damage = this.getDamage();
		this.health = this.getHealth();
		this.cry = this.getBattleCry();
	}
	public int getDamage()
	{
		if(rare)
		{
			return 9999999;
		}
		if(level == 1)
		{
			return utilities.getRandom(1,2);
		}
		if(level == 2)
		{
			return utilities.getRandom(2,3);
		}
		if(level == 3)
		{
			return utilities.getRandom(3,4);
		}
		if(level == 4)
		{
			return utilities.getRandom(4,5);
		}
		if(level >= 5)
		{
			return utilities.getRandom(5,6);
		}
		
		return 0;
	}
	public int getHealth()
	{
		if(rare)
		{
			return  9999999;
		}
		if(level == 1)
		{
			return utilities.getRandom(1,1);
		}
		if(level == 2)
		{
			
			return utilities.getRandom(2,4);
		}
		if(level == 3)
		{
			return utilities.getRandom(5,7);
		}
		if(level == 4)
		{
			return utilities.getRandom(7,12);
		}
		if(level >= 5)
		{
			return utilities.getRandom(13,14);
		}
		
		return 0;
	}
	public String getBattleCry()
	{
		int x = utilities.getRandom(0,2);
		
		String[] lvl1 = {"raaaa","meow","squeak"};
		String[] lvl2 = {"bark","reeee","croak"};
		String[] lvl3 = {"Hyuuu","Grrr","Shahh"};
		String[] lvl4 = {"DWAA","GYOO","ZAAHHH"};
		String[] lvl5 = {"WRRRRYYYYY","GUUUAAAAA","KYUUUNNNNN"};
		if(rare)
		{
			return "ROOOOOOOOARRRRRRRRR";
		}
		if(level == 1)
		{
			return lvl1[x];
		}
		if(level == 2)
		{
			return lvl2[x];
		}
		if(level == 3)
		{
			return lvl3[x];
		}
		if(level == 4)
		{
			return lvl4[x];
		}
		if(level >= 5)
		{
			return lvl5[x];
		}
		
		return  "no";
	}
	public void printBot()
	{
		/*System.out.print("BattleCry: "+ cry + " Damage: "+ damage
				+ " Health: "+ health);*/
		System.out.print("[ "+ cry +" ]");
	}
}
