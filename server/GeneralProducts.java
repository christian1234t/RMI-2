import java.rmi.RemoteException;

public class GeneralProducts {
    private String productcode;
    private String name;
    private String description;
    private int quantity;
    private double retailprice;
    private double storeprice;

    public GeneralProducts(String newProductcode, String newName, String newDescription, int newQuantity,
            double newRetailprice,
            double newStoreprice) throws RemoteException {
        this.productcode = newProductcode;
        this.name = newName;
        this.description = newDescription;
        this.quantity = newQuantity;
        this.retailprice = newRetailprice;
        this.storeprice = newStoreprice;
    }

    public String getProductcode() throws RemoteException {
        return this.productcode;
    }

    public String getName() throws RemoteException {
        return this.name;
    }

    public String getDescription() throws RemoteException {
        return this.description;
    }

    public int getQuantity() throws RemoteException {
        return this.quantity;
    }

    public double getRetailprice() throws RemoteException {
        return this.retailprice;
    }

    public double getStoreprice() throws RemoteException {
        return this.storeprice;
    }
}
