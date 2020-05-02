package collection;

public class Laptop
{
	private int ram;
	private String brand;
    private double price;
	   
	   
	protected Laptop(int ram, String brand, double price) 
	{
		super();
		this.ram = ram;
		this.brand = brand;
		this.price = price;
	}

	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [ram=" + ram + ", brand=" + brand + ", price=" + price + "]";
	}
	   
 
} 
