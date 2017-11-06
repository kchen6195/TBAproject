package living;
/*
 * Author: Kelvin Chen
 * Title: TBAproject
 * Date: 11/5/17
 * 
 */
public class Merchant extends Enemies{
	public String[] product= new String[3];
	public int[] price= new int[3];
	public Merchant(int floor) {
		super(floor, true);
		this.cry="What would you like to buy?";
		this.product[0]= getSword();
		this.product[1]= getArmor();
		this.product[2]= getFood();
		this.price[0] = level * 8;
		this.price[1] = level * 10;
		this.price[2] = level * 5;
	}
	/*
	 * Author: Kelvin Chen
	 * Description: gets sword for shop
	 * 
	 */
	public String getSword()
	{
		if(level == 1)
		{
			return "bronze sword +4 dmg";
		}
		if(level == 2)
		{
			return "silver sword +6 dmg";
		}
		if(level == 3)
		{
			return "golden sword +8 dmg";
		}
		if(level == 4)
		{
			return "dragon sword +15 dmg";
		}
		if(level >= 5)
		{
			return "magic sword +40 dmg";
		}
		return "";
	}
	/*
	 * Author: Kelvin Chen
	 * Description: gets armor for shop
	 * 
	 */
	public String getArmor()
	{
		if(level == 1)
		{
			return "bronze armor +11 health";
		}
		if(level == 2)
		{
			return "silver armor +14 health";
		}
		if(level == 3)
		{
			return "golden armor +20 health";
		}
		if(level == 4)
		{
			return "dragon armor +30 health";
		}
		if(level >= 5)
		{
			return "magic armor +70 health";
		}
		return "";
	}
	/*
	 * Author: Kelvin Chen
	 * Description: gets food for shop
	 * 
	 */
	public String getFood()
	{
		if(level == 1)
		{
			return "apple regenerate 10 health";
		}
		if(level == 2)
		{
			return "orange regenerate 15 health";
		}
		if(level == 3)
		{
			return "pear regenerate 20 health";
		}
		if(level == 4)
		{
			return "dragon fruit regenerate 30 health";
		}
		if(level >= 5)
		{
			return "magic fruit regenerate 100 health";
		}
		return "";
	}
	/*
	 * Author: Kelvin Chen
	 * Description: used for setting inventory
	 * 
	 */
	public String getType()
	{
		if(level == 1)
		{
			return "bronze";
		}
		if(level == 2)
		{
			return "silver";
		}
		if(level == 3)
		{
			return "golden";
		}
		if(level == 4)
		{
			return "dragon";
		}
		if(level >= 5)
		{
			return "magic";
		}
		return " ";
		
	}
	/*
	 * Author: Kelvin Chen
	 * Description: gets food for inventory
	 * 
	 */
	public String invFood()
	{
		if(level == 1)
		{
			return "apple";
		}
		if(level == 2)
		{
			return "orange";
		}
		if(level == 3)
		{
			return "pear";
		}
		if(level == 4)
		{
			return "dragonfruit";
		}
		if(level >= 5)
		{
			return "magicfruit";
		}
		return " ";
	}
	public void printBot()
	{
		/*System.out.println(cry + "\n"
				+"Products: "+ "\n" 
				+ product[0]+ " : "+ price[0]+" gold" +"\n"
				+ product[1]+ " : "+ price[1]+" gold" + "\n"
				+ product[2]+ " : "+ price[2]+" gold" );*/
		System.out.println("[ Shop ]");
	}
}
	

