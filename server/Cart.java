import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Cart implements CartInterface {
    private List<ProductInterface> addedProducts;

    public Cart() {
        this.addedProducts = new ArrayList<>();
    }

    @Override
    public void addProduct(ProductInterface product) {
        addedProducts.add(product);
        System.out.println("\nProduct added to cart!");
    }

    @Override
    public void removeProduct(ProductInterface product) {
        addedProducts.remove(product);
        System.out.println("\nProduct removed from cart!");
    }

    @Override
    public String viewCart() throws RemoteException {
        if (addedProducts.isEmpty()) {
            return "Cart is empty";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Products in cart:\n");
            sb.append("--------------------\n");
            for (ProductInterface product : addedProducts) {
                sb.append("Product Code: ").append(product.getProductCode()).append("\n");
                sb.append("Name: ").append(product.getName()).append("\n");
                sb.append("Description: ").append(product.getDescription()).append("\n");
                sb.append("Quantity: ").append(product.getQuantity()).append("\n");
                sb.append("Retail Price: ").append(product.getRetailPrice()).append("\n");
                sb.append("Store Price: ").append(product.getStorePrice()).append("\n");
                sb.append("--------------------\n");
            }
            return sb.toString();
        }
    }

    @Override
    public double getTotalPrice() throws RemoteException {
        double totalPrice = 0.0;
        for (ProductInterface product : addedProducts) {
            totalPrice += product.getStorePrice();
        }
        return totalPrice;
    }

    @Override
    public String viewAddedProducts() throws RemoteException {
        StringBuilder sb = new StringBuilder();
        sb.append("Added Products:\n");
        sb.append("--------------------\n");
        for (ProductInterface product : addedProducts) {
            sb.append("Name: ").append(product.getName()).append("\n");
            sb.append("Description: ").append(product.getDescription()).append("\n");
            sb.append("Quantity: ").append(product.getQuantity()).append("\n");
            sb.append("Store Price: ").append(product.getStorePrice()).append("\n");
            sb.append("--------------------\n");
        }
        return sb.toString();
    }
}
