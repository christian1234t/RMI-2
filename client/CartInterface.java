import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CartInterface extends Remote {
    void addProduct(ProductInterface product) throws RemoteException;

    void removeProduct(ProductInterface product) throws RemoteException;

    String viewCart() throws RemoteException;

    double getTotalPrice() throws RemoteException;

    String viewAddedProducts() throws RemoteException;
}
