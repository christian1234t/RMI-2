import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        try {
            // Locate the registry.
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9200);

            // Get the references of exported object from the RMI Registry...
            ProductInterface shoe1 = (ProductInterface) registry.lookup("shoe1");
            ProductInterface shoe2 = (ProductInterface) registry.lookup("shoe2");
            ProductInterface shoe3 = (ProductInterface) registry.lookup("shoe3");
            ProductInterface shoe4 = (ProductInterface) registry.lookup("shoe4");

            CartInterface cart = (CartInterface) registry.lookup("access_cart");

            try (Scanner scanner = new Scanner(System.in)) {
                String userChoice;
                do {
                    System.out.println("Enter the shoe you want to add to the cart: \n1. Nike Air Max\n2. Adidas Ultraboost\n3. Puma RS-X\n4. New Balance 990v5\n5. View Cart\n6. Exit");
                    System.out.print("Enter your choice: ");
                    userChoice = scanner.nextLine();

                    switch (userChoice) {
                        case "1":
                            cart.addProduct(shoe1);
                            System.out.println("Nike Air Max is added to cart!\n");
                            break;
                        case "2":
                            cart.addProduct(shoe2);
                            System.out.println("Adidas Ultraboost is added to cart!\n");
                            break;
                        case "3":
                            cart.addProduct(shoe3);
                            System.out.println("Puma RS-X is added to cart!\n");
                            break;
                        case "4":
                            cart.addProduct(shoe4);
                            System.out.println("New Balance 990v5 is added to cart!\n");
                            break;
                        case "5":
                            System.out.println(cart.viewAddedProducts());
                            break;
                        case "6":
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            break;
                    }
                } while (!userChoice.equals("6"));
            }

        } catch (Exception e) {
            System.out.println("Client side error..." + e);
        }
    }
}
