package collection;

public class Mobile implements Comparable<Mobile>
{
	   private int ram;
	   private String brand;
	   private double price;
   
       protected Mobile(int ram, String brand, double price) 
       {
		  super();
		  this.ram = ram;
		  this.brand = brand;
		  this.price = price;
	   }
       
        public int getRam() 
        {
		  return ram;
	    }
	    public void setRam(int ram)
	    {
		   this.ram = ram;
     	}
	    public String getBrand() 
	    {
		   return brand;
	    }
     	public void setBrand(String brand) 
     	{
		   this.brand = brand;
	    }
	    public double getPrice() 
	    {
		   return price;
	    }
	    public void setPrice(double price) 
	    {
		  this.price = price;
	    }
	@Override
	   public String toString()
	    {
		  return "Mobile [ram=" + ram + ", brand=" + brand + ", price=" + price + "]";
	    }

	//sorting based on ram
	@Override
	public  int compareTo(Mobile o) 
	{
		return (int) (this.getRam()-o.getRam());
	}

	//sorting using price
	/* 
	@Override
	 public double compareTo(Mobile o)
	 {
		return (int) (this.getPrice()-o.getPrice());
	} */
	
 }
