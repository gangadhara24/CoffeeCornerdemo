package com.swissre.model;


/**
 * @author gangadhara
 *
 */
public class Product {

	private String pname;
	private int qty;
	private double price;
	private double totalPrice;
	
	private String pSize;
	
	public Product() {
	}

	public Product(String psize, String pname, int qty, double price, double totalPrice) {
		this.pSize = psize;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.totalPrice = totalPrice;
	}
	

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPname() {
		return pname;
	}

	public int getQty() {
		return qty;
	}

	public double getPrice() {
		return price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public static void displayFormat() {
		System.out.format(
				"-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("\nProduct Name\t\tSize\t\tQuantity\t\tRate \t\t\t\tTotal Price\n");
		System.out.format(
				"-----------------------------------------------------------------------------------------------------------------------------------\n");
	}

	public void display() {
		System.out.format("%-9s      %-9s       %5d               %9.2f                       %14.2f\n",
				pname, pSize, qty, price, totalPrice);
	}

	@Override
	public String toString() {
		return "Product ["+"pname=" + pname + ", qty=" + qty + ", price=" + price + ", totalPrice="
				+ totalPrice + ", pSize=" + pSize + "]";
	}
	
	
	
}
