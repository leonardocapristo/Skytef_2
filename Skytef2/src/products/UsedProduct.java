package products;


public class UsedProduct extends Product {
	
	private String date;
	
	public UsedProduct() {
		
	}

	public UsedProduct(String name, Double price, String date) {
		super(name, price);
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String priceTag () {
		return getName()+ " " + getPrice() + "(Data de compra:  " + this.date + ")";
	}
	
	

}
