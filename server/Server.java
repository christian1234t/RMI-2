
import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Server {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");

            // Create RMI registry on a specific port
            Registry registry = LocateRegistry.createRegistry(9300);
            System.out.println("Server has been started...");

            // Load and parse the XML file
            File xmlFile = new File("product.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // Get the list of product nodes from the XML
            NodeList productList = document.getElementsByTagName("product");
            for (int i = 0; i < productList.getLength(); i++) {
                Element productElement = (Element) productList.item(i);

                // Extract product details from XML
                String code = productElement.getElementsByTagName("code").item(0).getTextContent();
                String name = productElement.getElementsByTagName("name").item(0).getTextContent();
                String description = productElement.getElementsByTagName("description").item(0).getTextContent();
                double retailPrice = Double
                        .parseDouble(productElement.getElementsByTagName("retailPrice").item(0).getTextContent());
                double storePrice = Double
                        .parseDouble(productElement.getElementsByTagName("storePrice").item(0).getTextContent());
                int quantity = Integer
                        .parseInt(productElement.getElementsByTagName("quantity").item(0).getTextContent());

                // Create Product object
                Product product = new Product(code, name, description, quantity, retailPrice, storePrice);

                // Export Product object as a remote object
                ProductInterface stub_product = (ProductInterface) UnicastRemoteObject.exportObject(product, 0);

                // Bind the Product object to the RMI registry with the product code as the name
                registry.rebind(code, stub_product);

                System.out.println("Exported product: " + name + " (" + code + ")");
            }

            System.out.println("Exporting and binding of objects has been completed...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
