import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9200);

            ProductInterface shoe1 = (ProductInterface) registry.lookup("Shoe1");
            ProductInterface shoe2 = (ProductInterface) registry.lookup("Shoe2");
            ProductInterface shoe3 = (ProductInterface) registry.lookup("Shoe3");
            ProductInterface shoe4 = (ProductInterface) registry.lookup("Shoe4");

            System.out.println("\nClient - View Products");
            System.out.println("=====================");
            System.out.println(shoe1.viewProduct() + "\n");
            System.out.println(shoe2.viewProduct() + "\n");
            System.out.println(shoe3.viewProduct() + "\n");
            System.out.println(shoe4.viewProduct() + "\n");
        } catch (Exception e) {
            System.out.println("Client side error..." + e);
        }
    }
}