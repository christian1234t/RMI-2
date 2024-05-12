import java.rmi.RemoteException;

public class Product implements ProductInterface {
	private String productCode;
	private String name;
	private String description;
	private int quantity;
	private double retailPrice;
	private double storePrice;

	public Product(String productCode, String name, String description, int quantity, double retailPrice,
			double storePrice) throws RemoteException {
		this.productCode = productCode;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.retailPrice = retailPrice;
		this.storePrice = storePrice;
	}

	public String viewProduct() throws RemoteException {
		return "Product Code: " + productCode + "\n" +
				"Name: " + name + "\n" +
				"Description: " + description + "\n" +
				"Quantity: " + quantity + "\n" +
				"Retail Price: " + retailPrice + "\n" +
				"Store Price: " + storePrice;
	}

	public String getProductCode() throws RemoteException {
		return productCode;
	}

	// Implement the other getters as needed

	@Override
	public String getName() throws RemoteException {
		return name;
	}

	@Override
	public String getDescription() throws RemoteException {
		return description;
	}

	@Override
	public int getQuantity() throws RemoteException {
		return quantity;
	}

	@Override
	public double getRetailPrice() throws RemoteException {
		return retailPrice;
	}

	@Override
	public double getStorePrice() throws RemoteException {
		return storePrice;
	}
}
