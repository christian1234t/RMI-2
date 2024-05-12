import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductInterface extends Remote {
    // Getter methods for product attributes
    public String getProductCode() throws RemoteException;

    public String getName() throws RemoteException;

    public String getDescription() throws RemoteException;

    public int getQuantity() throws RemoteException;

    public double getRetailPrice() throws RemoteException;

    public double getStorePrice() throws RemoteException;

    // Method to view product details
    public String viewProduct() throws RemoteException;
}
