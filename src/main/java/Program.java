import models.Product;
import models.Repository;
import models.User;

import java.util.Date;
import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User u1 = new User(UUID.randomUUID(), "Alexandre", 28, "alex@gmail.com", "123456");
        System.out.println(u1);

        Repository r1 = new Repository();
        Product p1 = new Product(UUID.randomUUID(), "Voiture Tesla", 43800, new Date());
//        Product p2 = new Product(p1.getId(), "Chapeau", 2, new Date());
        try {
            r1.addProduct(p1);
//            r1.addProduct(p2);
            System.out.println("1 -- "+r1);
            System.out.println("2 -- "+r1.getProductById(p1.getId()));
//            r1.deleteProductById(p1.getId());
//            System.out.println("3 -- "+r1);
            r1.updateProduct(p1.getId(), "Model 3 autonomie Standard Plus");
            System.out.println("3 -- "+r1);
            r1.updateProduct(p1.getId(), 50000.0);
            System.out.println("4 -- "+r1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
